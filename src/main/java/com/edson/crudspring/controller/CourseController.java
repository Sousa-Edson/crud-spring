package com.edson.crudspring.controller;

import com.edson.crudspring.model.Course;
import com.edson.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping
    public @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
//        @PostMapping
//        public ResponseEntity<Course> create(@RequestBody Course course) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
//        }
    }
}
