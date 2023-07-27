package com.courseweb.CourseWeb.dao;

import com.courseweb.CourseWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
