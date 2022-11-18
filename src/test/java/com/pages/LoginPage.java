package com.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserNa;

	@FindBy(id = "password")
	private WebElement txtPass;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(className = "auth_error")
	private WebElement txtErrorLogin;

	public WebElement getTxtUserNa() {
		return txtUserNa;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtErrorLogin() {
		return txtErrorLogin;
	}
	public void loginCommonSteps(String userName, String password) {
		elementSendKeys(getTxtUserNa(), userName);
		elementSendKeys(getTxtPass(), password);
	}

	public void login(String userName, String password) {
		loginCommonSteps(userName, password);
		elementClick(btnLogin);
	}
	public void loginWithEnter(String userName, String password) throws AWTException {
		loginCommonSteps(userName, password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void loginWithInvalidCredential(String userName, String password) {
		loginCommonSteps(userName, password);
		elementClick(btnLogin);
	}
	

}
