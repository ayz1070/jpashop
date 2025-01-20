package com.example.jpashop.repository;

import com.example.jpashop.domain.Delivery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DeliveryRepository {
    private final EntityManager em;

    public Long save(Delivery delivery){
        if(delivery.getId() == null){
            em.persist(delivery);
        }else{
            em.merge(delivery);
        }
        return delivery.getId();
    }

    public Delivery findById(Long id){
        return em.find(Delivery.class, id);
    }

    public Delivery findByOrderId(Long orderId){
        return em.find(Delivery.class, orderId);
    }

}