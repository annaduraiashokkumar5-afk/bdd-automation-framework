package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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


    public List<WebElement> getMenuList() {
      //  wait.waitForVisibilityOfElement(menuList);
        return menuList;
    }

    public void setMenuList(List<WebElement> menuList) {
        this.menuList = menuList;
    }

    public WebElement getHeadingLoop() {
        wait.waitForVisibilityOfElement(headingLoop);
        return headingLoop;
    }

    public void setHeadingLoop(WebElement headingLoop) {
        this.headingLoop = headingLoop;
    }

    @FindBy(xpath = "//*[text()='Gtpl Bank']")
    public WebElement bankName;


    @FindBy(xpath = "//*[@class='menusubnav']/li")
    public List<WebElement> menuList;

    @FindBy(xpath = "//*[@class='heading3']")
    public WebElement headingLoop;

}
