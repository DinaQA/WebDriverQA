package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.Random;

/**
 * Created by dina.knyr on 26.01.2015.
 */
public class XPathRegister {
    public static void main(String[] args) throws InterruptedException, AWTException {
        /*Test Practice Automation Form
        1. Проверяем значения по умолчанию во всех контролах (полях, чек боксах, дропдаунах)
        2. Проверяем текст всех заголовков
        3. Заполняем всю форму верными значениями*/

        System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");

        WebDriver webDriv = new ChromeDriver();
        webDriv.get("http://demoqa.com/registration/");
        String uname="";
        uname = randomName();
        String passw ="";
        passw = Password();

        WebElement firstName = webDriv.findElement(By.xpath("//input[@name='first_name']/../label"));
        if(firstName.getText().equals("First Name")) {
            WebElement setFname = webDriv.findElement(By.xpath("//input[@name='first_name']"));
            if(setFname.getText().equals("")) {
                setFname.sendKeys("Test First Name");
                System.out.println("Test passed: First name is set");
            } else{
                System.out.println("Test failed: First name is not empty");
            }
        }
        else{
            System.out.println("Test failed: First name is missed");
        }

        WebElement lastName = webDriv.findElement(By.xpath("//input[@name='last_name']/../label"));
        if(lastName.getText().equals("Last Name")) {
            WebElement setLname = webDriv.findElement(By.xpath("//input[@name='last_name']"));
            if(setLname.getText().equals("")) {
                setLname.sendKeys("Test Last Name");
                System.out.println("Test passed: Last name is set");
            } else{
                System.out.println("Test failed: Last name is not empty");
            }
        }
        else{
            System.out.println("Test failed: Last name is missed");
        }

        WebElement Hobby = webDriv.findElement(By.xpath("//input[@value='dance']/../../label"));
        if(Hobby.getText().equals("Hobby")){
            WebElement dance = webDriv.findElement(By.xpath("//input[@value='dance']"));
            if (!dance.isSelected()) {
                dance.click();
                System.out.println("Test passed: Hobby is set");
            }
            else{
                System.out.println("Test failed: Hobby is not empty");
            }
        }

        WebElement country = webDriv.findElement(By.xpath("//select[@id='dropdown_7']/../label"));
        if(country.getText().equals("Country")){
            Select dropCountry = new Select(webDriv.findElement(By.xpath("//select[@id='dropdown_7']")));
            if (!dropCountry.getFirstSelectedOption().equals("")) {
                dropCountry.selectByVisibleText("Japan");
                System.out.println("Test passed: Country is set");
            }
            else{
                System.out.println("Test failed: Country is not set");
            }
        }

        WebElement phone = webDriv.findElement(By.xpath("//input[@name='phone_9']/../label"));
        if(phone.getText().equals("Phone Number")){
            WebElement phoneNumber = webDriv.findElement(By.xpath("//input[@name='phone_9']"));
            if (phoneNumber.getText().equals("")) {
                phoneNumber.sendKeys(randomNumber()); //call function to return random number
                System.out.println("Test passed: Phone is set");
            }
            else{
                System.out.println("Test failed: Phone is not set");
            }
        }

        WebElement usname = webDriv.findElement(By.xpath("//input[@name='username']/../label"));
        if(usname.getText().equals("Username")){
            WebElement username = webDriv.findElement(By.xpath("//input[@name='username']"));
            if (username.getText().equals("")) {
                username.sendKeys(uname);//call function to return random name
                System.out.println("Test passed: Username is set");
            }
            else{
                System.out.println("Test failed: Username is not set");
            }
        }

        WebElement emailadd = webDriv.findElement(By.xpath("//input[@name='e_mail']/../label"));
        if(emailadd.getText().equals("E-mail")){
            WebElement email = webDriv.findElement(By.xpath("//input[@name='e_mail']"));
            if (email.getText().equals("")) {
                email.sendKeys(uname+"@gmail.com"); //call function to return random name
                System.out.println("Test passed: E-mail is set");
            }
            else{
                System.out.println("Test failed: E-mail is not set");
            }
        }

        WebElement Password = webDriv.findElement(By.xpath("//input[@name='password']/../label"));
        if(Password.getText().equals("Password")) {
            WebElement pass = webDriv.findElement(By.xpath("//input[@name='password']"));
            WebElement confpass = webDriv.findElement(By.xpath("//input[@id='confirm_password_password_2']"));
            pass.sendKeys(passw);
            confpass.sendKeys(passw); //why missmatch message is displayed for password?
            System.out.println("Test passed: Password is set");
        }
        else{
            System.out.println("Test failed: Password is not set");
        }

        WebElement submit = webDriv.findElement(By.xpath("//input[@name='pie_submit']"));
        submit.click();

        Thread.sleep(2000);

        WebElement message = webDriv.findElement(By.xpath("//p[@class='piereg_message']"));
        if(message.getText().equals("Thank you for your registration")) {
           System.out.println("Test passed: Registration successful");
        }
        else{
            System.out.println("Test failed: Registration form is not completed correctly");
        }

        webDriv.quit();

    }
    public static String randomNumber(){
        String abcName = "1234567890";
        Random r = new Random();
        int i=0;
        String phoneNumber="";
        while (i<10) {
            int n= r.nextInt(abcName.length());
            phoneNumber = phoneNumber + abcName.charAt(n);
            i++;
        }
        return phoneNumber;
    }
    public static String randomName(){
        String abcName = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_";
        Random r = new Random();
        int i=0;
        String username="";
        while (i<8) {
            int n= r.nextInt(abcName.length());
            username = username + abcName.charAt(n);
            i++;
        }
        return username;
    }
    public static String Password(){
        String abcName = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()_+=-";
        Random r = new Random();
        int i=0;
        String password="";
        while (i<8) {
            int n= r.nextInt(abcName.length());
            password = password + abcName.charAt(n);
            i++;
        }
        return password;
    }
}
