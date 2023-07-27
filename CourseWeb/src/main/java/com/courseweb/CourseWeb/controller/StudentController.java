package com.courseweb.CourseWeb.controller;

import com.courseweb.CourseWeb.business.abstracts.InstructorService;
import com.courseweb.CourseWeb.business.abstracts.StudentService;
import com.courseweb.CourseWeb.entities.Instructor;
import com.courseweb.CourseWeb.entities.Student;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("mycourse/student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;


    @GetMapping("/getall")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/getall/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody() @Valid() Student student){
        this.studentService.add(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        this.studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.studentService.delete(id);
    }
}
