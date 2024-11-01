using System.ComponentModel.DataAnnotations;

namespace Backend_risk_prediction.Models;

public class DiabetesRiskRequest
{
    [Required]
    public int Pregnancies { get; set; }
    [Required]
    public int Glucose { get; set; }
    [Required]
    public int BloodPressure { get; set; }
    [Required]
    public int SkinThickness { get; set; }
    [Required]
    public int Insulin { get; set; }
    [Required]
    public float BMI { get; set; }
    [Required]
    public float DiabetesPedigreeFunction { get; set; }
    [Required]
    public int Age { get; set; }
    public int Outcome { get; set; } // To store the prediction result
}