package com.courseweb.CourseWeb.controller;

import com.courseweb.CourseWeb.business.abstracts.CourseService;
import com.courseweb.CourseWeb.business.abstracts.InstructorService;
import com.courseweb.CourseWeb.entities.Course;
import com.courseweb.CourseWeb.entities.Instructor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mycourse/instructor")
@AllArgsConstructor
public class InstructorController {
    private InstructorService instructorService;


    @GetMapping("/getall")
    public List<Instructor> getAll(){
        return instructorService.getAll();
    }

    @GetMapping("/getall/{id}")
    public Instructor getById(@PathVariable int id){
        return instructorService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody() @Valid() Instructor instructor){
        this.instructorService.add(instructor);
    }

    @PutMapping("/update")
    public void update(@RequestBody Instructor instructor){
        this.instructorService.update(instructor);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.instructorService.delete(id);
    }
}
