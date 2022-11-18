package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;


public class TC2_SearchHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	
	

	@Then("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelAnd(String location, String hotels, String roomType, String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) throws AWTException, InterruptedException {
		pom.getSearchHotelPage().searchHotels(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
	}
	@Then("User should verify after searching a hotel success message {string}")
	public void userShouldVerifyAfterSearchingAHotelSuccessMessage(String expSuccessMsg) throws InterruptedException {
	WebElement searchHotelSuccessMsg = pom.getSearchHotelPage().getSearchHotelSuccessMsg();
	Thread.sleep(3000);
	String actSuccessMsg = getTextFromWebpage(searchHotelSuccessMsg);
	boolean b = actSuccessMsg.contains(expSuccessMsg);

	Assert.assertTrue("Verify After Search Hotel Success Message", b);

	}
	
	@Then("User should search hotel enter only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelEnterOnlyMandatoryFieldsAnd(String location, String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom) throws AWTException, InterruptedException {
		pom.getSearchHotelPage().searchHotelsWithMandatoryFields(location, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}
	
	
	@Then("User should verify after searching a hotel with invalid date error message {string},{string}")
	public void userShouldVerifyAfterSearchingAHotelWithInvalidDateErrorMessage(String expCheckInDateErrorMsg, String expCheckOutDateErrorMsg) {
		WebElement checkInDateErrorMsg = pom.getSearchHotelPage().getCheckInDateErrorMsg();
		String textFromWebpage = getTextFromWebpage(checkInDateErrorMsg);
		boolean b = textFromWebpage.contains(expCheckInDateErrorMsg);
	
		Assert.assertTrue("Verify After Enter Invalid Date Error Message", b);
		WebElement checkOutDateErrorMsg = pom.getSearchHotelPage().getCheckOutDateErrorMsg();
	    String textFromWebpage1 = getTextFromWebpage(checkOutDateErrorMsg);
		boolean b1 = textFromWebpage1.contains(expCheckOutDateErrorMsg);
	
		Assert.assertTrue("Verify After Enter Invalid Date Error Message", b1);
		}


	@Then("User should  search hotel click search without entering any credentials")
	public void userShouldSearchHotelClickSearchWithoutEnteringAnyCredentials() throws InterruptedException {
		pom.getSearchHotelPage().searchHotelsWithoutAnyFields();

		}
	
	@Then("User should verify after searching a hotel with error message {string}")
	public void userShouldVerifyAfterSearchingAHotelWithErrorMessage(String withoutAnyFieldErrorMsg)  {
		WebElement withoutAnyFieldErrorMsg2 = pom.getSearchHotelPage().getWithoutAnyFieldErrorMsg();
		String textFromWebpage = getTextFromWebpage(withoutAnyFieldErrorMsg2);
		boolean b = textFromWebpage.contains(withoutAnyFieldErrorMsg);
	
		Assert.assertTrue("Verify After Enter Without Enter Any Fields Error Message", b);
		
	}









}
