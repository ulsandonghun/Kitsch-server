package com.example.wantedpreonboardingbackend.JobPosting;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class JobPostingDetailDTO {
    private Long jobId;
    private String companyName;
    private String country;
    private String location;
    private String position;
    private double reward;
    private String requiredSkills;
    private String description;
    private List<Long> otherJobPostings;

}
