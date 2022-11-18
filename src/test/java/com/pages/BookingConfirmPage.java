package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
public class BookingConfirmPage extends BaseClass  {
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//td[@class='login_title']")
	private WebElement bookConformSuccessMsg;
	
	public WebElement getBookConformSuccessMsg() {
		return bookConformSuccessMsg;
	}
	
	@FindBy(id = "order_no" )
	private WebElement bookOrderId;
	
	public WebElement getBookOrderId() {
		return bookOrderId;
	}

	public String getOrderID() {
		String orderId = getAttributeValue(getBookOrderId(), "value");
		return orderId;		
	}

}
