package com.courseweb.CourseWeb.dao;

import com.courseweb.CourseWeb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
