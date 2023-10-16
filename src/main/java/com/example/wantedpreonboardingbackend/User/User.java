package com.example.wantedpreonboardingbackend.User;

import com.example.wantedpreonboardingbackend.JobPosting.JobPosting;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties("jobApplications")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @ManyToMany(mappedBy = "applicants")
    @JsonIdentityReference(alwaysAsId = true)
    private List<JobPosting> jobApplications;


}