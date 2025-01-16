package com.example.jpashop.repository;

import com.example.jpashop.domain.item.Item;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if(item.getId()==null){
            // 아이디가 없다 -> 새로운 객체 -> persist로 신규로 등록
            em.persist(item);
        }else{
            // 아이디가 있다 -> merge로 update를 한다라고 정도 이해하고 넘어가자.
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
