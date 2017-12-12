package pkgApp.controller;

import java.net.URL;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable 
{

	@FXML	
	private RetirementApp mainApp = null;
	@FXML
	private TextField txtfldYearsToWork;
	@FXML 
	private TextField txtfldAnnualReturnWorking;
	@FXML
	private TextField txtfldYearsRetired;
	@FXML
	private TextField txtfldAnnualReturnRetired;
	@FXML
	private TextField txtfldRequiredIncome;
	@FXML
	private TextField txtfldMonthlySoc;
	@FXML
	private TextField txtfldTotalAmountSaved;
	@FXML
	private TextField txtfldAmountToSave;
	@FXML
	private Button Clear;
	@FXML
	private Button Calc;
	
	@FXML
	public RetirementApp getMainApp() 
	{
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp)
	{
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{		
	}
	
	@FXML
	public void btnClear(ActionEvent event)
	{
		System.out.println("Clear All");
		txtfldYearsToWork.clear();
		txtfldAnnualReturnWorking.clear();
		txtfldYearsRetired.clear();
		txtfldAnnualReturnRetired.clear();
		txtfldRequiredIncome.clear();
		txtfldMonthlySoc.clear();
		txtfldTotalAmountSaved.clear();
		txtfldAmountToSave.clear();	
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) 
	{
		if(isInputValid())
		{
			Retirement R = new Retirement((int) Integer.valueOf(txtfldYearsToWork.getText()),
				(double) Double.valueOf(txtfldAnnualReturnWorking.getText()),
				(int) Integer.valueOf(txtfldYearsRetired.getText()),
				(double) Double.valueOf(txtfldAnnualReturnRetired.getText()),
				(double) Double.valueOf(txtfldRequiredIncome.getText()), 
				(double) Double.valueOf(txtfldMonthlySoc.getText()));

		txtfldTotalAmountSaved.setText(Double.toString(R.TotalAmountSaved()));

		txtfldAmountToSave.setText(Double.toString(R.AmountToSave()));
		}	
	}
	
	private boolean isInputValid() 
	{
        String ErrorMessage = "";
        
        try 
        {
            Integer.parseInt(txtfldYearsToWork.getText());
        } 
        catch (NumberFormatException e) 
        {
            ErrorMessage += "Years to work must be a valid integer"; 
        }
        
        try 
        {
            Integer.parseInt(txtfldYearsRetired.getText());
        } 
        catch (NumberFormatException e) 
        {
            ErrorMessage += "Years retired must be a valid integer"; 
        }
        
        try 
        {
            if(Double.parseDouble(txtfldAnnualReturnWorking.getText())< 0.0 || Double.parseDouble(txtfldAnnualReturnWorking.getText())>.2) 
            {
            	ErrorMessage += "Annual return working must be between 0.0 and 0.20";
            } 
        } 
        catch (NumberFormatException e)
        {
            ErrorMessage += "Annual return rorking must be a number"; 
        }
        
        try 
        {
        	if(Double.parseDouble(txtfldAnnualReturnRetired.getText())< 0.0 || Double.parseDouble(txtfldAnnualReturnRetired.getText())>.03) 
        	{
            	ErrorMessage += "Annual return working must be between 0 and 0.03";
            }
        } 
        catch (NumberFormatException e) 
        {
            ErrorMessage += "Annual return retired must be a number"; 
        }
        
        try 
        {
            Double.parseDouble(txtfldRequiredIncome.getText());
        } 
        catch (NumberFormatException e) 
        {
            ErrorMessage += "Required income must be a number"; 
        }

        try 
        {
            Double.parseDouble(txtfldMonthlySoc.getText());
        } 
        catch (NumberFormatException e) 
        {
            ErrorMessage += "Monthly Social Security must be a number"; 
        }
        
        if (ErrorMessage.length() == 0) 
        {
            return true;
        } 
        else 
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid fields");
            alert.setHeaderText("Please correct all of the invalid fields");
            alert.setContentText(ErrorMessage);
            alert.showAndWait();
            return false;
        }
        
    }
        	
}
