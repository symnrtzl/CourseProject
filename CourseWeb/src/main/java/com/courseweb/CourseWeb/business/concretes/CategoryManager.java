package com.courseweb.CourseWeb.business.concretes;

import com.courseweb.CourseWeb.business.abstracts.CategoryService;
import com.courseweb.CourseWeb.core.mappers.ModelMapperService;
import com.courseweb.CourseWeb.dao.CategoryDao;
import com.courseweb.CourseWeb.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private ModelMapper modelMapper;
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        List<Category> categories=categoryDao.findAll();
        List<Category> categoryList=categories.stream().map(category -> this.modelMapper.map(category,Category.class)).collect(Collectors.toList());
        return categoryList;
    }

    @Override
    public Category getById(int id) {
        Category category=this.categoryDao.findById(id).get();
        Category categoryId=this.modelMapper.map(category,Category.class);
        return categoryId;
    }

    @Override
    public void add(Category category) {
        Category addCategory=this.modelMapper.map(category,Category.class);
        this.categoryDao.save(addCategory);
    }

    @Override
    public void update(Category category) {
        Category existingcategory=categoryDao.findById(category.getId()).get();
        existingcategory.setCategoryName(category.getCategoryName());
        existingcategory.setCourses(category.getCourses());
        this.categoryDao.save(existingcategory);
    }

    @Override
    public void delete(int id) {
        this.categoryDao.deleteById(id);
    }


}
