package com.example.student.Service;

import com.example.student.Model.Branch;
import com.example.student.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BranchService {
    @Autowired
    BranchRepository branchRepository;
    public void addBranch(Branch branch) {
        branchRepository.save(branch);
    }
}
