package com.edson.crudspring.controller;

import com.edson.crudspring.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @GetMapping
    public List<Course> list(){
        return null;
    }
}
