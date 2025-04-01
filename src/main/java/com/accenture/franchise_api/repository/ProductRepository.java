package com.accenture.franchise_api.repository;

import com.accenture.franchise_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBranchId(Long branchId);

    Optional<Product> findByIdAndBranchId(Long id, Long branchId);

    @Query("SELECT p FROM Product p WHERE p.branch.id = :branchId ORDER BY p.stock DESC LIMIT 1")
    List<Product> findMaxStockByBranchId(@Param("branchId") Long branchId);

    @Query("SELECT p FROM Product p WHERE p.branch.franchise.id = :franchiseId ORDER BY p.branch.id, p.stock DESC")
    List<Product> findMaxStockByFranchiseId(@Param("franchiseId") Long franchiseId);

}
