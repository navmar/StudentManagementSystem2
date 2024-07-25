package com.example.StudentManagementSystem.Services;

import com.example.StudentManagementSystem.Entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService
{
    Student createStudent(Student student);

    Student getStudentById(Long id);

    ResponseEntity<String> deleteStudent(Long id);

    List<Student> listAllStudents();

    Student updateStudent(Long id, Student updatedStudent);
}
