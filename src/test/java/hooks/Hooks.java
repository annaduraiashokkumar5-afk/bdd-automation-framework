package hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;

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

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if (driver != null) {
            String status = scenario.getStatus().name(); // PASSED/FAILED
            status = status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase();

            try {
                // 1️⃣ Take screenshot as File
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // 2️⃣ Define path
                String screenshotPath = System.getProperty("user.dir")
                        + "/test-output/screenshots/"
                        + scenario.getName().replaceAll(" ", "_") + "_" + status + ".png";

                File destFile = new File(screenshotPath);

                // 3️⃣ Copy to destination
                FileUtils.copyFile(srcFile, destFile);

                System.out.println("Screenshot saved at: " + screenshotPath);

                // 4️⃣ Attach screenshot for Extent using path (important)
                scenario.attach(FileUtils.readFileToByteArray(destFile), "image/png", status + "_Screenshot");

            } catch (Exception e) {
                e.printStackTrace();
            }

            driver.quit();
        }

    }
}
