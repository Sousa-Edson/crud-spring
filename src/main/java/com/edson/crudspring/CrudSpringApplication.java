package com.edson.crudspring;

import com.edson.crudspring.enums.Category;
import com.edson.crudspring.model.Course;
import com.edson.crudspring.model.Lesson;
import com.edson.crudspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDataBase(CourseRepository courseRepository) {
        return args -> {
            courseRepository.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory(Category.BACK_END);

            Lesson  l = new Lesson();
            l.setName("Primeira aula");
            l.setYoutubeUrl("watch?v=QH2-TGUlwu4");
            l.setCourse(c);
            c.getLessons().add(l);

            Lesson  j = new Lesson();
            j.setName("Segunda aula");
            j.setYoutubeUrl("watch?v=QH2-u4332");
            j.setCourse(c);
            c.getLessons().add(j);

            courseRepository.save(c);



        };
    }
}
