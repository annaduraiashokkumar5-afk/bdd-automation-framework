package hooks;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {
    public static WebDriver driver;
    @Before
    public void setUp() {
        System.out.println("Before Hook running");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
