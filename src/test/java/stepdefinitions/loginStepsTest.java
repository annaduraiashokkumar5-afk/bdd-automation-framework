package stepdefinitions;


import hooks.Hooks;

import org.testng.Assert;
import pages.homePageActions;
import pages.loginPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.ConfigReader;
import utils.ExcelReader;

import java.io.IOException;
import java.util.Map;


public class loginStepsTest {


    ConfigReader configReader = new ConfigReader();
        Map<String, String> testData;

    loginPageActions loginpageActions = new loginPageActions(Hooks.driver);
    homePageActions homepageActions = new homePageActions();

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        Hooks.driver.get("https://demo.guru99.com/V1/index.php");
        Assert.assertEquals(loginpageActions.getUserText().isDisplayed(), Boolean.TRUE);
    }
    @When("user enters username and password")
    public void user_enters_credentials() throws InterruptedException, IOException {
           String filePath = System.getProperty("user.dir")
                   + "/src/test/resources/test-data/"
                   + configReader.getExcelName();
           testData = ExcelReader.getRowData(filePath, "LoginPage", 1);
            loginpageActions.enterUserId(testData.get("username"));
            loginpageActions.enterPassword(testData.get("Password"));
    }

    @And("user clicks on login button")
    public void user_clicks_login_button(){
        loginpageActions.clickLoginButton();
    }

    @Then("user should navigate to Homepage")
    public void verify_login_success(){
        //Assert.assertEquals(homepageActions.bankName.isDisplayed(),"Successfully navigated to Homepage");
    }
}
