package com.accenture.franchise_api.service;

import com.accenture.franchise_api.dto.BranchDTO;
import com.accenture.franchise_api.model.Branch;
import com.accenture.franchise_api.model.Franchise;
import com.accenture.franchise_api.repository.BranchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchService {

    private final FranchiseService franchiseService;
    private final BranchRepository branchRepository;

    public BranchService(FranchiseService franchiseService, BranchRepository branchRepository) {
        this.franchiseService = franchiseService;
        this.branchRepository = branchRepository;
    }

    @Transactional
    public BranchDTO createBranch(Long franchiseId, BranchDTO branchDTO) throws Exception {
        Franchise franchise = franchiseService.getFranchiseById(franchiseId);

        Branch branch = new Branch();
        branch.setName(branchDTO.getName());
        branch.setFranchise(franchise);

        Branch savedBranch = branchRepository.save(branch);

        BranchDTO response = new BranchDTO();
        response.setId(savedBranch.getId());
        response.setName(savedBranch.getName());
        response.setFranchiseId(franchiseId);

        return response;
    }

    @Transactional
    public BranchDTO updateBranchName(Long franchiseId, Long branchId, BranchDTO branchDTO) throws Exception {
        Branch branch = branchRepository.findByIdAndFranchiseId(branchId, franchiseId)
                .orElseThrow(() -> new Exception("Branch not found with ID: " + branchId));

        branch.setName(branchDTO.getName());
        Branch savedBranch = branchRepository.save(branch);

        BranchDTO response = new BranchDTO();
        response.setId(savedBranch.getId());
        response.setName(savedBranch.getName());
        response.setFranchiseId(savedBranch.getFranchise().getId());

        return response;
    }

}
