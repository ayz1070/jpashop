package com.example.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Seller {
    @Id
    @GeneratedValue
    @Column(name = "seller_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SellerType sellerType;
    private String bankName;
    private String accountNumber;
    private String accountHolderName;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;
}
