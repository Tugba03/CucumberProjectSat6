package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestDefinition {

    WebDriver driver;

    @Given("User navigate to website")
    public void user_navigate_to_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/login.html");

    }
    @When("User enter valid {string} and {string}")
    public void user_enter_valid_and(String Username, String Password) {

        WebElement userInput = driver.findElement(By.id("user_login"));
        userInput.sendKeys(Username);

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys(Password);

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

        driver.navigate().back();

    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/index.html";

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @When("User enter valid {string} and invalid {string}")
    public void user_enter_valid_and_invalid(String Username1, String Password1) {
        WebElement userInput = driver.findElement(By.id("user_login"));
        userInput.sendKeys(Username1);

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys(Password1);

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

    }

    @When("User enter invalid {string} and valid {string}")
    public void user_enter_invalid_and_valid(String Username2, String Password2) {
        WebElement userInput = driver.findElement(By.id("user_login"));
        userInput.sendKeys(Username2);

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys(Password2);

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

    }

    @When("User enter invalid {string} and invalid {string}")
    public void user_enter_invalid_and_invalid(String Username3, String Password3) {

        WebElement userInput = driver.findElement(By.id("user_login"));
        userInput.sendKeys(Username3);

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys(Password3);

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();


    }


    @Then("Login should fail")
    public void login_should_fail() {
        WebElement errorMessage = driver.findElement(By.cssSelector("#login_form>div"));
        String actualError = errorMessage.getText().toLowerCase();
        String msg = "Login and/or password are wrong.";
        String expectedResult = msg.toLowerCase();
        Assert.assertEquals(actualError, expectedResult);
    }


}
