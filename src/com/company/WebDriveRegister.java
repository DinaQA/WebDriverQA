package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Created by dina.knyr on 26.01.2015.
 */
public class WebDriveRegister {
    public static void main(String[] args) throws InterruptedException, AWTException {
        /*Test Practice Automation Form
        1. Проверяем значения по умолчанию во всех контролах (полях, чек боксах, дропдаунах)
        2. Проверяем текст всех заголовков
        3. Заполняем всю форму верными значениями*/

        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

        WebDriver webDriv = new ChromeDriver();
        webDriv.get("http://demoqa.com/registration/");

        WebElement firstName = webDriv.findElement(By.id("pie_register_reg_form"));
        List<WebElement> listLabel = firstName.findElements(By.tagName("Label"));

        String Fname = listLabel.get(0).getText();


        if(Fname.equals("First Name")) {
            WebElement setFname = webDriv.findElement(By.id("name_3_firstname"));
            if(setFname.getText().equals("")) {
                setFname.sendKeys("Test First Name");
                System.out.println("Test passed: First name is set");
            } else{
                System.out.println("Test failed: First name is not empty");
            }
        }
        else{
            System.out.println("Test failed: First name is missed");
        }

        WebElement lastName = webDriv.findElement(By.id("name_3_lastname"));
        if(lastName.getText().equals("")) {
            lastName.sendKeys("Test Last Name");
        } else{
            System.out.println("Test failed: Last name is autocomplited");
        }





        //webDriv.quit();
    }
}
