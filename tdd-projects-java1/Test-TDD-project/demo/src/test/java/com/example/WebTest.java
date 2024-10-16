package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;

class WebTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // Assurez-vous d'avoir le driver Chrome dans votre PATH
        driver = new ChromeDriver();
    }

    @Test
    void testGoogleSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("JUnit 5");
        driver.findElement(By.name("q")).submit();
        Assertions.assertTrue(driver.getTitle().contains("JUnit 5"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}