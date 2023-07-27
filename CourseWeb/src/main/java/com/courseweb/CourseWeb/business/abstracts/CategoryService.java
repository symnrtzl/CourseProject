package com.courseweb.CourseWeb.business.abstracts;

import com.courseweb.CourseWeb.entities.Category;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getById(int id);

    void add(Category category);

    void update(Category category);

    void delete(int id);

}
