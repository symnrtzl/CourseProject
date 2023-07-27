package com.courseweb.CourseWeb.business.abstracts;

import com.courseweb.CourseWeb.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student getById(int id);

    void add(Student student);

    void update(Student student);

    void delete(int id);
}
