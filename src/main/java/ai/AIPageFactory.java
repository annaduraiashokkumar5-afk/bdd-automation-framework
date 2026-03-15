package ai;

import ai.selfhealing.AIElementLocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AIPageFactory {

    public static void initElements(WebDriver driver, Object page){

        PageFactory.initElements(new AIElementLocatorFactory(driver), page);
    }
}