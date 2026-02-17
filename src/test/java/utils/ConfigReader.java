package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

    public String getURL(){
        return prop.getProperty("URL");

    }

    public String getBrowser() {
        return prop.getProperty("BROWSER");
    }
    public Long getGlobalWaitValue(){
        return Long.parseLong(prop.getProperty("GLOBALWAIT"));
    }

    public String  getExcelName(){
        return prop.getProperty("Test_Data_Excel");
    }
}
