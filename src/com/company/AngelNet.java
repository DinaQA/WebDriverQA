package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by dina.knyr on 30.01.2015.
 */
public class AngelNet {
    /*private static String MasterPassXpath = "//input[@name='master']";
    private static String SiteXpath = "//input[@name='site']";
    private static String GenerateXpath = "//input[@value='Generate']";
    private static String PasswordXpath = "//input[@name='password']";*/
    private static String MasterPassXpath = "//td[contains(text(), 'Your master password')]/..//input[1]";
    private static String SiteXpath = "//td[contains(text(),'Site name')]/..//input[1]";
    private static String GenerateXpath = "//input[@value='Generate']";
    private static String PasswordXpath = "//td[contains(text(), 'Generated password')]/..//input[1]";

    //create method which returns url
    public static void open(WebDriver webDriv) {
        //webDriv.get("http://angel.net/~nic/passwd.current.html");
        //webDriv.get("http://oxogamestudio.com/passwd.current2.htm");
        //webDriv.get("http://oxogamestudio.com/passwd.current3.htm");
        //webDriv.get("http://oxogamestudio.com/passwd.current4.htm");
        webDriv.get("http://oxogamestudio.com/passwd.current7.htm");

    }

    public static boolean checkMasterPass(WebDriver webDrive) {
        WebElement f = webDrive.findElement(By.xpath(MasterPassXpath));

        if (f.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean checkSite(WebDriver webDrive) {
        WebElement f = webDrive.findElement(By.xpath(SiteXpath));

        if (f.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean checkPassword(WebDriver webDrive) {
        WebElement f = webDrive.findElement(By.xpath(PasswordXpath));

        if (f.isEnabled()) {
            return true;
        }
        return false;
    }

    public static void setMasterPass(WebDriver webDrive, String MasterPass) {
        WebElement f = webDrive.findElement(By.xpath(MasterPassXpath));
        f.sendKeys(MasterPass);
    }

    public static String getMasterPass(WebDriver webDrive) {
        WebElement f = webDrive.findElement(By.xpath(MasterPassXpath));
        return f.getAttribute("value");
    }

    public static void setSite(WebDriver webDrive, String site) {
        WebElement f = webDrive.findElement(By.xpath(SiteXpath));
        f.sendKeys(site);
    }

    public static String getSite(WebDriver webDrive) {
        WebElement f = webDrive.findElement(By.xpath(SiteXpath));
        return f.getAttribute("value");
    }

    public static void generate(WebDriver webDrive) throws InterruptedException {
        WebElement f = webDrive.findElement(By.xpath(GenerateXpath));
        f.click();
        Thread.sleep(1000);
    }

    public static String getPassword(WebDriver webDrive) {
        WebElement f = webDrive.findElement(By.xpath(PasswordXpath));
        return f.getAttribute("value");
    }

    public static String symbolValue() {
        String symbolMasterPass = "";
        symbolMasterPass = "aDіІЇЦjK19~!@#$%^&*)_+=-;:.,/?";
        return symbolMasterPass;
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

    public static void timeOut(WebDriver webDriver) throws InterruptedException {

        int timeout = 10000;
        int timepassed = 0;
        WebElement h;
        while (timepassed < timeout){
            if (webDriver.findElements(By.xpath(PasswordXpath)).size() > 0) {
                h = webDriver.findElements(By.xpath(PasswordXpath)).get(1);
                break;
            }
            Thread.sleep(100);
            timepassed += 100;
        }
    }
}

