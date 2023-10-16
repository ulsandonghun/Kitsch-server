package com.example.wantedpreonboardingbackend.Company;

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
@JsonIgnoreProperties("jobPostings")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String country;
    private String region;

    @OneToMany(mappedBy = "company")
    @JsonIdentityReference(alwaysAsId = true)
    private List<JobPosting> jobPostings;


}
