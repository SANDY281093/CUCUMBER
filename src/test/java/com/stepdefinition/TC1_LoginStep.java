package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the Adactin hotel login page")
	public void userIsOnTheAdactinHotelLoginPage() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		enterUrl(getPropertyFileValue("url"));
		maximizeWindows();
	  
	}
	@When("User should perform  login {string}, {string}")
	public void userShouldPerformLogin(String userName, String password) {
		pom.getLoginPage().login(userName, password);
	   
	}
	@When("User should perform  login {string}, {string} with Enter key")
	public void userShouldPerformLoginWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(userName, password);

	}

	

	@Then("User should verify after login with invalid credential error message contains  {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMessageContains(String expLoginErrorMsg) {
		WebElement txtErrorLogin = pom.getLoginPage().getTxtErrorLogin();
		String actLoginErrorMsg = getTextFromWebpage(txtErrorLogin);
		boolean contains = actLoginErrorMsg.contains(expLoginErrorMsg);
		Assert.assertTrue("Verify After Login Using Invalid Credential Error Message Contains", contains);

	}







}
