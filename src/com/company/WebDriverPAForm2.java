package com.company;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.Select;

        import java.awt.*;
        import java.awt.datatransfer.StringSelection;
        import java.awt.event.KeyEvent;


public class WebDriverPAForm2 {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.toolsqa.com/automation-practice-form/");

        WebElement link1 = driver.findElement(By.id("content")).findElements(By.tagName("a")).get(0);

        System.out.println(link1.getText());

        WebElement d = driver.findElement(By.id("continents"));
        Select s = new Select(d);

        s.selectByVisibleText("Africa");


        System.out.println(s.getFirstSelectedOption().getText());

        WebElement g = driver.findElement(By.id("selenium_commands"));
        Select s2 = new Select(g);



        Actions f = new Actions(driver).click(s2.getOptions().get(0)).keyDown(Keys.LEFT_SHIFT).click(s2.getOptions().get(4));
        f.perform();

        driver.findElement(By.id("photo")).click();

        StringSelection ss = new StringSelection("D:\\Dina\\desktop\\lake_house_3-wallpaper-1920x1080.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);


        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        //robot.keyPress(KeyEvent.VK_ENTER);
        //robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //driver.quit();
    }
}