package com.accenture.franchise_api.repository;

import com.accenture.franchise_api.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

 List<Branch> findByFranchiseId(Long franchiseId);

 Optional<Branch> findByIdAndFranchiseId(Long id, Long franchiseId);

}
