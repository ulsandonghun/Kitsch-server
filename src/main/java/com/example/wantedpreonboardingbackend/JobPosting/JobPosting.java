package com.example.wantedpreonboardingbackend.JobPosting;

import com.example.wantedpreonboardingbackend.Company.Company;
import com.example.wantedpreonboardingbackend.User.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"applicants", "jobApplications"})
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private double reward;
    private String description;
    private String requiredSkills;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Company company;

    @ManyToMany
    @JoinTable(name = "user_job_applications",
            joinColumns = @JoinColumn(name = "job_posting_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIdentityReference(alwaysAsId = true)
    private List<User> applicants;


}
