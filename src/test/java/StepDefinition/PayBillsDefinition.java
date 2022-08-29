package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PayBillsDefinition {
    WebDriver driver;

    @Given("User navigate to zero bank")
    public void user_navigate_to_zero_bank() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/login.html");

    }

    @Given("User login to the account")
    public void user_login_to_the_account() {
        WebElement userInput = driver.findElement(By.id("user_login"));
        userInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

        driver.navigate().back();


    }

    @Given("User go click online banking on the homepage")
    public void user_go_click_online_banking_on_the_homepage() {

        WebElement onlineBankingButton = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingButton.click();

    }

    @When("User click on pay bills and click on add new payee")
    public void user_click_on_pay_bills_and_click_on_add_new_payee() {

        WebElement payBillsButton = driver.findElement(By.id("pay_bills_link"));
        payBillsButton.click();
        WebElement addNewPayee = driver.findElement(By.linkText("Add New Payee"));
        addNewPayee.click();

    }

    @Then("User should be able to fill out {string}, {string}, {string}, {string}and add new payee")
    public void user_should_be_able_to_fill_out_and_add_new_payee(String name, String address, String account, String details) {

        WebElement payeeNameInput = driver.findElement(By.cssSelector("input[name='name']"));
        payeeNameInput.sendKeys(name);

        WebElement payeeAddressInput = driver.findElement(By.cssSelector("div>textarea"));
        payeeAddressInput.sendKeys(address);

        WebElement payeeAccountInput = driver.findElement(By.cssSelector("input[name='account']"));
        payeeAccountInput.sendKeys(account);

        WebElement payeeDetails = driver.findElement(By.id("np_new_payee_details"));
        payeeDetails.sendKeys(details);

        WebElement addButton = driver.findElement(By.id("add_new_payee"));
        addButton.click();

    }

    @Then("user should see success message")
    public void user_should_see_success_message() {
        WebElement successMessage = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(successMessage.getText().toLowerCase().contains("success"));

        driver.quit();

    }

    @Then("User should see error message: Please fill out this field.")
    public void user_should_see_error_message_please_fill_out_this_field() {

        WebElement successMessage = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(!successMessage.isDisplayed());

        driver.quit();
    }

}



