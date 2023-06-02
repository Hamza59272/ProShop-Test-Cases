package com.example.demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Set browser size
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1280, 800));

        // Add AllureSelenide listener for logging
        io.qameta.allure.selenide.AllureSelenide allureSelenide = new io.qameta.allure.selenide.AllureSelenide();
        com.codeborne.selenide.logevents.SelenideLogger.addListener("allure", allureSelenide);

        // Set headless mode and timeout
        com.codeborne.selenide.Configuration.headless = true;
        com.codeborne.selenide.Configuration.timeout = 60000;

        // Test case: signup
        driver.navigate().to("http://35.93.156.206:81/register");
        driver.findElement(By.id("name")).sendKeys("hamza123");
        driver.findElement(By.id("email")).sendKeys("hamza@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hamza123");
        driver.findElement(By.name("confirmPassword")).sendKeys("hamza123");
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/div/form/button")).click();
        url = driver.getCurrentUrl();
        //Go to Home Page
        assertEquals("http://35.93.156.206:81/", url);
        driver.manage().deleteAllCookies();

        // Test case: login
        driver.navigate().to("http://35.93.156.206:81/login");
        driver.findElement(By.id("email")).sendKeys("hamza@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hamza123");
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/div/form/button")).click();
        String url = driver.getCurrentUrl();
        assertEquals("http://35.93.156.206:81/", url);
        driver.manage().deleteAllCookies();



        // Test case: signupDuplicate
        driver.navigate().to("http://35.93.156.206:81/register");
        driver.findElement(By.id("name")).sendKeys("hamza123");
        driver.findElement(By.id("email")).sendKeys("hamza@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hamza123");
        driver.findElement(By.name("confirmPassword")).sendKeys("hamza123");
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/div/form/button")).click();
        String error = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/div/div[1]")).getText();
        assertEquals("block", error);
        driver.manage().deleteAllCookies();

        // Test case: buy a product and place order
        driver.navigate().to("http://35.93.156.206:81/login");
        //First Login
        driver.findElement(By.id("email")).sendKeys("hamza@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hamza123");
        //Choose Product
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/div/form/button")).click();
        //Click on Add To Cart
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[3]/div/div/div[4]/button")).click();
        //Click on Proceed To checkout
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div/div[2]/button")).click();
        //Fill the Address Form
        driver.findElement(By.id("address")).sendKeys("Islamabad");
        driver.findElement(By.id("city")).sendKeys("Isl");
        driver.findElement(By.id("postalCode")).sendKeys("40772");
        driver.findElement(By.id("country")).sendKeys("pakistan");
        //Go to Choose Payment Method
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button")).click();
        //Click on Continue
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div/div/form/button")).click();
        //Click on Place Order
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[2]/div/div/div[7]/button")).click();
        url = driver.getCurrentUrl();
        assertEquals("http://35.93.156.206:81/orders", url);
        driver.manage().deleteAllCookies();

        // Test case: edit your name
        driver.navigate().to("http://35.93.156.206:81/profile");
        driver.findElement(By.id("name")).sendKeys("Hamza Shahid");
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[1]/form/button")).click();
        url = driver.getCurrentUrl();
        assertEquals("http://35.93.156.206:81/profile", url);
        driver.manage().deleteAllCookies();

        driver.close();
    }
}
