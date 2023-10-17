package com.example.wantedpreonboardingbackend.User;

import com.example.wantedpreonboardingbackend.JobPosting.JobPosting;
import com.example.wantedpreonboardingbackend.JobPosting.JobPostingRepository;
import com.example.wantedpreonboardingbackend.UserHistory.UserHistory;
import com.example.wantedpreonboardingbackend.UserHistory.UserHistoryRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository; ;
    private final JobPostingRepository jobPostingRepository;
    private final UserHistoryRepository userHistoryRepository;



    public boolean applyForJob(UserApplicationRequestDTO request) {
        // 지원자 및 채용공고 확인
        User user = userRepository.findById(request.getUserId()).orElse(null);
        JobPosting jobPosting = jobPostingRepository.findById(request.getJobId()).orElse(null);

        if (user == null || jobPosting == null) {
            return false; // 사용자 또는 채용공고를 찾을 수 없음
        }

        // 이미 지원한 채용 공고인지 확인
        boolean alreadyApplied = userHistoryRepository.existsByuserhistoryJobPostingIdAndId(request.getJobId(), request.getUserId());

        if (alreadyApplied) {
            return false; // 이미 해당 채용 공고에 지원함
        }

        // 지원 정보 저장
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setJobPosting(jobPosting);
        userHistoryRepository.save(userHistory);

        return true;
    }
}
