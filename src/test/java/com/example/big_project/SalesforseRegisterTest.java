package com.example.big_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SalesforseRegisterTest {

    WebDriver driver;

    @BeforeEach
    void configure() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("enter data to register form Salesforse test")
    void enterDataToRegisterFormSalesforseTest() {
        driver.navigate().to("https://login.salesforce.com/");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id='Login']")).click();
    }

//    @AfterEach
//    void close() {
//        driver.quit();
//    }
}
