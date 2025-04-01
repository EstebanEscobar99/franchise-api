package com.accenture.franchise_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class BranchDTO {

    private Long id;

    @NotBlank(message = "The name of the branch is mandatory")
    private String name;

    private Long franchiseId;

    private List<ProductDTO> products;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }

}
