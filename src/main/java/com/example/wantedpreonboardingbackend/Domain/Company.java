package com.example.wantedpreonboardingbackend.Domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String country;
    private String region;

    @OneToMany(mappedBy = "company")
    private List<JobPosting> jobPostings;

    // Getter와 Setter 메서드
}
