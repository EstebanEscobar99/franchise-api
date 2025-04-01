package com.accenture.franchise_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaxStockProductDTO {

    private String productId;
    private String productName;
    private Integer stock;
    private String branchId;
    private String branchName;

}
