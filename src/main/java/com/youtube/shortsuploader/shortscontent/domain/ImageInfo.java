package com.youtube.shortsuploader.shortscontent.domain;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ImageInfo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ImageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "shorts_content_id", foreignKey = @jakarta.persistence.ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Long shortsContentId;

    private String imageUrl;

    private String originalFilename;

    private Integer displayOrder;

    @CreationTimestamp private LocalDateTime createdAt;

    @UpdateTimestamp private LocalDateTime updatedAt;
}
