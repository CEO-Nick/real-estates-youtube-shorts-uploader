package com.youtube.shortsuploader.shortscontent.domain;

import static com.youtube.shortsuploader.shortscontent.domain.ContentStatus.READY_TO_GENERATE;

import com.youtube.shortsuploader.member.domain.RealEstateProfile;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @Embedded private RealEstateProfile realEstateProfile; // 디폴트 부동산 정보

    @Embedded private PropertyDetails propertyDetails; // 매물 상세 정보

    @ElementCollection
    @CollectionTable(name = "shorts_content_images")
    @OrderColumn(name = "display_order")
    private List<ContentImageInfo> images = new ArrayList<>();

    @Embedded private VideoInfo videoInfo; // 동영상 관련 정보

    @Enumerated(EnumType.STRING)
    private ContentStatus status = READY_TO_GENERATE;

    @CreationTimestamp private LocalDateTime createdAt;

    @UpdateTimestamp private LocalDateTime updatedAt;
}
