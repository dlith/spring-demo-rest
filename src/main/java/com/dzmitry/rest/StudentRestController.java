package com.dzmitry.rest;

import com.dzmitry.entity.Student;
import com.dzmitry.exception_handling.StudentErrorResponse;
import com.dzmitry.exception_handling.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("John", "Snow"));
        students.add(new Student("Kaitlin", "Stark"));
        students.add(new Student("Mary", "Stark"));
    }

    @GetMapping("/students")
    public List<Student> students(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student student(@PathVariable int studentId){
        if( (studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
}
