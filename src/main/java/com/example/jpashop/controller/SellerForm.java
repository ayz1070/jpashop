package com.example.jpashop.controller;

import com.example.jpashop.domain.SellerType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SellerForm {

    @NotEmpty
    private String name;
    private SellerType sellerType;
    private String bankName;
    private String accountNumber;
    private String accountHolderName;
    private String email;
    private String phoneNumber;

}
