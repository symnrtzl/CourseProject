package com.courseweb.CourseWeb.dao;

import com.courseweb.CourseWeb.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Integer> {
}
