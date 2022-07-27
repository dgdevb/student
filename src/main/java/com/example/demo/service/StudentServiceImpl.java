package com.example.demo.service;

import com.example.demo.exception.StudentError;
import com.example.demo.exception.StudentException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new StudentException(StudentError.EMAIL_EXISTS);
        }

        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
        studentRepository.delete(student);
    }

    public Student putStudent(Long id, Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new StudentException(StudentError.EMAIL_EXISTS);
        }

        return this.studentRepository.findById(id).map(studentDb -> {
            studentDb.setEmail(student.getEmail());
            studentDb.setFirstName(student.getFirstName());
            studentDb.setLastName(student.getLastName());
            return studentRepository.save(studentDb);
        }).orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
    }

    public Student patchStudent(Long id, Student student) {
        return null;
    }
}
