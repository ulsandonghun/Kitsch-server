package com.example.wantedpreonboardingbackend.UserHistory;

import com.example.wantedpreonboardingbackend.JobPosting.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    @Query("SELECT CASE WHEN COUNT(H) > 0 THEN true ELSE false END FROM UserHistory H WHERE H.user.id = :userId AND H.jobPosting.id = :jobPostingId")
    boolean existsByuserhistoryJobPostingIdAndId(@Param("jobPostingId") Long jobPostingId, @Param("userId") Long userId);

}
