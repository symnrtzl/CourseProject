package com.courseweb.CourseWeb.dao;

import com.courseweb.CourseWeb.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDao extends JpaRepository<Instructor,Integer> {
}
