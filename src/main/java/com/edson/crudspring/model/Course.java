package com.edson.crudspring.model;

import com.edson.crudspring.enums.Category;
import com.edson.crudspring.enums.Status;
import com.edson.crudspring.enums.converters.CategoryConverter;
import com.edson.crudspring.enums.converters.StatusConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "cursos")
@SQLDelete(sql = "UPDATE cursos SET status = 'Inativo' WHERE id = ? ")
@Where(clause = " status = 'Ativo'")
//@SQLRestriction("status <> 'Inativo'")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVO;
}
