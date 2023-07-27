package com.courseweb.CourseWeb.controller;

import com.courseweb.CourseWeb.business.abstracts.StudentService;
import com.courseweb.CourseWeb.business.abstracts.UserService;
import com.courseweb.CourseWeb.entities.Student;
import com.courseweb.CourseWeb.entities.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("mycourse/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;


    @GetMapping("/getall")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getall/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody() @Valid() User user){
        this.userService.add(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        this.userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.userService.delete(id);
    }
}
