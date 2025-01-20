package com.example.jpashop.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateDeliveryRequest {
    private Long id;          // DB 생성 시 자동 증가 (POST 시 보통 null)
    private Integer orderId;  // order_id (정수)
    private String trackingNumber;
    private Integer carrierId;
    private String manName;
    private LocalDateTime shippedDate;
    private LocalDateTime deliveredDate;
    private LocalDateTime updatedAt;
    private int status;

    public CreateDeliveryRequest() {
    }

    public CreateDeliveryRequest(
            Long id,
            Integer orderId,
            String trackingNumber,
            Integer carrierId,
            String manName,
            LocalDateTime shippedDate,
            LocalDateTime deliveredDate,
            LocalDateTime updatedAt,
            int status
    ) {
        this.id = id;
        this.orderId = orderId;
        this.trackingNumber = trackingNumber;
        this.carrierId = carrierId;
        this.manName = manName;
        this.shippedDate = shippedDate;
        this.deliveredDate = deliveredDate;
        this.updatedAt = updatedAt;
        this.status = status;
    }
}