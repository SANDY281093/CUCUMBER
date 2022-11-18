package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SelectHotelStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();


	@Then("User should select a hotel and click continue")
	public void userShouldSelectAHotelAndClickContinue() throws InterruptedException {
		pom.getSelectHotelPage().selectHotel();
	}
	@Then("User should verify after selecting a hotel successs message {string}")
	public void userShouldVerifyAfterSelectingAHotelSuccesssMessage(String expSuccessMsg) {
		WebElement selectHotelsuccessMsg = pom.getBookHotelPage().getSelectHotelSuccessMsg();
		String textFromWebpage = getTextFromWebpage(selectHotelsuccessMsg);
		Assert.assertEquals("Verify After Selecting Hotel Success Message", expSuccessMsg, textFromWebpage);

	}

	

	@Then("User should click continue without select a hotel")
	public void userShouldClickContinueWithoutSelectAHotel() {
		pom.getSelectHotelPage().withoutSelectHotel();
	}
	@Then("User should verify without selecting a hotel error message {string}")
	public void userShouldVerifyWithoutSelectingAHotelErrorMessage(String expErrorMsg) {
		WebElement withoutSelectErrorMsg = pom.getSelectHotelPage().getWithoutSelectHotelErrorMsg();
		String textFromWebpage = getTextFromWebpage(withoutSelectErrorMsg);
		boolean b = textFromWebpage.contains(expErrorMsg);
		Assert.assertTrue("Verify After Without Selecting Hotel Error Messag", b);

	}






}
