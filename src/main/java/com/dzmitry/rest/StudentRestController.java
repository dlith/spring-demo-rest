package com.dzmitry.rest;

import com.dzmitry.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> students(){

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Snow"));
        students.add(new Student("Kaitlin", "Stark"));
        students.add(new Student("Mary", "Stark"));

        return students;
    }
}
