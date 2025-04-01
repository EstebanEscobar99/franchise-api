package com.accenture.franchise_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class FranchiseDTO {

    private Long id;

    @NotBlank(message = "The name of the franchise is mandatory")
    private String name;

    private List<BranchDTO> branches;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
