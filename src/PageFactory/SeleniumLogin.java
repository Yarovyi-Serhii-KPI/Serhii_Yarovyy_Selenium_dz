package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumLogin {

    WebDriver driver;

    @FindBy(id="txtUsername")
    WebElement userName;
    @FindBy(id="txtPassword")
    WebElement userPassword;
    @FindBy(id="btnLogin")
    WebElement login;

    public SeleniumLogin(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void setUserName(String strUserName){ userName.sendKeys(strUserName); }

    public void setPassword(String strPassword){
        userPassword.sendKeys(strPassword);
    }


    public void clickLogin(){
        login.click();
    }


    public void log_In(String strUserName_,String strPassword_){
        this.setUserName(strUserName_);
        this.setPassword(strPassword_);
        this.clickLogin();

    }

}