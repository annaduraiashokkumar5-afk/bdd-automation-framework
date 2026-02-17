package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigReader;
import utils.CustomWait;

import java.time.Duration;

public class basePage {

    protected WebDriver driver;
    protected CustomWait wait;
    protected ConfigReader configReader;

    public basePage(WebDriver driver) {
        this.driver = driver;
        configReader = new ConfigReader();
        PageFactory.initElements(driver, this);
        this.wait = new CustomWait(driver, Duration.ofSeconds(configReader.getGlobalWaitValue()));
    }

}
