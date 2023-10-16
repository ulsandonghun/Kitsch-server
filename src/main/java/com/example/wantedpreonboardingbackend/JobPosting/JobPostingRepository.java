package com.example.wantedpreonboardingbackend.JobPosting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting,Long> {
    List<JobPosting> findByCompanyContainingOrPositionContainingOrDescriptionContainingOrRequiredSkillsContaining(
            String company, String position, String description, String requiredSkills
    );
}

