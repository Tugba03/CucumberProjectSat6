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

public class TransferFundsDefinition {

    WebDriver driver;

    @Given("User login to their account and navigate to transfer funds")
    public void user_login_to_their_account_and_navigate_to_transfer_funds() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement userInput = driver.findElement(By.id("user_login"));
        userInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

         driver.navigate().back();

         WebElement clickTransferFunds = driver.findElement(By.id("transfer_funds_link"));
         clickTransferFunds.click();

    }
    @When("User fill up the following {string}, {string}, {string}, {string} correctly")
    public void user_fill_up_the_following_correctly(String fromAccount, String toAccount, String amount, String description) {
       WebElement fromAccountList = driver.findElement(By.id("tf_fromAccountId"));

        Select slc = new Select(fromAccountList);
        slc.selectByVisibleText(fromAccount);

        WebElement toAccountList = driver.findElement(By.id("tf_toAccountId"));
        Select slc2 = new Select(toAccountList);
        slc2.selectByVisibleText(toAccount);

        WebElement amountBox = driver.findElement(By.id("tf_amount"));
        amountBox.sendKeys(amount);

        WebElement descriptionBox = driver.findElement(By.id("tf_description"));
        descriptionBox.sendKeys(description);

        WebElement clickContinue = driver.findElement(By.id("btn_submit"));
        clickContinue.click();

        WebElement clickSubmit = driver.findElement(By.id("btn_submit"));
        clickSubmit.click();

    }
    @Then("User should get success message after click submit button")
    public void user_should_get_success_message_after_click_submit_button() {

        WebElement successMessage = driver.findElement(By.cssSelector("div[class='alert alert-success']"));
        Assert.assertTrue(successMessage.getText().toLowerCase().contains("successfully"));

        driver.quit();
    }

}
