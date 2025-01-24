package com.example.jpashop.controller;

import com.example.jpashop.domain.Seller;
import com.example.jpashop.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("/sellers/new")
    public String createForm(Model model) {
        model.addAttribute("sellerForm", new SellerForm());
        return "sellers/createSellerForm";
    }


}
