package com.example.wantedpreonboardingbackend.JobPosting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
