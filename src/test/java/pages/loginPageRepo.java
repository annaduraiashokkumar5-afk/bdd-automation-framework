package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class loginPageRepo extends basePage {


    public loginPageRepo(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserId() throws InterruptedException {
        wait.waitForVisibilityOfElement(userId);
        return userId;
    }

    public void setUserId(WebElement userId) {
        this.userId = userId;
    }

    public WebElement getPassword() {
        wait.waitForVisibilityOfElement(password);
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(WebElement loginBtn) {
        this.loginBtn = loginBtn;
    }

    public WebElement getResetBtn() {
        return resetBtn;
    }

    public void setResetBtn(WebElement resetBtn) {
        this.resetBtn = resetBtn;
    }

    public WebElement getUserText() {
       wait.waitForVisibilityOfElement(userText);
        return userText;
    }

    public void setUserText(WebElement userText) {
        this.userText = userText;
    }

    @FindBy(xpath = "(//td[@align='center'])[2]")
    public WebElement userText;


    @FindBy(xpath = "//*[@name='uid']")
    public WebElement userId;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;


    @FindBy(xpath = "//*[@value='LOGIN']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@value='RESET']")
    public WebElement resetBtn;



}
