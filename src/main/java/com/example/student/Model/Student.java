package com.example.student.Model;

import com.example.student.Model.BranchName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int rollno;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;
    private int marks;
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("studentList")
    private Branch branch;
}
