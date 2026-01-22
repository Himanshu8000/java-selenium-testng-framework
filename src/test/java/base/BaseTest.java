package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties properties;

    @BeforeMethod
    public void setup() {
        loadConfig();
        driver = new ChromeDriver();
        driver.get(properties.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
