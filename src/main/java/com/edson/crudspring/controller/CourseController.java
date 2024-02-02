package com.edson.crudspring.controller;

import com.edson.crudspring.model.Course;
import com.edson.crudspring.repository.CourseRepository;
import com.edson.crudspring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public @ResponseBody List<Course> list() {
        return courseService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") @NotNull @Positive Long id) {
        return courseService.findById(id).map(recordFound -> ResponseEntity.ok().body(recordFound)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody @Valid Course course) {
        return courseService.create(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable("id") @NotNull @Positive Long id, @Valid @RequestBody Course course) {
        return courseService.update(id, course).map(recordFound -> {
            return ResponseEntity.ok().body(recordFound);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") @NotNull @Positive Long id) {

        if (courseService.delete(id)) {
            return ResponseEntity.noContent().<Void>build();
        }
        return ResponseEntity.notFound().build();
    }
}
