package com.yourname.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class automates the login functionality of the web application
 * Germany is Calling. It includes tests for both successful and unsuccessful logins.
 */
public class LoginTest {

    private WebDriver driver;

    /**
     * BeforeMethod is used to set up the WebDriver before each test.
     */
    @BeforeMethod
    public void setUp() {
        // Setting up Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();

        // Opening the target URL
        driver.get("https://app.germanyiscalling.com/");
        driver.manage().window().maximize();
    }

    /**
     * Test 1: Verify that the login is successful with valid credentials.
     */
    @Test
    public void testSuccessfulLogin() {
        // Locating the email input field and entering valid credentials
        driver.findElement(By.id("email")).sendKeys("valid_email@example.com");
        driver.findElement(By.id("password")).sendKeys("valid_password");

        // Clicking on the login button
        driver.findElement(By.id("loginButton")).click();

        // Validate if the user is redirected to the dashboard after successful login
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://app.germanyiscalling.com/dashboard";  // Adjust based on the actual URL
        Assert.assertEquals(currentUrl, expectedUrl, "Login was not successful!");
    }

    /**
     * Test 2: Verify that an error message appears when invalid credentials are used.
     */
    @Test
    public void testUnsuccessfulLogin() {
        // Entering invalid email and password
        driver.findElement(By.id("email")).sendKeys("invalid_email@example.com");
        driver.findElement(By.id("password")).sendKeys("invalid_password");

        // Clicking the login button
        driver.findElement(By.id("loginButton")).click();

        // Validate if the error message is displayed
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertTrue(errorMessage.contains("Invalid credentials"), "Expected error message not displayed!");
    }

    /**
     * AfterMethod is used to close the browser after each test.
     */
    @AfterMethod
    public void tearDown() {
        // Closing the browser after the test completes
        driver.quit();
    }
}
