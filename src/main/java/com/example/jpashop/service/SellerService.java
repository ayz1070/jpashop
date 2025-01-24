package com.example.jpashop.service;


import com.example.jpashop.domain.Seller;
import com.example.jpashop.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerService {
    @Autowired
    private final SellerRepository sellerRepository;

    public Long join(Seller seller){
        sellerRepository.save(seller);
        return seller.getId();
    }

    private void validateDuplicatedSeller(Seller seller){
        List<Seller> findSeller = sellerRepository.findByName(seller.getName());
        if(!findSeller.isEmpty()){
            throw new IllegalStateException("이미 존재하는 판매자입니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<Seller> findSellers(){
        return sellerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Seller findSellerById(Long id){
        return sellerRepository.findById(id).orElse(null);
    }

}
