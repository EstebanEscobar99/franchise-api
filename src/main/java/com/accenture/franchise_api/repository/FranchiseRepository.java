package com.accenture.franchise_api.repository;

import com.accenture.franchise_api.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {

    Optional<Franchise> findByName(String name);

}
