package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PurchaseForeignCurrencyDefinition {

    WebDriver driver;

    @Given("User navigate to zero bank application")
    public void user_navigate_to_zero_bank_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/login.html");
    }
    @Given("User login to their account")
    public void user_login_to_their_account() {
        WebElement userInput = driver.findElement(By.id("user_login"));
        userInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

        driver.navigate().back();

    }
    @Given("User needs to click online Banking")
    public void user_needs_to_click_online_banking() {
        WebElement onlineBankingButton = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingButton.click();

    }
    @When("User click on pay bills and click Purchase Foreign Currency")
    public void user_click_on_pay_bills_and_click_purchase_foreign_currency() {
        WebElement payBillsButton = driver.findElement(By.id("pay_bills_link"));
        payBillsButton.click();

        WebElement clickPurchaseForeign = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]"));
        clickPurchaseForeign.click();
    }
    @Then("User should select Currency {string}, {string}")
    public void user_should_select_currency(String currency, String amount) {

        WebElement countryField = driver.findElement(By.id("pc_currency"));

        Select slc = new Select(countryField);
        slc.selectByVisibleText(currency);

        WebElement amountInput = driver.findElement(By.id("pc_amount"));
        amountInput.sendKeys(amount);

        WebElement clickRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        clickRadioButton.click();

        WebElement clickPurchase = driver.findElement(By.id("purchase_cash"));
        clickPurchase.click();
    }

    @Then("User should see success message after clicking on the purchase button")
    public void user_should_see_success_message_after_clicking_on_the_purchase_button() {

     WebElement successMessage = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(successMessage.getText().toLowerCase().contains("foreign"));

        driver.quit();
    }






}
