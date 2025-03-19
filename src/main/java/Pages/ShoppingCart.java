package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
	private static By _termsOfService = By.xpath("//input[@id='termsofservice']");
	private static By _checkoutButton = By.xpath("//button[@id='checkout']");
	private static By _countrySelect = By.xpath("//select[@id='BillingNewAddress_CountryId']");
	private static By _city = By.xpath("//input[@id='BillingNewAddress_City']");
	private static By _address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
	private static By _zip = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	private static By _phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	private static By _continueBillingAddress = By.xpath("//input[@class='button-1 new-address-next-step-button']");
	private static By _continuePaymentMethod = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	private static By _continuePaymentInfo = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	private static By _confirmButton = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");

	public static void agreeAndCheckout(WebDriver driver) {
		driver.findElement(_termsOfService).click();
		driver.findElement(_checkoutButton).click();
	}

	public static void fillBillingAddress(WebDriver driver) {
		List<WebElement> existingAddressOptions = driver.findElements(By.id("billing-address-select"));

		if (!existingAddressOptions.isEmpty() && existingAddressOptions.get(0).isDisplayed()) {
			existingAddressOptions.get(0).sendKeys("Existing Address");
		} else {
			driver.findElement(_countrySelect).sendKeys("United States");
			driver.findElement(_city).sendKeys("New York");
			driver.findElement(_address1).sendKeys("123 Main St");
			driver.findElement(_zip).sendKeys("10001");
			driver.findElement(_phoneNumber).sendKeys("1234567890");
		}
		driver.findElement(_continueBillingAddress).click();
	}

	public static void clickContinueAndConfirm(WebDriver driver) {
		driver.findElement(_continuePaymentMethod).click();
		driver.findElement(_continuePaymentInfo).click();
		driver.findElement(_confirmButton).click();
	}
}
