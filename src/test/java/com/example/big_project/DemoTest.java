package com.example.big_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.get("https://google.com");
        driver.navigate().to("https://yahoo.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.yahoo.com/");
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

    @AfterEach
    void close() {
        driver.quit();
    }
}

