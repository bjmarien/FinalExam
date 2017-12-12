package pkgEmpty;

import static org.junit.Assert.*;


import org.junit.Test;
import org.apache.poi.ss.formula.functions.*;
import pkgCore.Retirement;
public class TestFinance {
	
	@Test 
	public void TestAmounts()
	{
		double MonthsToWork = 40 * 12;
		double AnnualReturnWorking = 0.07 / 12;
		double MonthsRetired = 20 * 12;
		double AnnaulReturnRetired = 0.02 / 12;
		double RequiredIncome = 10000;
		double MonthlySoc = 2642;
		//double PV = FinanceLib.pv(AnnaulReturnRetired, MonthsRetired, RequiredIncome - MonthlySoc, 0, false);
		//double PMT = FinanceLib.pmt(AnnualReturnWorking, MonthsToWork, 0, PV, false);
		Retirement R = new Retirement(40, .07, 20, .02, 10000, 2642);
		double PV = R.AmountToSave();
		double PMT = R.TotalAmountSaved();
		System.out.println(PV);
		System.out.println(PMT);
		assertEquals(PV, 554.13, .1);
		assertEquals(PMT, 1454485.55, .1);
	}
	
	
	@Test
	public void TestPV()
	{
		double r = 0.025 / 12;
		double n = 20 * 12;
		double y = 10000-2642;
		double f = 0;
		boolean t = false;
		double PV1 = FinanceLib.pv(r, n, y, f, t);
		
		//System.out.println(PV1);
		
	}
	
	
	@Test
	public void TestPMT() {
		double r = 0.042 / 12;
		double n = 60;
		double p = 30000;
		double f = 0;
		boolean t = false;
		
		double PMT1 = FinanceLib.pmt(r, n, p, f, t);
		
		//System.out.println(PMT1);
			
	}

}
