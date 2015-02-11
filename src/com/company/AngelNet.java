package com.company;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by dina.knyr on 30.01.2015.
 */
public class AngelNet {
    private static String MasterPassXpath = "//td[contains(text(), 'Your master password')]/..//input[1]";
    private static String SiteXpath = "//td[contains(text(),'Site name')]/..//input[1]";
    private static String GenerateXpath = "//input[@value='Generate']";
    private static String PasswordXpath = "//td[contains(text(), 'Generated password')]/..//input[1]";

    //create method which returns url
    public static void open(WebDriver webDriv) {
        //webDriv.get("http://angel.net/~nic/passwd.current.html");
        webDriv.get("http://oxogamestudio.com/passwd.current7.htm");

    }

    public static boolean checkMasterPass(WebDriver webDrive) throws InterruptedException {
        WebElement f = FindElement(webDrive, MasterPassXpath);

        if (f.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean checkSite(WebDriver webDrive) throws InterruptedException {
        WebElement f = FindElement(webDrive, SiteXpath);

        if (f.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean checkPassword(WebDriver webDrive) throws InterruptedException {
        WebElement f = FindElement(webDrive, PasswordXpath);


        if (f.isEnabled()) {
            return true;
        }
        return false;
    }

    public static void setMasterPass(WebDriver webDrive, String MasterPass) throws InterruptedException {
        WebElement f = FindElement(webDrive, MasterPassXpath);
        f.sendKeys(MasterPass);
    }

    public static String getMasterPass(WebDriver webDrive) throws InterruptedException {
        WebElement f = FindElement(webDrive, MasterPassXpath);
        return f.getAttribute("value");
    }

    public static void setSite(WebDriver webDrive, String site) throws InterruptedException {
        WebElement f = FindElement(webDrive, SiteXpath);
        f.sendKeys(site);
    }

    public static String getSite(WebDriver webDrive) throws InterruptedException {
        WebElement f = FindElement(webDrive, SiteXpath);

        return f.getAttribute("value");
    }

    public static void generate(WebDriver webDrive) throws InterruptedException {

        WebElement f = FindElement(webDrive, GenerateXpath);
        f.click();

    }

    public static void assertPassword(WebDriver webDrive, String expectedPassword) throws InterruptedException {
        WebElement f = FindElement(webDrive, PasswordXpath);

        WaitValue(f, expectedPassword);
    }

    public static String passRandom() {
        String abcName = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()_+=-";
        Random r = new Random();
        int i = 0;
        String passRandom = "";
        while (i < 7) {
            int n = r.nextInt(abcName.length());
            passRandom = passRandom + abcName.charAt(n);
            i++;
        }
        return passRandom;
    }


    public static String passMax() {
        String abcName = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()_+=-";
        Random r = new Random();
        int i = 0;
        String passRandom = "";
        while (i < 32) {
            int n = r.nextInt(abcName.length());
            passRandom = passRandom + abcName.charAt(n);
            i++;
        }
        return passRandom;
    }

    public static String siteMax() {
        String abcName = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()_+=-";
        Random r = new Random();
        int i = 0;
        String siteMax = "";
        while (i < 128) {
            int n = r.nextInt(abcName.length());
            siteMax = siteMax + abcName.charAt(n);
            i++;
        }
        return siteMax;
    }

// find and wait for element on the page
    public static WebElement FindElement(WebDriver webDriver, String XPath) throws InterruptedException {

        int timeout = 10000;
        int timepassed = 0;
        WebElement h;
        while(timepassed < timeout){
            if (webDriver.findElements(By.xpath(XPath)).size() > 0){
                h = webDriver.findElements(By.xpath(XPath)).get(0);
                return h;

            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail("Not found element with xpath: "+XPath);
        return null; //no values returned
    }
    public static void WaitValue(WebElement webElement, String expectedResult) throws InterruptedException {

        int timeout = 10000;
        int timepassed = 0;
        WebElement h;
        while(timepassed < timeout){
            if (webElement.getAttribute("value").equals(expectedResult)){
                return;// for void only
            }
            Thread.sleep(100);
            timepassed += 100;

    }
        Assert.fail("Expected result: "+expectedResult+ "\n" +
                " Actual result: " +webElement.getAttribute("value"));
    }

}

