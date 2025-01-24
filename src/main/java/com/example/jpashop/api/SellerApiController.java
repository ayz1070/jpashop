package com.example.jpashop.api;

import com.example.jpashop.domain.Seller;
import com.example.jpashop.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class SellerApiController {

    private final SellerService sellerService;

    // 판매자 등록
    @PostMapping
    public ResponseEntity<Long> registerSeller(@RequestBody Seller seller) {
        try {
            sellerService.join(seller);
            return ResponseEntity.ok(seller.getId());
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // 모든 판매자 조회
    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.findSellers();
        return ResponseEntity.ok(sellers);
    }

    // ID로 판매자 조회
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerService.findSellerById(id);
        if (seller != null) {
            return ResponseEntity.ok(seller);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}