package com.stepdefinition;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should book hotel {string},{string} and {string}")
	public void userShouldBookHotelAnd(String firstName, String lastName, String billingAddress, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> asMaps = dataTable.asMaps();
	     Map<String, String> map = asMaps.get(0); 
	     String cardNum = map.get("cardNo");
	     String cardType = map.get("creditCardType");
	     String expMonth = map.get("selectMonth");
	     String expYear = map.get("selectYear");
	     String CVV = map.get("cvv");
	     pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress,cardNum, cardType, expMonth, expYear, CVV);
	}
	@Then("User should verify after booking success message {string} and saved order id")
	public void userShouldVerifyAfterBookingSuccessMessageAndSavedOrderId(String expBookingSuccessMsg) {
		WebElement bookConformSuccessMsg = pom.getBookingConfirmPage().getBookConformSuccessMsg();
		String textFromWebpage = getTextFromWebpage(bookConformSuccessMsg);
	    Assert.assertEquals("verify booking confirmation", expBookingSuccessMsg, textFromWebpage);
	     
		WebElement bookOrderId = pom.getBookingConfirmPage().getBookOrderId();
	   String bookId = getTextFromWebpage(bookOrderId);
	    System.out.println(bookId);
		
	}
	@Then("User should click book now")
	public void userShouldClickBookNow() {
		pom.getBookHotelPage().bookHotleWithoutAnyFields();

	}
	@Then("User should verify after click book now button error message {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterClickBookNowButtonErrorMessageAnd(String expFirstNameErrMsg, String expLastNameErrMsg, String expAddErrorMsg,String expccNoErrorMsg, String expccTypeErrorMsg, String expMonErrMsg, String expcvvErrorMsg) {
		WebElement fstNameErrorMsg = pom.getBookHotelPage().getFstNameErrorMsg();
		String txtFstNa = getTextFromWebpage(fstNameErrorMsg);
		boolean b = txtFstNa.contains(expFirstNameErrMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b);

		WebElement lstNameErrorMsg = pom.getBookHotelPage().getLstNameErrorMsg();
		String txtLstNa = getTextFromWebpage(lstNameErrorMsg);
		boolean b1 = txtLstNa.contains(expLastNameErrMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b1);

		WebElement addErrorMsg = pom.getBookHotelPage().getAddErrorMsg();
		String address = getTextFromWebpage(addErrorMsg);
		boolean b2 = address.contains(expAddErrorMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b2);

		WebElement ccNOErrorMsg = pom.getBookHotelPage().getCcNoErrorMsg();
		String txtCC = getTextFromWebpage(ccNOErrorMsg);
		boolean b3 = txtCC.contains(expccNoErrorMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b3);

		WebElement ccTypeErrorMsg = pom.getBookHotelPage().getCcTypeErrorMsg();
		String txtType = getTextFromWebpage(ccTypeErrorMsg);
		boolean b4 = txtType.contains(expccTypeErrorMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b4);

		WebElement ccExpErrorMsg = pom.getBookHotelPage().getCcExpiryErrorMsg();
		String txtExp = getTextFromWebpage(ccExpErrorMsg);
		boolean b5 = txtExp.contains(expMonErrMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b5);

		WebElement cvvErrorMsg = pom.getBookHotelPage().getCvvErrorMsg();
		String txtcvv = getTextFromWebpage(cvvErrorMsg);
		boolean b6 = txtcvv.contains(expcvvErrorMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b6);

	}

}
