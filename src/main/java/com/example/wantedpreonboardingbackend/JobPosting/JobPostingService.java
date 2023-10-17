package com.example.wantedpreonboardingbackend.JobPosting;

import com.example.wantedpreonboardingbackend.Company.Company;
import com.example.wantedpreonboardingbackend.Company.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public JobPosting updateJobPosting(Long jobPostingId, UpdateJobPostingDTO updateJobPostingDTO) {
        JobPosting jobPosting = jobPostingRepository.findById(jobPostingId)
                .orElseThrow(() -> new EntityNotFoundException("채용공고를 찾을 수 없습니다."));

        if (updateJobPostingDTO.getPosition() != null) {
            jobPosting.setPosition(updateJobPostingDTO.getPosition());
        }
        if (updateJobPostingDTO.getReward() > 0) {
            jobPosting.setReward(updateJobPostingDTO.getReward());
        }
        if (updateJobPostingDTO.getDescription() != null) {
            jobPosting.setDescription(updateJobPostingDTO.getDescription());
        }
        if (updateJobPostingDTO.getSkills() != null) {
            jobPosting.setRequiredSkills(updateJobPostingDTO.getSkills());
        }

        return jobPostingRepository.save(jobPosting);
    }


    public void deleteJobPosting(Long jobPostingId) {
        JobPosting jobPosting = jobPostingRepository.findById(jobPostingId)
                .orElseThrow(() -> new EntityNotFoundException("채용공고를 찾을 수 없습니다."));

        jobPostingRepository.delete(jobPosting);
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }


    public List<JobPosting> searchJobPostingsByCompany(String companyName) {
        return jobPostingRepository.findByCompanyCompanyNameContaining(companyName);
    }

    public List<JobPosting> searchJobPostings(String search) {
        List<JobPosting> results = new ArrayList<>();
        results.addAll(jobPostingRepository.findByCompanyCompanyNameContaining(search));
        results.addAll(jobPostingRepository.findByPositionContaining(search));
        results.addAll(jobPostingRepository.findByDescriptionContaining(search));
        results.addAll(jobPostingRepository.findByRequiredSkillsContaining(search));
        Set<JobPosting>  set= new HashSet<>(results);
        List<JobPosting> list = new ArrayList<>(set);
        return list;
    }
}
