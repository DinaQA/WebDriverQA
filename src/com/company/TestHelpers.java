package com.company;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dina.knyr on 04.02.2015.
 */
public class TestHelpers {
    private static String PriceXpath1 = "//div[@id='osago_calc_result']//tr[1]//span[1]";
    private static String CompanyXpath1 = "//div[@id='osago_calc_result']//tr[1]//img[1]";
    private static String CompanyXpath2 = "//div[@id='osago_calc_result']//tr[2]//img[1]";
    private static String CompanyXpath3 = "//div[@id='osago_calc_result']//tr[3]//img[1]";
    private static String FranchiseXpath = "//div[@id='osago_calc_result']//tr[1]//a[contains(text(), 'Франшиза')]";
    private static String URL1 = "https://strahovator.com.ua/auth/propose";

    public static WebDriver driver;

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void open() {
        driver.get("https://strahovator.com.ua/");
    }
    public static void close() {
        driver.quit();
    }

    public static void findFranchiseDetails(String franchiseDetails) throws InterruptedException {
        WebElement f = FindElement(FranchiseXpath);
        new Actions(driver).moveToElement(f).build().perform();
        WebElement details = FindElement(FranchiseXpath+"/following-sibling::div[1]");
        Assert.assertEquals(franchiseDetails, details.getText());
    }

    public static void findObject(String expectedMenu) throws InterruptedException {
        WebElement f = FindElement("//a[contains(text(), '"+expectedMenu+"')]");
    }

    public static void click(String expectedMenu1) throws InterruptedException {
        WebElement f = FindElement("//a[contains(text(), '"+expectedMenu1+"')]");
        f.click();
    }

    public static void checkDefaultValue(String expectedXPath, String expectedValue) throws InterruptedException {
        WebElement f = FindElement("//span[contains(text(), '"+expectedXPath+"')]/following-sibling::select");
        Select s = new Select(f);
        String result = s.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedValue, result);
    }

    public static void setDropDownValue(String expectedXPath, String expectedValue) throws InterruptedException {
        WebElement f = FindElement("//span[contains(text(), '"+expectedXPath+"')]/following-sibling::select");
        Select s = new Select(f);
        s.selectByVisibleText(expectedValue);
    }

    public static void checkFirstPrice(String expectedValue) throws InterruptedException {
        WebElement f = FindElement(PriceXpath1);
        Assert.assertEquals(expectedValue, f.getText());
    }

    public static void checkFirstCompany(String expectedValue) throws InterruptedException {
        WebElement f = FindElement(CompanyXpath1);
        String c = convertToCompanyName(f.getAttribute("src"));
        Assert.assertEquals(expectedValue, c);
    }

    public static void checkSecondCompany(String expectedValue) throws InterruptedException {
        WebElement f = FindElement(CompanyXpath2);
        String c = convertToCompanyName(f.getAttribute("src"));
        Assert.assertEquals(expectedValue, c);
    }
    public static void checkThirdCompany(String expectedValue) throws InterruptedException {
        WebElement f = FindElement(CompanyXpath3);
        String c = convertToCompanyName(f.getAttribute("src"));
        Assert.assertEquals(expectedValue, c);
    }

    public static void checkAllValues(String expectedXPath, String[] expectedValues) throws InterruptedException {
        WebElement f = FindElement("//span[contains(text(), '" + expectedXPath + "')]/following-sibling::select");
        Select s = new Select(f);
        List<WebElement> result = s.getOptions();
        int n = result.size();
        String[] expected = expectedValues;
        int m = expected.length;
        if (n == m) {
            for (int i = 0; i < n - 1; i++) {
                Assert.assertEquals(expected[i], result.get(i).getText());
            }
        }
        else
            Assert.fail("Values do not match");
    }



    public static WebElement FindElement(String XPath) throws InterruptedException {
        int timeout = 10000;
        int timepassed = 0;
        WebElement h;
        while(timepassed < timeout){
            if (driver.findElements(By.xpath(XPath)).size() > 0){
                h = driver.findElements(By.xpath(XPath)).get(0);
                return h;
            }
            Thread.sleep(100);
            timepassed += 100;
        }
        Assert.fail("Not found element with xpath: " + XPath);
        return null; //no values returned
    }

    private static Map<String, String> companies = new HashMap<String, String>(){{
        put("https://strahovator.com.ua/images/custom/osago/ut.gif", "Utico");
        put("https://strahovator.com.ua/images/custom/osago/sk.gif", "СКАЙД");
        put("https://strahovator.com.ua/images/custom/osago/il.gif", "ІЛЛІЧІВСЬКЕ");
    }};

    public static String convertToCompanyName(String img){
        if (img.equals("https://strahovator.com.ua/images/custom/osago/ut.gif"))
            return "Utico";
        if (img.equals("https://strahovator.com.ua/images/custom/osago/sk.gif"))
            return "СКАЙД";
        if (img.equals("https://strahovator.com.ua/images/custom/osago/il.gif"))
            return "ІЛЛІЧІВСЬКЕ";
        Assert.fail("Unknown company requested");
        return "UNKNOWN COMPANY!";
    }

    public static String convertFromCompanyName(String com){
        if (com.equals("Utico"))
            return "https://strahovator.com.ua/images/custom/osago/ut.gif";
        if (com.equals("sk.gif"))
            return "СКАЙД";
        if (com.equals("il.gif"))
            return "ІЛЛІЧІВСЬКЕ";
        Assert.fail("Unknown company requested");
        return "UNKNOWN COMPANY!";

    }

    public static void clickBuy(String expectedPath) throws InterruptedException {
        WebElement f = FindElement("//button[contains(text(), '"+expectedPath+"')]");
        f.click();
        Assert.assertEquals(URL1, driver.getCurrentUrl());
    }

    public static void checkRegistrationTypes(String expectedMenu, int a) throws InterruptedException {
        WebElement f = FindElement("//div[@class='content'//a[1] '"+expectedMenu+"']");
    }

    public static void findRegistrationType(String expectedMenu) throws InterruptedException {
        WebElement f = FindElement("//a[contains(text(), '"+expectedMenu+"')]");
    }

}
