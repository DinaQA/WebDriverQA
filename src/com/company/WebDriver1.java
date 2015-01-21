package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
/**
 * Created by Dina.Knyr on 20.01.2015.
 */
public class WebDriver1 {
    public static void main(String[] args) throws InterruptedException {
        // Validate first result and print
        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

        WebDriver webDriv = new ChromeDriver();
        webDriv.get("http://google.com");

        WebElement webElem = webDriv.findElement(By.id("gbqfq"));
        webElem.sendKeys("qa factory");

        WebElement searchButton = webDriv.findElement(By.id("gbqfb"));
        searchButton.click();

        Thread.sleep(1000);

        WebElement searchResult = webDriv.findElement(By.id("ires"));
        List<WebElement> listSearch = searchResult.findElements(By.tagName("a"));
        WebElement firstResult = listSearch.get(0);

        //System.out.println(firstResult.getText());
        if (firstResult.getText().equals("QA Factory")) {
            System.out.println("Test name: passed.");
        } else {
            System.out.println("Test name: failed.");
        }

        //System.out.println(firstResult.getAttribute("href"));
        if (firstResult.getAttribute("href").equals("http://qafactory.com.ua/")) {
            System.out.println("Test link: passed.");
        } else {
            System.out.println("Test link: failed.");
        }

        webDriv.quit();
    }
}
