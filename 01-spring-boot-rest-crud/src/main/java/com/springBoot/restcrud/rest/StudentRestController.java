package com.springBoot.restcrud.rest;

import com.springBoot.restcrud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        // create some sample hardcoded students
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Poonam", "Patel"));
        theStudents.add(new Student("Harsh", "Patel"));
        theStudents.add((new Student("Roshni", "Arora")));

         return theStudents;
    }

}
