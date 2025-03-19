package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Data.UserCredentials;

public class RegistrationPage {

	static By _gender = By.xpath("//input[@id='gender-male']");
	static By _firstName = By.xpath("//input[@id='FirstName']");
	static By _lastName = By.xpath("//input[@id='LastName']");
	static By _email = By.xpath("//input[@id='Email']");
	static By _password = By.xpath("//input[@id='Password']");
	static By _confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
	static By _registerButton = By.xpath("//input[@id='register-button']");
	static By _continueButton = By.xpath("//input[@value='Continue']");

	public static void fillRegistrationForm(WebDriver driver) {

		UserCredentials user = new UserCredentials();

		driver.findElement(_gender).click();
		driver.findElement(_firstName).sendKeys(user.getFirstName());
		driver.findElement(_lastName).sendKeys(user.getLastName());
		driver.findElement(_email).sendKeys(user.getEmail());
		driver.findElement(_password).sendKeys(user.getPassword());
		driver.findElement(_confirmPassword).sendKeys(user.getPassword());

		clickRegister(driver);
	}

	public static void clickRegister(WebDriver driver) {
		driver.findElement(_registerButton).click();
	}

	public static void clickContinue(WebDriver driver) {
		driver.findElement(_continueButton).click();
	}
}
