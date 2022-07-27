package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student addStudent(Student student);

    Student getStudent(Long id);

    void deleteStudent(Long id);

    Student putStudent(Long id, Student student);

    Student patchStudent(Long id, Student student);

}
