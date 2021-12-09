package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import PageFactory.SeleniumLogin;
import PageFactory.SeleniumMainPage;
import PageFactory.SeleniumWorkShift;
import PageFactory.SeleniumWorkShiftEditor;

public class Demo {

    String driverPath = "D:\\geckodriver\\geckodriver.exe";
    WebDriver driver;
    SeleniumLogin objLogin;
    SeleniumMainPage objMainPage;
    SeleniumWorkShift objShiftsPage;
    SeleniumWorkShiftEditor objShiftEditor;
    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.gecko.driver", driverPath);

        driver = new FirefoxDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");



    }

    @Test(priority=0)
    public void test_WorkShift_correctness() {
        objLogin = new SeleniumLogin(driver);
        objLogin.log_In("Admin", "admin123");
        objMainPage = new SeleniumMainPage(driver);
        objMainPage.moveToWorkShifts();
        objShiftsPage = new SeleniumWorkShift(driver);
        objShiftsPage.addWorkShift("RandomName", "06:00", "18:00", "Orange Test");
        objShiftEditor = new SeleniumWorkShiftEditor(driver);
        Assert.assertTrue(objShiftEditor.getWorkShiftInfoString().contains("RandomName"));
        Assert.assertTrue(objShiftEditor.getWorkShiftInfoString().contains("06:00"));
        Assert.assertTrue(objShiftEditor.getWorkShiftInfoString().contains("18:00"));
        Assert.assertTrue(objShiftEditor.getWorkShiftInfoString().contains("12.00"));

    }

    @Test(priority=0)
    public void test_WorkShift_deletion_correctness() {
        objShiftEditor.deleteWorkShift();
        int removal_test = objShiftEditor.getAmountOfShifts();
        Assert.assertEquals(removal_test,2);
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }

    public static void main(String[] args){
        Demo new_Demo = new Demo();
        new_Demo.setup();
        new_Demo.test_WorkShift_correctness();
        new_Demo.test_WorkShift_deletion_correctness();
        new_Demo.endSession();
    }

}
