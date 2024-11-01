package com.rusiruchapana.health_risk_predictor.Services;

import com.rusiruchapana.health_risk_predictor.DTO.request.DiabetesRiskRequestDTO;
import com.rusiruchapana.health_risk_predictor.DTO.response.DiabetesRiskResponseDTO;
import jakarta.annotation.PostConstruct;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.Model;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.InputField;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.model.PMMLUtil;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jakarta.xml.bind.JAXBException;


@Service
public class DiabetesRiskPredictorService {

    private Evaluator modelEvaluator;

    @PostConstruct
    public void init() throws IOException, SAXException {
        String modelPath = "path/to/your/diabetes_model.pmml";
        PMML pmml;
        try (FileInputStream fis = new FileInputStream(modelPath)) {
            pmml = PMMLUtil.unmarshal(fis);
        }

        // Get the first model from the PMML
        Model model = pmml.getModels().get(0);

        // Create an evaluator for the model, passing the PMML and model, and an empty Set<ResultFeature>
        this.modelEvaluator = ModelEvaluatorFactory.newInstance().newModelEvaluator(pmml, model, Collections.emptySet());
        this.modelEvaluator.verify();
    }

    public DiabetesRiskResponseDTO predictRisk(DiabetesRiskRequestDTO request) {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("Pregnancies", request.getPregnancies());
        inputMap.put("Glucose", request.getGlucose());
        inputMap.put("BloodPressure", request.getBloodPressure());
        inputMap.put("SkinThickness", request.getSkinThickness());
        inputMap.put("Insulin", request.getInsulin());
        inputMap.put("BMI", request.getBmi());
        inputMap.put("DiabetesPedigreeFunction", request.getDiabetesPedigreeFunction());
        inputMap.put("Age", request.getAge());

        // Map inputs to PMML input fields with FieldName as the key type
        Map<FieldName, Object> pmmlInputs = new HashMap<>();
        for (InputField inputField : modelEvaluator.getInputFields()) {
            FieldName fieldName = inputField.getName(); // Convert InputField to FieldName
            pmmlInputs.put(fieldName, inputMap.get(fieldName.getValue())); // Use FieldName as key
        }

        // Evaluate the model
        Map<FieldName, ?> result = modelEvaluator.evaluate(pmmlInputs); // This line should now work
        int outcome = (int) result.get(FieldName.create("Outcome")); // Adjust the output key as needed

        String riskMessage = (outcome == 1) ? "High risk of diabetes" : "Low risk of diabetes";
        return new DiabetesRiskResponseDTO(outcome, riskMessage);
    }
}
