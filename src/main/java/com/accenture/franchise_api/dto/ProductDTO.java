package com.accenture.franchise_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "The name of the product is mandatory")
    private String name;

    @Min(value = 0, message = "The stock cannot be negative")
    private Integer stock;

}
