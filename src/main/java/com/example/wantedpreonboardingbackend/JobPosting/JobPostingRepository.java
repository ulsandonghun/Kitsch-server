package com.example.wantedpreonboardingbackend.JobPosting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting,Long> {
    List<JobPosting> findByCompanyCompanyNameContaining(String companyName);
    List<JobPosting> findByPositionContaining(String search);
    List<JobPosting> findByDescriptionContaining(String search);
    List<JobPosting> findByRequiredSkillsContaining(String search);
}



