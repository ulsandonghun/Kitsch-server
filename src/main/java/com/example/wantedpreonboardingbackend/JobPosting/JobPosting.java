package com.example.wantedpreonboardingbackend.JobPosting;

import com.example.wantedpreonboardingbackend.Company.Company;
import com.example.wantedpreonboardingbackend.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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
