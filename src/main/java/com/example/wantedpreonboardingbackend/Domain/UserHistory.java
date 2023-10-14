package com.example.wantedpreonboardingbackend.Domain;

import jakarta.persistence.*;

@Entity
public class UserHistory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private JobPosting jobPosting;

    // Getter와 Setter 메서드
}
