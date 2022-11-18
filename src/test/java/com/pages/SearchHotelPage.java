package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement txtLoginMsg;
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotel;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement noRooms;
	
	@FindBy(id="datepick_in")
	private WebElement checkIn;
	
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	
	@FindBy(id="adult_room")
	private WebElement noAdult;
	
	@FindBy(id="child_room")
	private WebElement noChild;
	
	@FindBy(id="Submit")
	private WebElement submit;
	
	@FindBy(className = "login_title")
	private WebElement searchHotelSuccessMsg;
	
	@FindBy(id="checkin_span")
	private WebElement checkInDateErrorMsg;
	
	@FindBy(id="checkout_span")
	private WebElement checkOutDateErrorMsg;
	
	@FindBy(id = "location_span")
	private WebElement withoutAnyFieldErrorMsg;
	
	public WebElement getCheckInDateErrorMsg() {
		return checkInDateErrorMsg;
	}
	public WebElement getCheckOutDateErrorMsg() {
		return checkOutDateErrorMsg;
	}
	public WebElement getWithoutAnyFieldErrorMsg() {
		return withoutAnyFieldErrorMsg;
	}
	public WebElement getSearchHotelSuccessMsg() {
		return searchHotelSuccessMsg;
	}
	public WebElement getTxtLoginMsg() {
		return txtLoginMsg;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNoRooms() {
		return noRooms;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getNoAdult() {
		return noAdult;
	}
	public WebElement getNoChild() {
		return noChild;
	}
	public WebElement getSubmit() {
		return submit;
	}


	public void searchHotelsCommonSteps(String location, String numberOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) throws AWTException, InterruptedException {
		elementSendKeys( getLocation(), location);
		elementSendKeys(getNoRooms(), numberOfRooms);
		//elementSendKeys(getCheckIn(), checkInDate);
		//elementSendKeys(getCheckOut(), checkOutDate);
//		
//		selectOptionByAttribute(getLocation(), location);
//		selectOptionByValue(getNoRooms(), numberOfRooms);
		mouseOverAction(getCheckIn());
		elementClick(getCheckIn());
		insertTextUsingRobot(getCheckIn(), checkInDate);
//		//Thread.sleep(2000);
		mouseOverAction(getCheckOut());
		elementClick(getCheckOut());
		insertTextUsingRobot(getCheckOut(), checkOutDate);
//		//Thread.sleep(2000);
//		selectOptionByValue(getNoAdult(), adultsPerRoom);
		elementSendKeys(getNoAdult(), adultsPerRoom);
	}

	
	public void searchButton() {
		elementClick(submit);

	}

	public void searchHotels(String location, String hotels, String roomType, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) throws AWTException, InterruptedException {
		searchHotelsCommonSteps(location, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom);
		elementSendKeys(getHotel(), hotels);
		elementSendKeys(getRoomType(), roomType);
		elementSendKeys(getNoChild(), childrenPerRoom);
		
//		selectOptionByAttribute(getHotel(), hotels);
//		selectOptionByAttribute(getRoomType(), roomType);
//		selectOptionByValue(getNoChild(), childrenPerRoom);
		searchButton();
	}

	public void searchHotelsWithMandatoryFields(String location, String numberOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) throws AWTException, InterruptedException {
		searchHotelsCommonSteps(location, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom);
		searchButton();
	}

	public void searchHotelsWithInvalidDate(String location, String hotels, String roomType, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) throws AWTException, InterruptedException {
		searchHotelsCommonSteps(location, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom);
		searchButton();
	}

	public void searchHotelsWithoutAnyFields()  {
		searchButton();
	}
	
	
}
