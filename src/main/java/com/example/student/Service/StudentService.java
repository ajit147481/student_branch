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
        List<Branch> branchList=branchRepository.findAll(Sort.by(Sort.Direction.DESC,"passing_students"));
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

    public List<Integer> getStudentsRollNo() {
        List<Branch> branchList=branchRepository.findAll(Sort.by(Sort.Direction.DESC,"year"));
        List<Integer> rollnoList=new ArrayList<>();
        int recent_Year=branchList.get(0).getYear();
        for(Branch branch:branchList){
            if(branch.getYear()!=recent_Year){
                break;
            }
            List<Student> studentList=new ArrayList<>();
            for(Student student:studentList){
                rollnoList.add(student.getRollno());
            }
        }
        return rollnoList;
    }

    public int find_Grant() {
        List<Branch> branchList=branchRepository.findAll(Sort.by(Sort.Direction.DESC,"passing_students"));
        return branchList.get(0).getGrant();
    }
}
