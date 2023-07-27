package com.courseweb.CourseWeb.controller;

import com.courseweb.CourseWeb.business.abstracts.CategoryService;
import com.courseweb.CourseWeb.business.abstracts.CourseService;
import com.courseweb.CourseWeb.entities.Category;
import com.courseweb.CourseWeb.entities.Course;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mycourse/courses")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;


    @GetMapping("/getall")
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/getall/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody() @Valid() Course course){
        this.courseService.add(course);
    }

    @PutMapping("/update")
    public void update(@RequestBody Course course){
        this.courseService.update(course);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.courseService.delete(id);
    }
}
