package ai.selfhealing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.Annotations;

/**
 * Custom ElementLocatorFactory to integrate AI self-healing with PageFactory
 */
public class AIElementLocatorFactory implements ElementLocatorFactory {

    private final WebDriver driver;

    public AIElementLocatorFactory(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public ElementLocator createLocator(java.lang.reflect.Field field) {
        // Build the By object from field annotations
        By by = new Annotations(field).buildBy();

        // Return custom AIElementLocator
        return new AIElementLocator(driver, by);
    }
}