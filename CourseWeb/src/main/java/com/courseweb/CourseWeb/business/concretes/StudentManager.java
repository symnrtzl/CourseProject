package com.courseweb.CourseWeb.business.concretes;

import com.courseweb.CourseWeb.business.abstracts.StudentService;
import com.courseweb.CourseWeb.core.mappers.ModelMapperService;
import com.courseweb.CourseWeb.dao.StudentDao;
import com.courseweb.CourseWeb.entities.Instructor;
import com.courseweb.CourseWeb.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentManager implements StudentService {

    private ModelMapper modelMapper;
    private StudentDao studentDao;

    @Override
    public List<Student> getAll() {
        List<Student> students=studentDao.findAll();
        List<Student> studentList=students.stream().map(student -> this.modelMapper.map(student,Student.class)).collect(Collectors.toList());
        return studentList;
    }

    @Override
    public Student getById(int id) {
        Student student=this.studentDao.findById(id).get();
        Student studentId=this.modelMapper.map(student,Student.class);
        return studentId;
    }

    @Override
    public void add(Student student) {
        Student addStudent=this.modelMapper.map(student,Student.class);
        this.studentDao.save(addStudent);
    }

    @Override
    public void update(Student student) {
        Student existingStudent=studentDao.findById(student.getId()).get();
        existingStudent.setCourse(student.getCourse());
        existingStudent.setUser(student.getUser());
        this.studentDao.save(existingStudent);
    }

    @Override
    public void delete(int id) {
        this.studentDao.deleteById(id);
    }
}
