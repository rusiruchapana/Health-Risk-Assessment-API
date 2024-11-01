package com.rusiruchapana.health_risk_predictor.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiabetesRiskResponseDTO {

    private int outCome;
    private String riskMessage;
}
