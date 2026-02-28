package com.shubham.student_api_challenge.controller;

import com.shubham.student_api_challenge.Repository.StudentRepository;
import com.shubham.student_api_challenge.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")//base url set
public class studentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
        Student savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);

    }

    @GetMapping("/count")
    public long studCount(){
       return studentRepository.count();
    }
}
