package com.courseweb.CourseWeb.business.abstracts;

import com.courseweb.CourseWeb.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(int id);

    void add(User user);

    void update(User user);

    void delete(int id);
}
