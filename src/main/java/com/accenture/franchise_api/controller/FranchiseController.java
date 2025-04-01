package com.accenture.franchise_api.controller;

import com.accenture.franchise_api.dto.FranchiseDTO;
import com.accenture.franchise_api.dto.ProductDTO;
import com.accenture.franchise_api.model.Franchise;
import com.accenture.franchise_api.service.FranchiseService;
import com.accenture.franchise_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

    private final ProductService productService;
    private final FranchiseService franchiseService;

    public FranchiseController(ProductService productService, FranchiseService franchiseService) {
        this.productService = productService;
        this.franchiseService = franchiseService;
    }

    @PostMapping
    public ResponseEntity<FranchiseDTO> createFranchise(@Valid @RequestBody FranchiseDTO franchiseDTO) {
        return new ResponseEntity<>(franchiseService.createFranchise(franchiseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Franchise>> getAllFranchises() {
        return ResponseEntity.ok(franchiseService.getAllFranchises());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchiseById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(franchiseService.getFranchiseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FranchiseDTO> updateFranchiseName(
            @PathVariable Long id,
            @Valid @RequestBody FranchiseDTO franchiseDTO) throws Exception {
        return ResponseEntity.ok(franchiseService.updateFranchiseName(id, franchiseDTO));
    }

    @GetMapping("/{id}/max-stock-products")
    public ResponseEntity<List<ProductDTO>> getMaxStockProductsByFranchise(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getMaxStockProductsByFranchise(id));
    }
}
