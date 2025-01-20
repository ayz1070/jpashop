package com.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // 테이블 설계에 맞게 PK 컬럼명을 id 로 변경
    private Long id;

    /**
     * order_id 컬럼 (정수 형태로 직접 보관)
     * 기존 @OneToOne Order 매핑, address 임베디드 제거
     */
    @Column(name = "order_id")
    private Integer orderId;

    // 운송장 번호
    @Column(name = "tracking_number")
    private String trackingNumber;

    // 배송 상태 (int)
    @Column(name = "status")
    private int status;

    // 배송사 ID
    @Column(name = "carrier_id")
    private Integer carrierId;

    // 배송기사 이름
    @Column(name = "man_name")
    private String manName;

    // 배송 시작 날짜
    @Column(name = "shipped_date")
    private LocalDateTime shippedDate;

    // 배송 완료 날짜
    @Column(name = "delivered_date")
    private LocalDateTime deliveredDate;

    // 상태 마지막 변경 날짜
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}