package com.courseweb.CourseWeb.business.abstracts;

import com.courseweb.CourseWeb.entities.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> getAll();

    Instructor getById(int id);

    void add(Instructor instructor);

    void update(Instructor instructor);

    void delete(int id);
}
