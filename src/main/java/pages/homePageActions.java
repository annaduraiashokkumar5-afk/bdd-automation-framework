package pages;

import org.openqa.selenium.WebDriver;

public class homePageActions extends homePageRepo {


        public homePageActions(WebDriver driver){ super(driver);}

        public String validateHomePageBankName(){
               return getBankName().getText();
        }
}
