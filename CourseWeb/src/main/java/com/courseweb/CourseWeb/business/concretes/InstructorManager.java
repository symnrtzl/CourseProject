package com.courseweb.CourseWeb.business.concretes;

import com.courseweb.CourseWeb.business.abstracts.InstructorService;
import com.courseweb.CourseWeb.core.mappers.ModelMapperService;
import com.courseweb.CourseWeb.dao.InstructorDao;
import com.courseweb.CourseWeb.entities.Course;
import com.courseweb.CourseWeb.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorManager implements InstructorService {

    private ModelMapper modelMapper;
    private InstructorDao instructorDao;

    @Override
    public List<Instructor> getAll() {
        List<Instructor> instructors=instructorDao.findAll();
        List<Instructor> instructorList=instructors.stream().map(instructor -> this.modelMapper.map(instructor,Instructor.class)).collect(Collectors.toList());
        return instructorList;
    }

    @Override
    public Instructor getById(int id) {
        Instructor instructor=this.instructorDao.findById(id).get();
        Instructor instructorId=this.modelMapper.map(instructor,Instructor.class);
        return instructorId;
    }

    @Override
    public void add(Instructor instructor) {
        Instructor addInstructor=this.modelMapper.map(instructor,Instructor.class);
        this.instructorDao.save(addInstructor);
    }

    @Override
    public void update(Instructor instructor) {
        Instructor existingInstructor=instructorDao.findById(instructor.getId()).get();
        existingInstructor.setCourse(instructor.getCourse());
        existingInstructor.setUser(instructor.getUser());
        this.instructorDao.save(existingInstructor);

    }

    @Override
    public void delete(int id) {
        this.instructorDao.deleteById(id);
    }
}
