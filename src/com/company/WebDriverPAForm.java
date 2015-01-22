package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Dina.Knyr on 21.01.2015.
 */
public class WebDriverPAForm {
    public static void main(String[] args) throws InterruptedException {
        //Test Practice Automation Form

        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

        WebDriver webDriv = new ChromeDriver();
        webDriv.get("http://www.toolsqa.com/automation-practice-form/");

        WebElement firstName = webDriv.findElement(By.name("firstname"));
        firstName.sendKeys("Dina");

        WebElement lastName = webDriv.findElement(By.name("lastname"));
        lastName.sendKeys("Knyr");

        WebElement sex = webDriv.findElement(By.id("sex-1"));
        sex.click();

        WebElement yearExp = webDriv.findElement(By.id("exp-4"));
        yearExp.click();

        WebElement date = webDriv.findElement(By.id("datepicker"));
        date.sendKeys("01/22/2015");

        WebElement profession = webDriv.findElement(By.id("profession-0"));
        if (!profession.isSelected()) {
            profession.click();
            System.out.println("Profession is selected!");
        }

        WebElement photo = webDriv.findElement(By.id("photo"));
        photo.sendKeys("D:/Dina/hairstyles-and-colors-with-bangs.jpg");


        WebElement tool = webDriv.findElement(By.id("tool-2"));
        tool.click();

        Select dropdown = new Select(webDriv.findElement(By.id("continents")));
        dropdown.selectByVisibleText("South America");

        Select command = new Select(webDriv.findElement(By.id("selenium_commands")));
        command.selectByVisibleText("Navigation Commands");

        WebElement download = webDriv.findElement(By.partialLinkText("Selenium Automation Hybrid Framework"));
        download.click();

        WebElement button = webDriv.findElement(By.id("submit"));
        button.submit();

        Thread.sleep(1000);

        WebElement partlink = webDriv.findElement(By.partialLinkText("Partial Link"));
        partlink.click();

        Thread.sleep(1000);

        WebElement LinkTest = webDriv.findElement(By.linkText("Link Test"));
        LinkTest.click();

        Thread.sleep(1000);

        WebElement check = webDriv.findElement(By.id("content"));
        if (check.getText().contains("Automation")){
            System.out.println("Test passed successfully :)");
        }
        else {
            System.out.println("Test failed :(");
        }

        webDriv.quit();

    }
}
