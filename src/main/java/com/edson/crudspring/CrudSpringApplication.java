package com.edson.crudspring;

import com.edson.crudspring.model.Course;
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
//            courseRepository.deleteAll();
//
//            Course c = new Course();
//            c.setName("Angular com Spring");
//            c.setCategory("Front-end");
//            courseRepository.save(c);
//
//            Course d = new Course();
//            d.setName("Java");
//            d.setCategory("Back-end");
//            courseRepository.save(d);
//
//            Course e = new Course();
//            e.setName("JavaScript");
//            e.setCategory("Back-end");
//            courseRepository.save(e);
//
//            Course f = new Course();
//            f.setName("Vue");
//            f.setCategory("Front-end");
//            courseRepository.save(f);
//
//            Course g = new Course();
//            g.setName("React Js");
//            g.setCategory("Front-end");
//            courseRepository.save(g);
//
//            Course h = new Course();
//            h.setName("Pyton");
//            h.setCategory("Back-end");
//            courseRepository.save(h);

//            for (int i = 0; i < 9999; i++) {
//                Course j = new Course();
//                j.setName("Pyton -- " + i);
//                if (i % 2 == 0) {
//                    j.setCategory("back-end");
//                } else {
//                    j.setCategory("front-end");
//                }
//
//                courseRepository.save(j);
//            }

        };
    }
}
