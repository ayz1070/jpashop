package com.example.jpashop.api;

import com.example.jpashop.api.dto.CreateDeliveryRequest;
import com.example.jpashop.domain.Delivery;
import com.example.jpashop.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class DeliveryApiController {

    private final DeliveryService deliveryService;

    /**
     * 배송 생성 (POST) - /api/v1/deliveries
     */
    @PostMapping("/api/v1/deliveries")
    public CreateDeliveryResponse saveDeliveryV1(@RequestBody @Valid CreateDeliveryRequest request) {

        // 1) DTO -> 엔티티 변환
        Delivery delivery = new Delivery();
        delivery.setId(request.getId());  // 신규 생성 시 null로 들어올 가능성이 큼
        delivery.setOrderId(request.getOrderId());
        delivery.setTrackingNumber(request.getTrackingNumber());
        delivery.setCarrierId(request.getCarrierId());
        delivery.setManName(request.getManName());
        delivery.setShippedDate(request.getShippedDate());
        delivery.setDeliveredDate(request.getDeliveredDate());
        delivery.setUpdatedAt(request.getUpdatedAt());
        delivery.setStatus(request.getStatus());

        // 2) 기본값 설정 (status=0이면 1로)
        if (delivery.getStatus() == 0) {
            delivery.setStatus(1);
        }
        // deliveredDate, updatedAt이 null이면 현재 시각으로
        if (delivery.getDeliveredDate() == null) {
            delivery.setDeliveredDate(LocalDateTime.now());
        }
        if (delivery.getUpdatedAt() == null) {
            delivery.setUpdatedAt(LocalDateTime.now());
        }

        // 3) 저장 후 PK 반환
        Long id = deliveryService.save(delivery);

        // 4) 응답 DTO 생성
        return new CreateDeliveryResponse(id);
    }

    /**
     * 배송 단일 조회 (GET) - ID로 조회: /api/v1/deliveries/{id}
     */
    @GetMapping("/api/v1/deliveries/{id}")
    public GetDeliveryResponse getDeliveryById(@PathVariable("id") Long id) {
        // 1) Service 통해 Delivery 엔티티 조회
        Delivery findDelivery = deliveryService.findById(id);
        if (findDelivery == null) {
            throw new IllegalArgumentException("Delivery not found. ID=" + id);
        }

        // 2) 엔티티 -> 응답 DTO
        return new GetDeliveryResponse(findDelivery);
    }

    // POST 응답용 DTO
    @Data
    static class CreateDeliveryResponse {
        private Long id;
        public CreateDeliveryResponse(Long id) {
            this.id = id;
        }
    }

    // GET 응답용 DTO
    @Data
    static class GetDeliveryResponse {
        private Long id;
        private Integer orderId;
        private String trackingNumber;
        private Integer carrierId;
        private String manName;
        private LocalDateTime shippedDate;
        private LocalDateTime deliveredDate;
        private LocalDateTime updatedAt;
        private int status;

        // 엔티티를 받아 필드 매핑
        public GetDeliveryResponse(Delivery delivery) {
            this.id = delivery.getId();
            this.orderId = delivery.getOrderId();
            this.trackingNumber = delivery.getTrackingNumber();
            this.carrierId = delivery.getCarrierId();
            this.manName = delivery.getManName();
            this.shippedDate = delivery.getShippedDate();
            this.deliveredDate = delivery.getDeliveredDate();
            this.updatedAt = delivery.getUpdatedAt();
            this.status = delivery.getStatus();
        }
    }
}