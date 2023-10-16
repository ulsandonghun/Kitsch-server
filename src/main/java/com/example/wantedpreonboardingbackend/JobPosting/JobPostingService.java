package com.example.wantedpreonboardingbackend.JobPosting;

import com.example.wantedpreonboardingbackend.Company.Company;
import com.example.wantedpreonboardingbackend.Company.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public JobPostingService(JobPostingRepository jobPostingRepository, CompanyRepository companyRepository) {
        this.jobPostingRepository = jobPostingRepository;
        this.companyRepository = companyRepository;
    }

    public JobPosting createJobPosting(JobPostingDTO jobPostingDTO) {
        Company company = companyRepository.findById(jobPostingDTO.get회사_id())
                .orElseThrow(() -> new EntityNotFoundException("등록된 회사가 아닙니다. 회사를 먼저 등록해주세요"));

        JobPosting jobPosting = new JobPosting();
        jobPosting.setCompany(company);
        jobPosting.setPosition(jobPostingDTO.get채용포지션());
        jobPosting.setReward(jobPostingDTO.get채용보상금());
        jobPosting.setDescription(jobPostingDTO.get채용내용());
        jobPosting.setRequiredSkills(jobPostingDTO.get사용기술());

        return jobPostingRepository.save(jobPosting);
    }
}
