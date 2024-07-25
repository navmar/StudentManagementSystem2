package com.example.StudentManagementSystem.Services;


import com.example.StudentManagementSystem.Entities.Student;
import com.example.StudentManagementSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student)
    {
       return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id)
    {
        return studentRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<String> deleteStudent(Long id)
    {
        studentRepository.deleteById(id);
        return ResponseEntity.status(204).body("");
    }

    @Override
    public List<Student> listAllStudents()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent)
    {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
        {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setAddress(updatedStudent.getAddress());

            return studentRepository.save(existingStudent);

        }
        else return null;

    }
}
