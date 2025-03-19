package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Data.UserCredentials;

public class LoginPage {
	private static By _registerButton = By.xpath("//input[@class='button-1 register-button']");
	private static By _emailInput = By.xpath("//input[@id='Email']");
	private static By _passwordInput = By.xpath("//input[@id='Password']");
	private static By _loginButton = By.xpath("//input[@class='button-1 login-button']");

	public static void ClickRegister(WebDriver driver) {
		driver.findElement(_registerButton).click();
	}

	public static void fillLoginForm(WebDriver driver) {
		driver.findElement(_emailInput).sendKeys(UserCredentials.getEmail());
		driver.findElement(_passwordInput).sendKeys(UserCredentials.getPassword());
		driver.findElement(_loginButton).click();
	}
}
