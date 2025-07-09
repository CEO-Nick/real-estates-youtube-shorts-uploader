package com.youtube.shortsuploader.shortscontent.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class PropertyDetails {
    // **아파트
    private String name;

    // **동
    private Integer dongNumber;

    // **호
    private Integer hoNumber;

    // 7억 8천 5백 -> 785,000,000
    private Long salePrice;

    // 매물 타입
    private String type;

    // 매물 특징
    private String specialFeatures;
}
