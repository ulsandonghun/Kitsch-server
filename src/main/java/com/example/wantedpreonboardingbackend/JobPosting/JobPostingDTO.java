package com.example.wantedpreonboardingbackend.JobPosting;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobPostingDTO {

    private Long 회사_id; // JSON 요청의 "회사_id"와 일치시킴
    private String 채용포지션;
    private double 채용보상금;
    private String 채용내용;
    private String 사용기술;

}
