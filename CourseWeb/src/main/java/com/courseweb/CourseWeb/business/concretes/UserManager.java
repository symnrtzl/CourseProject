package com.courseweb.CourseWeb.business.concretes;

import com.courseweb.CourseWeb.business.abstracts.UserService;
import com.courseweb.CourseWeb.core.mappers.ModelMapperService;
import com.courseweb.CourseWeb.dao.UserDao;
import com.courseweb.CourseWeb.entities.Student;
import com.courseweb.CourseWeb.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserManager implements UserService {

    private ModelMapper modelMapper;
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        List<User> users=userDao.findAll();
        List<User> userList=users.stream().map(user -> this.modelMapper.map(user,User.class)).collect(Collectors.toList());
        return userList;
    }

    @Override
    public User getById(int id) {
        User user=this.userDao.findById(id).get();
        User userId=this.modelMapper.map(user,User.class);
        return userId;
    }

    @Override
    public void add(User user) {
        User addUser= this.modelMapper.map(user,User.class);
        this.userDao.save(addUser);
    }

    @Override
    public void update(User user) {
        User existingUser=userDao.findById(user.getId()).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setInstructors(user.getInstructors());
        existingUser.setStudents(user.getStudents());
        this.userDao.save(existingUser);
    }

    @Override
    public void delete(int id) {
        this.userDao.deleteById(id);
    }
}
