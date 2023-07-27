package com.courseweb.CourseWeb.business.abstracts;

import com.courseweb.CourseWeb.entities.Category;
import com.courseweb.CourseWeb.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();

    Course getById(int id);

    void add(Course course);

    void update(Course course);

    void delete(int id);
}
