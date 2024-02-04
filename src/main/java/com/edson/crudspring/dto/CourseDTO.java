package com.edson.crudspring.dto;

import com.edson.crudspring.model.Lesson;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.List;


public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5, max = 100)
        String name,
        @NotNull @Length(max = 10) @Pattern(regexp = "Back-end|Front-end") @Column(length = 10, nullable = false)
        String category, List<Lesson> lessons) {

}
