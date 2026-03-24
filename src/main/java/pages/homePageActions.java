package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class homePageActions extends homePageRepo {


        public homePageActions(WebDriver driver){ super(driver);}

        public String validateHomePageBankName(){

               return getBankName().getText();
        }

        public boolean validateHeadingLoop(){
            return getHeadingLoop().isDisplayed();
        }

        public boolean validatingMenuList(List<String > menuListfromExcel){
            List<String> menuListFromUI = new ArrayList<>();
            for(WebElement ele:getMenuList()){
                menuListFromUI.add(ele.getText().trim());
            }
            System.out.println(menuListFromUI);
            System.out.println(menuListfromExcel);
            if(menuListFromUI.equals(menuListfromExcel)){
                return true;
            }
            else{
                return false;
            }
        }
}
