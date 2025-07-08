package com.youtube.shortsuploader.shortscontent.domain;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class PropertyDetails {
    private String apartmentName;

    private String dongHo;

    private BigDecimal salePrice;

    private String propertyType;

    private String specialFeatures;
}
