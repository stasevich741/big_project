package com.example.big_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {
    WebDriver driver;

    @BeforeEach
    void configure() {
//        driver = new ChromeDriver();
    }

    @Test
    void simpleTestForChrome() {
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        WebElement element = driver.findElement(By.cssSelector("input[id='username']"));
        element.sendKeys("123");
        element.submit();

//        String errorText = driver.findElement(By.cssSelector("div#error.loginError")).getText();
//        String errorText = driver.findElement(By.id("error")).getText();
        String errorText = driver.findElement(By.xpath("//*[@id='error']")).getText();
        assertThat(errorText).isEqualTo("Please enter your password.");
    }

    @Test
    @DisplayName("simple test for firefox")
    void simpleTestForFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

//    @AfterEach
//    void close() {
//        driver.quit();
//    }
}

