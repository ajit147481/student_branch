package com.example.student.Service;

import com.example.student.Model.Branch;
import com.example.student.Model.Student;
import com.example.student.Repository.BranchRepository;
import com.example.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BranchRepository branchRepository;
    public List<String> find_HODs() {
        Student student;
        List<Branch> branchList=branchRepository.findAll(Sort.by("passing_students").descending());
        int max_student=branchList.get(0).getPassing_students();
        List<String> hod_Contact=new ArrayList<>();
        int i=0;
        while(i<branchList.size() && max_student>=branchList.get(i).getPassing_students()){
            hod_Contact.add(branchList.get(i).getContactNo());
            i++;
        }
        return hod_Contact;
    }

    public void addStudent(Student student) {
        if(student.getMarks()>=35){
            Branch branch=student.getBranch();
            if(branch.getPassing_students()<0){
                branch.setPassing_students(0);
            }
            branch.setPassing_students(branch.getPassing_students()+1);
            branchRepository.save(branch);
        }
        studentRepository.save(student);
    }
}
