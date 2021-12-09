package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeleniumMainPage {
    WebDriver driver;

    @FindBy(id="menu_admin_viewAdminModule")
    WebElement topLevel;
    @FindBy(id="menu_admin_UserManagement")
    WebElement secondLevel_a;
    @FindBy(id="menu_admin_Job")
    WebElement secondLevel_b;
    @FindBy(id="menu_admin_workShift")
    WebElement thirdLevel;

    public SeleniumMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void mouseToWorkShifts(){
        Actions builder = new Actions(driver);
        Action mouseOverWS = builder
                .moveToElement(topLevel)
                .pause(1000)
                .moveToElement(secondLevel_a)
                .pause(1000)
                .moveToElement(secondLevel_b)
                .pause(1000)
                .moveToElement(thirdLevel)
                .pause(1000)
                .click()
                .pause(2000)
                .build();
        mouseOverWS.perform();
    }



    public void moveToWorkShifts(){
        this.mouseToWorkShifts();
    }


}
