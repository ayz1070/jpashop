package com.example.jpashop.service;


import com.example.jpashop.domain.item.Book;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class ItemUpdateTest {

    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        // TX
        book.setName("asdasdb");
    }
}
