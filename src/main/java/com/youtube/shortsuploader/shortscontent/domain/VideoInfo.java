package com.youtube.shortsuploader.shortscontent.domain;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoInfo {

    private String generatedVideoUrl;

    private String youtubeShortsUrl;

    private String youtubeVideoId;

    private LocalDateTime generatedAt;

    private LocalDateTime uploadedAt;

    private Integer durationSeconds;

    // 비즈니스 로직
    public boolean isVideoGenerated() {
        return generatedVideoUrl != null;
    }

    public boolean isUploadedToYouTube() {
        return youtubeShortsUrl != null;
    }

    // 유튜브 정보 추가 (기존 객체 수정)
    public void addYouTubeInfo(String youtubeVideoId, String youtubeShortsUrl) {
        this.youtubeVideoId = youtubeVideoId;
        this.youtubeShortsUrl = youtubeShortsUrl;
        this.uploadedAt = LocalDateTime.now();
    }
}
