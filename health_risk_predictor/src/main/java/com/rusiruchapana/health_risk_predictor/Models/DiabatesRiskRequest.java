package com.rusiruchapana.health_risk_predictor.Models;

import lombok.Data;

@Data
public class DiabatesRiskRequest {

    private Integer pregnancies;
    private Integer glucose;
    private Integer bloodPressure;
    private Integer skinThickness;
    private Integer insulin;
    private Float bmi;
    private Float diabatesPedigreeFunction;
    private Integer age;
}
