package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class studentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/get_hod")
    public ResponseEntity<List<String>> get_HOD(){
        List<String> hod_List=studentService.find_HODs();
        return new ResponseEntity<>(hod_List, HttpStatus.OK);
    }
}
