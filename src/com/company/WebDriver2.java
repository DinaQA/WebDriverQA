package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Dina.Knyr on 20.01.2015.
 */
public class WebDriver2 {
    public static void main(String[] args) throws InterruptedException {
        //print all links for search result
        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

        WebDriver webDriv = new ChromeDriver();
        webDriv.get("http://google.com");

        WebElement webElem = webDriv.findElement(By.id("gbqfq"));
        webElem.sendKeys("qa factory");

        WebElement searchButton = webDriv.findElement(By.id("gbqfb"));
        searchButton.click();

        Thread.sleep(10000);
        WebElement searchResult = webDriv.findElement(By.id("ires"));
        List<WebElement> listSearch = searchResult.findElements(By.tagName("a"));

        int num;
        num=listSearch.size();

        for (int i=0; i<=num-1; i++){
            WebElement firstResult = listSearch.get(i);


            //if (firstResult.getText().startsWith("QA")) {

                System.out.println(firstResult.getText());
                System.out.println(firstResult.getAttribute("href"));
            //}
        }
        System.out.println("No results for display.");
        webDriv.quit();
    }
}
