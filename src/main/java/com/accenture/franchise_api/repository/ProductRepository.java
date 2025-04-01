package com.accenture.franchise_api.repository;

import com.accenture.franchise_api.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {

    List<Product> findByBranchId(Long branchId);

    Optional<Product> findByIdAndBranchId(Long id, Long branchId);

    @Query("SELECT p FROM Product p WHERE p.branch.id = :branchId AND p.stock = (SELECT MAX(p2.stock) FROM Product p2 WHERE p2.branch.id = :branchId)")
    List<Product> findMaxStockByBranchId(Long branchId);

}
