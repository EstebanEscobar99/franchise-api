package com.accenture.franchise_api.service;

import com.accenture.franchise_api.dto.ProductDTO;
import com.accenture.franchise_api.dto.StockUpdateDTO;
import com.accenture.franchise_api.model.Branch;
import com.accenture.franchise_api.model.Product;
import com.accenture.franchise_api.repository.BranchRepository;
import com.accenture.franchise_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final FranchiseService franchiseService;
    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;

    public ProductService(FranchiseService franchiseService, BranchRepository branchRepository, ProductRepository productRepository) {
        this.franchiseService = franchiseService;
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductDTO createProduct(Long franchiseId, Long branchId, ProductDTO productDTO) throws Exception {
        Branch branch = branchRepository.findByIdAndFranchiseId(branchId, franchiseId)
                .orElseThrow(() -> new Exception("Branch not found with ID: " + branchId));

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setStock(productDTO.getStock());
        product.setBranch(branch);

        Product savedProduct = productRepository.save(product);

        ProductDTO response = new ProductDTO();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setStock(savedProduct.getStock());
        response.setBranchId(branchId);

        return response;
    }

    @Transactional
    public void deleteProduct(Long branchId, Long productId) throws Exception {
        Product product = productRepository.findByIdAndBranchId(productId, branchId)
                .orElseThrow(() -> new Exception("Product not found with ID: " + productId));

        if (!product.getBranch().getId().equals(branchId)) {
            throw new Exception("Product not found in branch with ID: " + branchId);
        }

        productRepository.delete(product);

    }

    @Transactional
    public ProductDTO updateProductStock(Long branchId, Long productId, StockUpdateDTO stockUpdateDTO) throws Exception {
        Product product = productRepository.findByIdAndBranchId(productId, branchId)
                .orElseThrow(() -> new Exception("Product not found with ID: " + productId));

        product.setStock(stockUpdateDTO.getStock());
        Product savedProduct = productRepository.save(product);

        ProductDTO response = new ProductDTO();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setStock(savedProduct.getStock());
        response.setBranchId(savedProduct.getBranch().getId());

        return response;
    }

    @Transactional
    public ProductDTO updateProductName(Long branchId, Long productId, ProductDTO productDTO) throws Exception {
        Product product = productRepository.findByIdAndBranchId(productId, branchId)
                .orElseThrow(() -> new Exception("Product not found with ID: " + productId));

        product.setName(productDTO.getName());
        Product savedProduct = productRepository.save(product);

        ProductDTO response = new ProductDTO();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setStock(savedProduct.getStock());
        response.setBranchId(savedProduct.getBranch().getId());

        return response;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getMaxStockProductsByFranchise(Long franchiseId) {

        List<Product> products = productRepository.findMaxStockByFranchiseId(franchiseId);

        Map<Long, List<Product>> productsByBranch = products.stream()
                .collect(Collectors.groupingBy(p -> p.getBranch().getId()));

        List<ProductDTO> result = new ArrayList<>();

        for (Map.Entry<Long, List<Product>> entry : productsByBranch.entrySet()) {
            Product product = entry.getValue().stream()
                    .max((p1, p2) -> p1.getStock().compareTo(p2.getStock()))
                    .orElse(null);

            if (product != null) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setStock(product.getStock());
                productDTO.setBranchId(product.getBranch().getId());

                result.add(productDTO);
            }
        }

        return result;
    }

}
