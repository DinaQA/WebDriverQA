package com.company;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Dina.Knyr on 20.01.2015.
 */
public class WebDriver3 {
    public static void main(String[] args) throws InterruptedException {
        //check translations for 5 words
        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

        WebDriver webDriv = new ChromeDriver();
        webDriv.get("https://translate.google.com");

        String[] input = {"робота","завдання","субота"};
        String[] output = {"work","task","teacher"};

        int k=0;

        WebElement sourceTrans = webDriv.findElement(By.id("source"));

        while (k<input.length) { //get length of array

            sourceTrans.clear();
            sourceTrans.sendKeys(input[k]);

            Thread.sleep(1000);

            String result = webDriv.findElement(By.id("result_box")).getText();

            //System.out.println(result);
            if (result.equals(output[k])){
                System.out.println("QA validation: passed for "+input[k]);
            }
            else {
                System.out.println("QA validation: failed for "+input[k]);
            }
            k=k+1;
        }
        webDriv.quit();
    }
}
