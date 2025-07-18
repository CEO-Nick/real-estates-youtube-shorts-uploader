package com.youtube.shortsuploader.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private AuthPlatform platform;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Embedded private RealEstateProfile realEstateProfile;

    @CreationTimestamp private LocalDateTime createdAt;

    @UpdateTimestamp private LocalDateTime updatedAt;
}
