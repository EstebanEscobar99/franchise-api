package com.accenture.franchise_api.repository;

import com.accenture.franchise_api.model.Branch;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository {

 List<Branch> findByFranchiseId(Long franchiseId);

 Optional<Branch> findByIdAndFranchiseId(Long id, Long franchiseId);

}
