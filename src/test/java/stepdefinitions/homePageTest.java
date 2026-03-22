package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.homePageActions;
import pages.loginPageActions;
import utils.ConfigReader;
import utils.ExcelReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class homePageTest {


    ConfigReader configReader = new ConfigReader();
    Map<String, String> testData;
    List<String> menuList;


    loginPageActions loginpageActions = new loginPageActions(Hooks.driver);
    homePageActions homepageActions = new homePageActions(Hooks.driver);

    @Given("user logged in using valid credentials")
    public void user_logged_in_using_valid_credentials() throws InterruptedException, IOException {
        Hooks.driver.get("https://demo.guru99.com/V1/index.php");
        Assert.assertEquals(loginpageActions.getUserText().isDisplayed(), Boolean.TRUE);
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/test-data/"
                + configReader.getExcelName();
        testData = ExcelReader.getRowData(filePath, "LoginPage", 1);
        loginpageActions.enterUserId(testData.get("username"));
        loginpageActions.enterPassword(testData.get("Password"));
        loginpageActions.clickLoginButton();
    }

    @Then("user should see the menu list and heading loop")
    public void user_should_see_the_menu_list_and_heading_loop() throws IOException {
        Assert.assertEquals(homepageActions.validateHomePageBankName(), "Gtpl Bank");
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/test-data/"
                + configReader.getExcelName();
        menuList = ExcelReader.getColumnValues(filePath,"HomePage",0);

        Assert.assertEquals(homepageActions.validatingMenuList(menuList),Boolean.TRUE);
        Assert.assertEquals(homepageActions.validateHeadingLoop(),Boolean.TRUE);
    }
}





