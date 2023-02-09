package com.example.student.Controller;

import com.example.student.Model.Branch;
import com.example.student.Model.Student;
import com.example.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/add_student")
    public ResponseEntity<String> add_branch(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("branch updated successfully", HttpStatus.OK);
    }
    @GetMapping("/get_rollno")
    public ResponseEntity<List<Integer>> get_rollno(){
        List<Integer> rollnoList=studentService.getStudentsRollNo();
        return new ResponseEntity<>(rollnoList,HttpStatus.OK);
    }
    @GetMapping("/get_max_Grant")
    public ResponseEntity<Integer> find_grant(){
        int grant=studentService.find_Grant();
        return new ResponseEntity<>(grant,HttpStatus.OK);
    }
}
