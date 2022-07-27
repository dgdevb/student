package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/students")
public class StudentsController {

    private final StudentServiceImpl studentService;

    public StudentsController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student) {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudents(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudents(@PathVariable Long id) {
        this.studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody @Valid Student student) {
        return this.studentService.putStudent(id, student);
    }

}