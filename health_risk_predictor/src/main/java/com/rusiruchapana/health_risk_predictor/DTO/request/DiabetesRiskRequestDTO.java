package com.rusiruchapana.health_risk_predictor.DTO.request;

import lombok.Data;

@Data
public class DiabetesRiskRequestDTO {

    private Integer pregnancies;
    private Integer glucose;
    private Integer bloodPressure;
    private Integer skinThickness;
    private Integer insulin;
    private Float bmi;
    private Float diabetesPedigreeFunction;
    private Integer age;
}
