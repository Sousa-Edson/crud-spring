package com.edson.crudspring.dto.mapper;

import com.edson.crudspring.dto.CourseDTO;
import com.edson.crudspring.dto.LessonDTO;
import com.edson.crudspring.enums.Category;
import com.edson.crudspring.model.Course;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }

        List<LessonDTO> lessons = course.getLessons()
                .stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl())).collect(Collectors.toList());

        return new CourseDTO(course.getId(),
                course.getName(),
                course.getCategory().getValue(),
                lessons);
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        Course course = new Course();
        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(convertCategoryValue(courseDTO.category()));
        return course;
    }

    public Category convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Back-end" -> Category.BACK_END;
            case "Front-end" -> Category.FRONT_END;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }
}
