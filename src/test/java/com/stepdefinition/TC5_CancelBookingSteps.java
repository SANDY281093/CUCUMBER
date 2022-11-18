package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_CancelBookingSteps extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should cancel order id")
	public void user_should_cancel_order_id() throws InterruptedException {
		String orderID = pom.getBookingConfirmPage().getOrderID();
		pom.getCancelBookingPage().cancelOrderId(orderID);

	   
	}
	@Then("User should verify after cancelled order id success message {string}")
	public void user_should_verify_after_cancelled_order_id_success_message(String expCancelSuccessMsg) {
		WebElement cancelSuccessMsg = pom.getCancelBookingPage().getCancelSuccessMsg();
		String textFromWebpage = getTextFromWebpage(cancelSuccessMsg);
		boolean b = textFromWebpage.contains(expCancelSuccessMsg);
		Assert.assertTrue("Verify After Cancel Order ID Success Message", b);

	}

	@Then("User should cancel the existing order id {string}")
	public void user_should_cancel_the_existing_order_id(String existingOrderID) throws InterruptedException {
		pom.getCancelBookingPage().cancelHotelByExistingOrderId(existingOrderID);
	
	}








}
