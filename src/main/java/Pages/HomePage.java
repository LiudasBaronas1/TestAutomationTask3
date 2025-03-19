package Pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import Data.UserCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static By _loginItem = By.xpath("//a[@href='/login']");
	private static By _digitalDownloads = By.xpath("//a[@href='/digital-downloads']");
	private static By _shoppingCartItem = By.xpath("//a[@href='/cart']");

	public static void ClickLogin(WebDriver driver) {
		driver.findElement(_loginItem).click();
	}

	public static void selectDigitalDownloads(WebDriver driver) {
		driver.findElement(_digitalDownloads).click();
	}

	public static void addProductsToCart(WebDriver driver, String location) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(location));
		String productName;

		while ((productName = reader.readLine()) != null) {
			productName = productName.trim(); // whitespace ištrinimas

			List<WebElement> products = driver.findElements(By.className("product-title"));
			for (WebElement product : products) {
				if (product.getText().trim().contains(productName)) { // randamas produktas pagal tekstą
					product.click();

					// add to cart mygtukas
					WebElement addToCartButton = driver
							.findElement(By.xpath("//input[contains(@id, 'add-to-cart-button')]"));
					addToCartButton.click();

					// palaukiam kol atnaujina krepšelį
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					driver.findElement(By.linkText("Digital downloads")).click();
					break;
				}
			}
		}
		reader.close();
	}
	
	public static void openShoppingCart(WebDriver driver) {
		driver.findElement(_shoppingCartItem).click();
	}

}
