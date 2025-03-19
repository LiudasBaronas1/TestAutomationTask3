package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import java.util.concurrent.TimeUnit;

public class AccountCreationTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAccountCreation() {
        driver.get("https://demowebshop.tricentis.com/");

        HomePage.ClickLogin(driver);
        LoginPage.ClickRegister(driver);
        RegistrationPage.fillRegistrationForm(driver);

        assert driver.getCurrentUrl().contains("registerresult") : "Registration failed!";
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
