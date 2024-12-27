package com.springBoot.restcrud.rest;

import com.springBoot.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data... only once!

    // one class can have only one method for this..
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poonam", "Patel"));
        theStudents.add(new Student("Harsh", "Patel"));
        theStudents.add((new Student("Roshni", "Arora")));

    }

    // define endpoint for "/students" - return a list of students

 /*   @GetMapping("/students")
    public List<Student> getStudents() {

        // create some sample hardcoded students
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Poonam", "Patel"));
        theStudents.add(new Student("Harsh", "Patel"));
        theStudents.add((new Student("Roshni", "Arora")));

         return theStudents;
    }
  */

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint for "/students/{studentID}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list

        // check the studentId against list size
        if(studentId>= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }

  // Added global exception handling using @ControllerAdvice - set up global Exception Handling

     

}
