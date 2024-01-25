package com.example.project.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Subscription {
    private Long id;
    private Integer users;
    private String serviceType; // "Basic", "Standard", "Premium"
    private Double storage; // TB 단위
    private Integer duration; // 개월 단위

    // 부가정보: 회사명, 전화번호, 이메일, 주소 등
    private String companyName;
    private String phoneNumber;
    private String email;
    private String address;

    public Subscription(Long id, Integer users, String serviceType, Double storage, Integer duration, String companyName, String phoneNumber, String email, String address) {
        this.id = id;
        this.users = users;
        this.serviceType = serviceType;
        this.storage = storage;
        this.duration = duration;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Subscription updateWith(Subscription data) {
        return new Subscription(
                this.id, // 기존 ID 유지
                data.getUsers(),
                data.getServiceType(),
                data.getStorage(),
                data.getDuration(),
                data.getCompanyName(),
                data.getPhoneNumber(),
                data.getEmail(),
                data.getAddress()
        );
    }
}