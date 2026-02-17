package pages;


import org.openqa.selenium.WebDriver;

public class loginPageActions extends loginPageRepo {


    public loginPageActions(WebDriver driver) {
        super(driver);
    }

    public void enterUserId(String username) throws InterruptedException {
        getUserId().sendKeys(username);

    }

    public void enterPassword(String password){
        getPassword().sendKeys(password);
    }

    public void clickLoginButton(){
        getLoginBtn().click();
    }


}
