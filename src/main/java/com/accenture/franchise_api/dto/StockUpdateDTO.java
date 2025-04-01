package com.accenture.franchise_api.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class StockUpdateDTO {

    @Min(value = 0, message = "The stock cannot be negative")
    private Integer stock;

    public Integer getStock() {
        return stock;
    }

}
