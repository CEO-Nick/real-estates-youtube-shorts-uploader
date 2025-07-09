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
}
