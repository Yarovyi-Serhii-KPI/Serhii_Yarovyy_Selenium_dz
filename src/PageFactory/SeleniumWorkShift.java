package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class SeleniumWorkShift {
    WebDriver driver;

    @FindBy(id="btnAdd")
    WebElement addingButton;
    @FindBy(id="workShift_name")
    WebElement nameInput;
    @FindBy(id="workShift_workHours_from")
    WebElement shiftStartInput;
    @FindBy(id="workShift_workHours_to")
    WebElement shiftEndInput;
    @FindBy(id="workShift_availableEmp")
    WebElement addEmployeesForm;
    @FindBy(id="btnAssignEmployee")
    WebElement addEmployeesButton;
    @FindBy(id="btnSave")
    WebElement saveButton;





    public SeleniumWorkShift(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton(){
        addingButton.click();
    }

    public void setShiftName(String strShiftName){
        nameInput.sendKeys(strShiftName);
    }

    public void setShiftTime(String srtShiftStart, String srtShiftEnd){
        Select shiftStart = new Select(shiftStartInput);
        shiftStart.selectByVisibleText(srtShiftStart);
        Select shiftEnd = new Select(shiftEndInput);
        shiftEnd.selectByVisibleText(srtShiftEnd);
    }

    public void setEmployee(String strEmployeeName){
        Select employeeTable = new Select(addEmployeesForm);
        employeeTable.selectByVisibleText(strEmployeeName);
        addEmployeesButton.click();
    }

    public void clickSaveButton(){
        saveButton.click();
    }



    public void addWorkShift(String strShiftName, String srtShiftStart, String srtShiftEnd, String strEmployeeName) {
        this.clickAddButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        this.setShiftName(strShiftName);
        this.setShiftTime(srtShiftStart, srtShiftEnd);
        this.setEmployee(strEmployeeName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        this.clickSaveButton();

    }


}
