package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dina.knyr on 26.01.2015.
 */
public class WebDriverRegistration {
    //Test Practice Automation Form

    System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

    WebDriver webDriv = new ChromeDriver();
    webDriv.get("http://demoqa.com/registration/");

    WebElement firstName = webDriv.findElement(By.name("firstname"));
    firstName.sendKeys("Dina");


    webDriv.quit();

}
