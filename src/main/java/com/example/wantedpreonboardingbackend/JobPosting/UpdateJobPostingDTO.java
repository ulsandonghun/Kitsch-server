package com.example.wantedpreonboardingbackend.JobPosting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateJobPostingDTO {
    private Long jobPostingId; // 채용공고 ID
    private String position;
    private double reward;
    private String description;
    private String skills;
}
