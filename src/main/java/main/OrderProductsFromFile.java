package main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingCart;

public class OrderProductsFromFile {

	private static String location = "C:\\Users\\Liudas\\Desktop/data1.txt";
	private static String fileName = "data1.txt";
	private static WebDriver driver;

	public static String getLocation() {
		return location;
	}

	public static void order() throws IOException {
		driver = OpenWebsite.openSite();
		HomePage.ClickLogin(driver);
		LoginPage.fillLoginForm(driver);
		HomePage.selectDigitalDownloads(driver);
		HomePage.addProductsToCart(driver, OrderProductsFromFile.getLocation());
		HomePage.openShoppingCart(driver);
		ShoppingCart.agreeAndCheckout(driver);
		ShoppingCart.fillBillingAddress(driver);
		ShoppingCart.clickContinueAndConfirm(driver);
		driver.quit();
	}

	public static void getParameters(String fileNameInput, String locationInput, WebDriver driverInput) {
		fileName = fileNameInput;
		location = locationInput;
		driver = driverInput;
	}

	// just checking
	public static String printing() {
	    return fileName;
	}


}
