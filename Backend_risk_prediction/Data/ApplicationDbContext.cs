using Backend_risk_prediction.Models;
using Microsoft.EntityFrameworkCore;

namespace Backend_risk_prediction.Data;

public class ApplicationDbContext: DbContext
{
    public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options): base(options)
    {
    }
    
    public DbSet<DiabetesRiskRequest> DiabetesRiskRequests { get; set; }
}