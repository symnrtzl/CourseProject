package com.courseweb.CourseWeb.business.concretes;

import com.courseweb.CourseWeb.business.abstracts.CourseService;
import com.courseweb.CourseWeb.core.mappers.ModelMapperService;
import com.courseweb.CourseWeb.dao.CourseDao;
import com.courseweb.CourseWeb.entities.Category;
import com.courseweb.CourseWeb.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseManager implements CourseService {

    private ModelMapper modelMapper;
    private CourseDao courseDao;


    @Override
    public List<Course> getAll() {
        List<Course> courses=courseDao.findAll();
        List<Course> courseList=courses.stream().map(course -> this.modelMapper.map(course,Course.class)).collect(Collectors.toList());
        return courseList;
    }

    @Override
    public Course getById(int id) {
        Course course=this.courseDao.findById(id).get();
        Course courseId=this.modelMapper.map(course,Course.class);
        return courseId;
    }

    @Override
    public void add(Course course) {
        Course addCourse=this.modelMapper.map(course,Course.class);
        this.courseDao.save(addCourse);
    }

    @Override
    public void update(Course course) {
        Course existingcourse=courseDao.findById(course.getId()).get();
        existingcourse.setName(course.getName());
        existingcourse.setCourseAbout(course.getCourseAbout());
        existingcourse.setDate(course.getDate());
        existingcourse.setCategory(course.getCategory());
        this.courseDao.save(existingcourse);
    }

    @Override
    public void delete(int id) {
        this.courseDao.deleteById(id);
    }
}
