package com.example.wantedpreonboardingbackend.Domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @ManyToMany(mappedBy = "applicants")
    private List<JobPosting> jobApplications;

    // Getter와 Setter 메서드
}