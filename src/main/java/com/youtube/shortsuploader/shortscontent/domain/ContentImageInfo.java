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
public class ContentImageInfo {
    private String imageUrl;

    private String originalFilename;

    private LocalDateTime uploadedAt;
}
