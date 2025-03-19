package main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;

public class TaskAutomation {

	public static void main(String[] args) throws IOException {
		WebDriver driver = OpenWebsite.openSite();// TODO uto-generated method stub
		HomePage.ClickLogin(driver);
		LoginPage.ClickRegister(driver);
		RegistrationPage.fillRegistrationForm(driver);
		RegistrationPage.clickContinue(driver);
		driver.quit();
		
		
		OrderProductsFromFile.getParameters("data1.txt", "C:\\Users\\Liudas\\eclipse-workspace\\Task3point1Project\\src\\text\\data1.txt", driver);
		OrderProductsFromFile.order();
		
		OrderProductsFromFile.getParameters("data2.txt", "C:\\Users\\Liudas\\eclipse-workspace\\Task3point1Project\\src\\text\\data2.txt", driver);
		OrderProductsFromFile.order();

	}

}
