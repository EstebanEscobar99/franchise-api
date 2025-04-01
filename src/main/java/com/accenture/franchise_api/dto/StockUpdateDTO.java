package com.accenture.franchise_api.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockUpdateDTO {

    @Min(value = 0, message = "The stock cannot be negative")
    private Integer stock;

}
