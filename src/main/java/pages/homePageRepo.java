package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePageRepo extends basePage {


    public homePageRepo(WebDriver driver) {
        super(driver);
    }

    public WebElement getBankName() {
        wait.waitForVisibilityOfElement(bankName);
        return bankName;
    }

    public void setBankName(WebElement bankName) {
        this.bankName = bankName;
    }

    @FindBy(xpath = "//*[text()='Gtpl Bank']")
    public WebElement bankName;
}
