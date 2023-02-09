package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    HOD_Repository hodRepository;
    public List<String> find_HODs() {
        List<Student> studentList=studentRepository.findAll();
        List<Branch> branchList=hodRepository.findAll();


    }
}
