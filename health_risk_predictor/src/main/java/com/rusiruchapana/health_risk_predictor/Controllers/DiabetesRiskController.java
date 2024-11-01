package com.rusiruchapana.health_risk_predictor.Controllers;

import com.rusiruchapana.health_risk_predictor.DTO.request.DiabetesRiskRequestDTO;
import com.rusiruchapana.health_risk_predictor.DTO.response.DiabetesRiskResponseDTO;
import com.rusiruchapana.health_risk_predictor.Services.DiabetesRiskPredictorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diabetes")
public class DiabetesRiskController {

    private DiabetesRiskPredictorService diabetesRiskPredictorService;

    public DiabetesRiskController(DiabetesRiskPredictorService diabetesRiskPredictorService) {
        this.diabetesRiskPredictorService = diabetesRiskPredictorService;
    }

    @PostMapping("/predict")
    public DiabetesRiskResponseDTO predictRisk(@RequestBody DiabetesRiskRequestDTO diabetesRiskRequestDTO){
        return diabetesRiskPredictorService.predictRisk(diabetesRiskRequestDTO);
    }

}
