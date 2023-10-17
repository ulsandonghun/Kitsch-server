package com.example.wantedpreonboardingbackend.JobPosting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting,Long> {
    List<JobPosting> findByCompanyCompanyNameContaining(String companyName);
    List<JobPosting> findByPositionContaining(String search);
    List<JobPosting> findByDescriptionContaining(String search);
    List<JobPosting> findByRequiredSkillsContaining(String search);

    @Query("SELECT jp.id FROM JobPosting jp WHERE jp.company.id = :companyId AND jp.id != :jobId")
    List<Long> findOtherJobPostings(@Param("companyId") Long companyId, @Param("jobId") Long jobId);

}



