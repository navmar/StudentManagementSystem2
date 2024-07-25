package com.example.StudentManagementSystem.Controllers;

import com.example.StudentManagementSystem.Entities.Student;
import com.example.StudentManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("POST/students")

    public ResponseEntity<Student> createStudent(@RequestBody Student studentIn)
    {
        Student createdStudent = studentService.createStudent(studentIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent); //method chaining
    }

    @GetMapping("GET/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id)
    {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("DELETE/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id)
    {
        return studentService.deleteStudent(id);
    }

    @GetMapping("GET/students")
    public List<Student> listAllStudents()
    {
        return studentService.listAllStudents();
    }

    @PutMapping("PUT/students/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student updatedStudent)
    {

        return studentService.updateStudent(id, updatedStudent);
    }





}
