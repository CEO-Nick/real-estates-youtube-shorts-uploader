package com.youtube.shortsuploader.member.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class RealEstateInfo {
    private String companyName;
    private String phoneNumber;
    private String address;
}
