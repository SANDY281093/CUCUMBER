package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookHistory;
	
	@FindBy(name="order_id_text")
	private WebElement searchBox;
	
	@FindBy(id="search_hotel_id")
	private WebElement searchGo;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement cancelSelected;
	
	@FindBy(id ="search_result_error")
	private WebElement cancelSuccessMsg;

	public WebElement getCancelSuccessMsg() {
		return cancelSuccessMsg;
	}
	public WebElement getBookHistory() {
		return bookHistory;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getCancelSelected() {
		return cancelSelected;
	}
	public WebElement getSearchGo() {
		return searchGo;
	}
	

	
	public void cancelOrderId(String orderId ) throws InterruptedException {
		elementClick(getBookHistory());
		elementSendKeys(getSearchBox(), orderId );
		elementClick(getSearchGo());
		elementClick(getCancelSelected());
		Thread.sleep(5000);
		switchToAlertWindow();
	}
	
	
	public void cancelHotelByExistingOrderId(String string) throws InterruptedException {
		elementClick(getBookHistory());
		elementSendKeys(getSearchBox(), string);
		elementClick(getSearchGo());
		elementClick(getCancelSelected());
		Thread.sleep(6000);
		switchToAlertWindow();
		
	}


}
