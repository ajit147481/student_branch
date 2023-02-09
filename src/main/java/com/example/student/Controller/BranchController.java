package com.example.student.Controller;

import com.example.student.Model.Branch;
import com.example.student.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class BranchController {
    @Autowired
    BranchService branchService;
    @PostMapping("/add_branch")
    public ResponseEntity<String> add_branch(@RequestBody Branch branch){
        branchService.addBranch(branch);
        return new ResponseEntity<>("branch updated successfully", HttpStatus.OK);
    }
}
