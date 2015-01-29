package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by dina.knyr on 28.01.2015.
 */
public class RegistrationForm {
    private static String firstNameXpath = "//input[@name='first_name']";

    //create method which returns url
    public static void open(WebDriver webDriv){
        webDriv.get("http://demoqa.com/registration/");

    }
    //create method - sets First name
    public static void setFirsName(WebDriver webDrive, String Fname){
        WebElement f = webDrive.findElement(By.xpath(firstNameXpath));
        f.sendKeys(Fname);
    }

    //create method - sets First name
    public static String getFirsName(WebDriver webDrive){
        WebElement f = webDrive.findElement(By.xpath(firstNameXpath));
        return f.getText();
    }

}
