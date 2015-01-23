package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        //get current date
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String strTodaysDate = dateFormat.format(currentDate);

        //input current date into form
        WebElement date = webDriv.findElement(By.id("datepicker"));
        date.sendKeys(strTodaysDate);
        System.out.println("Test passed: Today's data is set "+strTodaysDate);

        //check if check box is selected
        WebElement profession = webDriv.findElement(By.id("profession-0"));
        if (!profession.isSelected()) {
            profession.click();
            System.out.println("Test passed: Profession is set!");
        }
        else {
            System.out.println("Test failed: Profession is set to default value!");
        }

        //add picture on the form
        WebElement photo = webDriv.findElement(By.id("photo"));
        photo.sendKeys("D:/Dina/hairstyles-and-colors-with-bangs.jpg");


        WebElement tool = webDriv.findElement(By.id("tool-2"));
        tool.click();

        //Select element from drop down list
        Select dropdown = new Select(webDriv.findElement(By.id("continents")));
        dropdown.selectByVisibleText("South America");
        System.out.println("The following continent is selected: " + dropdown.getFirstSelectedOption().getText());

        //select several values in dropdown
        WebElement findComd = webDriv.findElement(By.id("selenium_commands"));
        Select command = new Select(findComd);
        command.selectByIndex(0);
        findComd.sendKeys(Keys.CONTROL);
        command.selectByIndex(1);
        findComd.sendKeys(Keys.CONTROL);
        command.selectByIndex(2);
        findComd.sendKeys(Keys.CONTROL);
        command.selectByIndex(4);
        List<WebElement> checkeditems = command.getAllSelectedOptions();
        System.out.println(checkeditems.get(1).getText());

        //command.selectByVisibleText("Navigation Commands");

        WebElement download = webDriv.findElement(By.partialLinkText("Selenium Automation Hybrid Framework"));
        download.click();

        WebElement button = webDriv.findElement(By.id("submit"));
        button.submit();

        Thread.sleep(1000);

        //click links on the page
        //WebElement partlink = webDriv.findElement(By.partialLinkText("Partial Link"));
        //partlink.click();

        //get first 3 links from the page
        WebElement partlink2 = webDriv.findElement(By.id("content"));
        List<WebElement> allLinks = partlink2.findElements(By.tagName("a"));

        for (int i=0; i<3; i++){
            WebElement firstResult = allLinks.get(i);
            System.out.println(firstResult.getText());
            System.out.println(firstResult.getAttribute("href"));
        }

        Thread.sleep(1000);

        WebElement LinkTest = webDriv.findElement(By.linkText("Link Test"));
        LinkTest.click();

        Thread.sleep(1000);

        //check if PA form is filled or not
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
