package com.courseweb.CourseWeb.dao;

import com.courseweb.CourseWeb.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
