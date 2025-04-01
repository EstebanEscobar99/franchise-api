package com.accenture.franchise_api.controller;

import com.accenture.franchise_api.dto.ProductDTO;
import com.accenture.franchise_api.dto.StockUpdateDTO;
import com.accenture.franchise_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/franchises/{franchiseId}/branches/{branchId}/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(
            @PathVariable Long franchiseId,
            @PathVariable Long branchId,
            @Valid @RequestBody ProductDTO productDTO) throws Exception {
        return new ResponseEntity<>(
                productService.createProduct(franchiseId, branchId, productDTO),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long branchId,
            @PathVariable Long productId) throws Exception {
        productService.deleteProduct(branchId, productId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{productId}/stock")
    public ResponseEntity<ProductDTO> updateProductStock(
            @PathVariable Long branchId,
            @PathVariable Long productId,
            @Valid @RequestBody StockUpdateDTO stockUpdateDTO) throws Exception {
        return ResponseEntity.ok(
                productService.updateProductStock(branchId, productId, stockUpdateDTO));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProductName(
            @PathVariable Long branchId,
            @PathVariable Long productId,
            @Valid @RequestBody ProductDTO productDTO) throws Exception {
        return ResponseEntity.ok(
                productService.updateProductName(branchId, productId, productDTO));
    }
}
