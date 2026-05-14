package hooks;
import io.cucumber.java.AfterStep;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


public class Hooks {
    public static WebDriver driver;
    @Before
    public void setUp() {
        System.out.println("Before Hook running");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @AfterStep
    public void addScreenshotAfterEachStep() {

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Step Screenshot",
                "image/png",
                new ByteArrayInputStream(screenshot),
                ".png"
        );
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
                driver.quit();
    }

    }

