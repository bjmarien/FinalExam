package pkgCore;
import java.text.DecimalFormat;


import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement
{
	
	private int YearsToWork;
	private double AnnualReturnWorking;
	private int YearsRetired;
	private double AnnualReturnRetired;
	private double RequiredIncome;
	private double MonthlySoc;
	
	public Retirement(int YearsToWork, double AnnualReturnWorking, int YearsRetired, double AnnualReturnRetired, double RequiredIncome, double MonthlySoc) 
	{
		this.setYearsToWork(YearsToWork);
		this.setAnnualReturnRetired(AnnualReturnRetired);
		this.setYearsRetired(YearsRetired);
		this.setAnnualReturnWorking(AnnualReturnWorking);
		this.setRequiredIncome(RequiredIncome);
		this.setMonthlySoc(MonthlySoc);
	}

	public int getYearsToWork()
	{
		return YearsToWork;
	}

	public void setYearsToWork(int YearsToWork)
	{
		this.YearsToWork = YearsToWork;
	}

	public double getAnnualReturnWorking() 
	{
		return AnnualReturnWorking;
	}
	
	public void setAnnualReturnWorking(double AnnualReturnWorking) 
	{
		this.AnnualReturnWorking = AnnualReturnWorking;
	}

	public int getYearsRetired() 
	{
		return YearsRetired;
	}

	public void setYearsRetired(int YearsRetired) 
	{
		this.YearsRetired = YearsRetired;
	}

	public double getAnnualReturnRetired() 
	{
		return AnnualReturnRetired;
	}

	public void setAnnualReturnRetired(double AnnualReturnRetired) 
	{
		this.AnnualReturnRetired = AnnualReturnRetired;
	}

	public double getRequiredIncome() 
	{
		return RequiredIncome;
	}

	public void setRequiredIncome(double RequiredIncome) 
	{
		this.RequiredIncome = RequiredIncome;
	}

	public double getMonthlySoc() 
	{
		return MonthlySoc;
	}

	public void setMonthlySoc(double MonthlySoc) 
	{
		this.MonthlySoc = MonthlySoc;
	}

	
	public double AmountToSave()
	{
		DecimalFormat Format1 = new DecimalFormat("0.0");
		return (-1)*Double.parseDouble(Format1.format(FinanceLib.pmt((AnnualReturnWorking)/(12),
				(YearsToWork)*(12), 0, this.TotalAmountSaved(), false)));
	}
	
	public double TotalAmountSaved()
	{
		DecimalFormat Format2 = new DecimalFormat("0.0");
		return (-1)*Double.parseDouble(Format2.format(FinanceLib.pv((AnnualReturnRetired)/(12),
				(YearsRetired)*(12), (RequiredIncome - MonthlySoc), 0.0, false)));
	}
}
