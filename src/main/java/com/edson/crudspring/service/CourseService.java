package com.edson.crudspring.service;

import com.edson.crudspring.model.Course;
import com.edson.crudspring.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CourseService
{
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public  List<Course> list() {
        return courseRepository.findAll();
    }
}
