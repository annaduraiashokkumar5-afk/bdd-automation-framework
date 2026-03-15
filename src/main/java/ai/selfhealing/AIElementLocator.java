package ai.selfhealing;

import org.openqa.selenium.*;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import java.util.List;

public class AIElementLocator implements ElementLocator {

    private WebDriver driver;
    private By by;

    public AIElementLocator(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    @Override
    public WebElement findElement() {

        try {
            return driver.findElement(by);

        } catch (Exception e) {

            String pageSource = driver.getPageSource();

            String healedXpath =
                    XPathHealer.healXpath(by.toString(), pageSource);

            return driver.findElement(By.xpath(healedXpath));
        }
    }

    @Override
    public List<WebElement> findElements() {

        try {
            return driver.findElements(by);

        } catch (Exception e) {

            String pageSource = driver.getPageSource();

            String healedXpath =
                    XPathHealer.healXpath(by.toString(), pageSource);

            return driver.findElements(By.xpath(healedXpath));
        }
    }
}