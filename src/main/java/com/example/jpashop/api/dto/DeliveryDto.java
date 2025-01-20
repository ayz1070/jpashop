package com.example.jpashop.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeliveryDto {
    private Long id;             // PK
    private Integer orderId;     // 정수형 orderId
    private String trackingNumber;
    private Integer carrierId;
    private String manName;
    private LocalDateTime shippedDate;
    private LocalDateTime deliveredDate;
    private LocalDateTime updatedAt;
    private Integer status;
}