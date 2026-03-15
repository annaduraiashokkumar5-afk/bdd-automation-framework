package pages;


import org.openqa.selenium.WebDriver;
import ai.AIPageFactory;
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
        AIPageFactory.initElements(driver,this);
        this.wait = new CustomWait(driver, Duration.ofSeconds(configReader.getGlobalWaitValue()));
    }

}
