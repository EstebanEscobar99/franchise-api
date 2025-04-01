package com.accenture.franchise_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "The name of the product is mandatory")
    private String name;

    @Min(value = 0, message = "The stock cannot be negative")
    private Integer stock;

    private Long branchId;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

}
