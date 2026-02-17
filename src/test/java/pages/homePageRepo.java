package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePageRepo  {



    public WebElement getBankName() {
        return bankName;
    }

    public void setBankName(WebElement bankName) {
        this.bankName = bankName;
    }

    @FindBy(xpath = "//*[text()='Gtpl Bank']")
    public WebElement bankName;
}
