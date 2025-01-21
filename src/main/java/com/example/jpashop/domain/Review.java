package com.example.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;


}
