using Backend_risk_prediction.Models;
using Microsoft.AspNetCore.Mvc;

namespace Backend_risk_prediction.Controllers;

[Route("api/[controller]")]
[ApiController]
public class DiabetesRiskController: ControllerBase
{
    [HttpPost("predict")]
    public ActionResult<DiabetesRiskRequest> PredictRisk([FromBody] DiabetesRiskRequest request)
    {
        // Specify the path to your model file (e.g., a .pkl file)
        var modelPath = Path.Combine(AppContext.BaseDirectory, "Models", "diabetes_model.pkl");
        // Update with actual file path
        var prediction = PredictDiabetesRisk(modelPath, request);

        // Set the prediction result in the request object
        request.Outcome = prediction;

        // Return the modified request object, including the prediction
        return Ok(request);
    }

    private int PredictDiabetesRisk(string modelPath, DiabetesRiskRequest request)
    {
        // Placeholder logic for prediction; replace this with model loading and prediction
        Random random = new Random();
        return random.Next(0, 2); // Generates a simulated prediction (0 or 1)
    }
}