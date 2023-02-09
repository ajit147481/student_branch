package com.example.student.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;
    private String HODName;
    private String ContactNo;
    private int passing_students;
    private int year;
    private int grant;
    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("branch")
    private List<Student> studentList;
}
