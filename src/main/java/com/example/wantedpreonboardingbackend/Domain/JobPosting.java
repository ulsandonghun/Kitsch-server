package com.example.wantedpreonboardingbackend.Domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private double reward;
    private String description;
    private String requiredSkills;

    @ManyToOne
    private Company company;

    @ManyToMany
    @JoinTable(name = "user_job_applications",
            joinColumns = @JoinColumn(name = "job_posting_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> applicants;

    // Getter와 Setter 메서드
}
