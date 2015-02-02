package com.company;


import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


/**
 * Created by dina.knyr on 28.01.2015.
 */

@RunWith(JUnit4.class)

public class FirstTest {

    WebDriver webDriv;
    boolean testfailed;

    @Rule //get name of Test which is executed now
    public TestName name = new TestName();

    @Before //will be executed before each test
    public void Init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");
        webDriv = new ChromeDriver();
        //webDriv.get("http://demoqa.com/registration/");
        RegistrationForm.open(webDriv); //get link from class RegistrationForm, method 'open'
        Thread.sleep(1000);
        testfailed = false;
    }

    @After // will be executed after each test
    public void Close() throws IOException {
        if (!testfailed) { //creation of screenshot for failed test
            File scrFile = ((TakesScreenshot) webDriv).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("D:\\screen\\"+name.getMethodName()+".jpg"));
        }

        webDriv.quit();
    }

    @Test //mark the following as Test 1
    public void MyTest1(){
        WebElement setFname = webDriv.findElement(By.xpath("//input[@name='first_name']"));
        Assert.assertEquals("", setFname.getText()); //comparison is a=b, where ""-expected result; setFname.getText()-actual result
        Assert.assertTrue(setFname.isEnabled()); //condition is true
    }

    @Test  //
    public void MyTest2(){
        WebElement lastName = webDriv.findElement(By.xpath("//input[@name='last_name']/../label"));
        Assert.assertEquals("Last Name", lastName.getText()); //comparison is a=b, where "Last Name"-expected result, lastName.getText()-actual result

    }

    @Test  //
    public void MyTest3() throws InterruptedException {
        WebElement submit = webDriv.findElement(By.xpath("//input[@name='pie_submit']"));
        submit.click();
        Thread.sleep(1000);
        WebElement error = webDriv.findElement(By.xpath("//input[@name='last_name']/../following-sibling::span[contains(@class, 'legend error')]"));

        Assert.assertEquals("* This field is required", error.getText()); //comparison is a=b, where a-expected result b-actual result
    }
}
