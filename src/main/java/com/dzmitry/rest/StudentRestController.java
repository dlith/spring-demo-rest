package com.dzmitry.rest;

import com.dzmitry.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return students.get(studentId);
    }
}
