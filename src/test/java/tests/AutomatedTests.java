package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import main.OrderProductsFromFile;
import Data.UserCredentials;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AutomatedTests {
    private WebDriver driver;
    private static UserCredentials user;
    
    @BeforeClass
    public void createUser() {
        user = new UserCredentials();
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demowebshop.tricentis.com/");
        
        HomePage.ClickLogin(driver);
        LoginPage.ClickRegister(driver);
        RegistrationPage.fillRegistrationForm(driver);
        RegistrationPage.clickContinue(driver);
        
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testReadDataFromTxtFile() throws IOException {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage.ClickLogin(driver);
        LoginPage.fillLoginForm(driver);
        
		OrderProductsFromFile.getParameters("data1.txt", "C:\\Users\\Liudas\\eclipse-workspace\\Task3point1Project\\src\\text\\data1.txt", driver);
		assert OrderProductsFromFile.printing().equals("data1.txt") : "File name mismatch!";
    }

    @Test
    public void testOrderProducts() throws IOException {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage.ClickLogin(driver);
        LoginPage.fillLoginForm(driver);
        
		OrderProductsFromFile.getParameters("data2.txt", "C:\\Users\\Liudas\\eclipse-workspace\\Task3point1Project\\src\\text\\data2.txt", driver);
        OrderProductsFromFile.order();
        
        // Validate order success by checking order confirmation page
        assert driver.getCurrentUrl().contains("checkout/completed") : "Order was not completed successfully!";
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
