package com.youtube.shortsuploader.shortscontent.domain;

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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "shorts_contents")
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
    private ContentStatus status;

    @CreationTimestamp private LocalDateTime createdAt;

    @UpdateTimestamp private LocalDateTime updatedAt;

    // 비즈니스 로직
    public boolean canGenerateVideo() {
        return !images.isEmpty() && propertyDetails != null;
    }

    public void addImage(String imageUrl, String originalFilename, Long fileSize) {
        ContentImageInfo imageInfo =
                ContentImageInfo.builder()
                        .imageUrl(imageUrl)
                        .originalFilename(originalFilename)
                        .uploadedAt(LocalDateTime.now())
                        .build();
        images.add(imageInfo);
    }

    public void removeImage(int index) {
        if (index >= 0 && index < images.size()) {
            images.remove(index);
        }
    }

    public void reorderImages(List<Integer> newOrder) {
        List<ContentImageInfo> reorderedImages = new ArrayList<>();
        for (int index : newOrder) {
            if (index >= 0 && index < images.size()) {
                reorderedImages.add(images.get(index));
            }
        }
        images.clear();
        images.addAll(reorderedImages);
    }

    public void markAsVideoGenerated(String videoUrl, Integer durationSeconds) {
        this.videoInfo =
                VideoInfo.builder()
                        .generatedVideoUrl(videoUrl)
                        .durationSeconds(durationSeconds)
                        .generatedAt(LocalDateTime.now())
                        .build();
        this.status = ContentStatus.READY_TO_UPLOAD;
    }

    public void markAsUploadedToYouTube(String youtubeVideoId, String youtubeShortsUrl) {
        this.videoInfo.addYouTubeInfo(youtubeVideoId, youtubeShortsUrl);
        this.status = ContentStatus.COMPLETED;
    }
}
