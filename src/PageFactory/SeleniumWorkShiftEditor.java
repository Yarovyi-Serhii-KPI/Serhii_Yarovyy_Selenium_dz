package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumWorkShiftEditor {
    WebDriver driver;

    @FindBy(xpath="//form/div[4]/table/tbody/tr[2]/td[1]/input")
    WebElement newShiftCheckBox;
    @FindBy(id="btnDelete")
    WebElement deleteShiftButton;
    @FindBy(id="dialogDeleteBtn")
    WebElement deleteConfirmButton;

    @FindBy(xpath ="/html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[4]/table/tbody//child::tr")
    List<WebElement> allShiftsInfo;

    @FindBy(xpath = "//form/div[4]/table/tbody/tr[2]/td[2]/a")
    WebElement shiftName;
    @FindBy(xpath = "//form/div[4]/table/tbody/tr[2]/td[3]")
    WebElement shiftStart;
    @FindBy(xpath = "//tbody/tr[2]/td[4]")
    WebElement shiftEnd;
    @FindBy(xpath = "//tbody/tr[2]/td[5]")
    WebElement shiftLen;

    public SeleniumWorkShiftEditor(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public int getAmountOfShifts(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[4]/table/tbody//child::tr")));
        return allShiftsInfo.size();
    }

    public String getWorkShiftInfoString(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[4]/table/tbody/tr[2]/td[2]/a")));
        String infoString = "Shift Name ".concat(shiftName.getText());
        infoString = infoString.concat(" From ").concat(shiftStart.getText());
        infoString = infoString.concat(" To ").concat(shiftEnd.getText()).concat(" ");
        infoString = infoString.concat(shiftLen.getText()).concat(" Hours Per Day").replace("\n","").replace("\r","");
        return infoString;
    }

    public void clickNewShiftCheckBox(){
        newShiftCheckBox.click();
    }
    public void clickDeleteShiftButton(){
        deleteShiftButton.click();
    }
    public void clickDeleteConfirmButton(){deleteConfirmButton.click();}

    public void deleteWorkShift(){
        this.clickNewShiftCheckBox();
        this.clickDeleteShiftButton();
        this.clickDeleteConfirmButton();
    }
}
