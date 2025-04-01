package com.accenture.franchise_api.controller;

import com.accenture.franchise_api.dto.BranchDTO;
import com.accenture.franchise_api.dto.FranchiseDTO;
import com.accenture.franchise_api.dto.ProductDTO;
import com.accenture.franchise_api.model.Franchise;
import com.accenture.franchise_api.service.BranchService;
import com.accenture.franchise_api.service.FranchiseService;
import com.accenture.franchise_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises/{franchiseId}/branches")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(
            @PathVariable Long franchiseDTO,
            @Valid @RequestBody BranchDTO branchDTO) throws Exception {
        return new ResponseEntity<>(branchService.createBranch(franchiseDTO, branchDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{branchId}")
    public ResponseEntity<BranchDTO> updateBranchName(
            @PathVariable Long franchiseId,
            @PathVariable Long branchId,
            @Valid @RequestBody BranchDTO branchDTO) throws Exception {
        return ResponseEntity.ok(branchService.updateBranchName(franchiseId, branchId, branchDTO));
    }
}
