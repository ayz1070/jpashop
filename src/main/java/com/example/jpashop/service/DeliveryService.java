package com.example.jpashop.service;

import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.Order;
import com.example.jpashop.repository.DeliveryRepository;
import com.example.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 순수 JPA(엔티티 매니저) 기반의 DeliveryRepository/OrderRepository를 사용하는 Service
 */
@Service
@Transactional
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Long save(Delivery delivery) {
        deliveryRepository.save(delivery);
        return delivery.getId();
    }

    @Transactional
    public Delivery findById(Long id) {
        return deliveryRepository.findById(id);
    }

    @Transactional
    public Delivery findByOrderId(Long orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }


}