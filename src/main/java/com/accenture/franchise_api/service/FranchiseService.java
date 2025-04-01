package com.accenture.franchise_api.service;

import com.accenture.franchise_api.dto.FranchiseDTO;
import com.accenture.franchise_api.model.Franchise;
import com.accenture.franchise_api.repository.FranchiseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Transactional
    public FranchiseDTO createFranchise(FranchiseDTO franchiseDTO) {
        Franchise franchise = new Franchise();
        franchise.setName(franchiseDTO.getName());

        Franchise savedFranchise = franchiseRepository.save(franchise);

        FranchiseDTO response = new FranchiseDTO();
        response.setId(savedFranchise.getId());
        response.setName(savedFranchise.getName());

        return response;
    }

    @Transactional(readOnly = true)
    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Franchise getFranchiseById(Long id) throws Exception {
        return franchiseRepository.findById(id)
                .orElseThrow(() -> new Exception("Franchise not found with ID: " + id));
    }

    @Transactional
    public FranchiseDTO updateFranchiseName(Long id, FranchiseDTO franchiseDTO) throws Exception {
        Franchise franchise = getFranchiseById(id);

        franchise.setName(franchiseDTO.getName());
        Franchise savedFranchise = franchiseRepository.save(franchise);

        FranchiseDTO response = new FranchiseDTO();
        response.setId(savedFranchise.getId());
        response.setName(savedFranchise.getName());

        return response;
    }

}
