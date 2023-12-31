package com.example.wantedpreonboardingbackend.JobPosting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/job-postings")
public class JobPostingController {
    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPostingDTO jobPostingDTO) {
        JobPosting jobPosting = jobPostingService.createJobPosting(jobPostingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPosting);
    }
    @PutMapping("/{jobPostingId}")
    public ResponseEntity<JobPosting> updateJobPosting(
            @PathVariable Long jobPostingId,
            @RequestBody UpdateJobPostingDTO updateJobPostingDTO) {
        JobPosting updatedJobPosting = jobPostingService.updateJobPosting(jobPostingId, updateJobPostingDTO);
        return ResponseEntity.ok(updatedJobPosting);
    }
    @DeleteMapping("/{jobPostingId}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long jobPostingId) {
        jobPostingService.deleteJobPosting(jobPostingId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);
    }

    @GetMapping("/search-by-company")
    public ResponseEntity<List<JobPosting>> searchJobPostingsByCompany(@RequestParam("companyName") String companyName) {
        List<JobPosting> jobPostings = jobPostingService.searchJobPostingsByCompany(companyName);
        return ResponseEntity.ok(jobPostings);
    }
    @GetMapping("/search")
    public ResponseEntity<List<JobPosting>> searchJobPostings(@RequestParam("search") String search) {
        List<JobPosting> jobPostings = jobPostingService.searchJobPostings(search);

        return ResponseEntity.ok(jobPostings);
    }
    @GetMapping("/{jobId}")
    public ResponseEntity<JobPostingDetailDTO> getJobPostingDetails(@PathVariable("jobId") Long jobId) {
        JobPostingDetailDTO jobPostingDetailDTO = jobPostingService.getJobPostingDetails(jobId);

        if (jobPostingDetailDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(jobPostingDetailDTO);
    }
}
