package com.courseweb.CourseWeb.controller;

import com.courseweb.CourseWeb.business.abstracts.CategoryService;
import com.courseweb.CourseWeb.entities.Category;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mycourse/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/getall")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/getall/{id}")
    public Category getById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody() @Valid() Category category){
        this.categoryService.add(category);
    }

    @PutMapping("/update")
    public void update(@RequestBody Category category){
        this.categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.categoryService.delete(id);
    }
}
