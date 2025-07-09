package com.youtube.shortsuploader.shortscontent.domain;

import static com.youtube.shortsuploader.shortscontent.domain.ContentStatus.READY_TO_GENERATE;

import com.youtube.shortsuploader.member.domain.RealEstateProfile;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "shorts_contents")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortsContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Embedded private RealEstateProfile realEstateProfile;

    @Embedded private PropertyDetails propertyDetails;

    @Embedded private VideoInfo videoInfo;

    @Enumerated(EnumType.STRING)
    private ContentStatus status = READY_TO_GENERATE;

    @CreationTimestamp private LocalDateTime createdAt;

    @UpdateTimestamp private LocalDateTime updatedAt;
}
