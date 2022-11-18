package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.math3.fraction.ProperBigFractionFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	protected static WebDriver driver;
	
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
	}
	public  static void enterUrl(String url) {
		driver.get(url);
	}

	public static String getProjectLocator() {
		String path = System.getProperty("user.dir");
		return path;
	}
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\Config\\Config.properties"));
		String value = (String) properties.get(key);
		return value;
	}
	public void maximizeWindows() {
		driver.manage().window().maximize();
	}
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}
	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	public void forwardWebpage() {
		driver.navigate().forward();
	}
	public void backWebpage() {
		driver.navigate().back();
	}
	public void clearText(WebElement element) {
		element.clear();
	}
	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	public WebElement findLocatorByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}
	public WebElement findLocatorByTagName(String attributeValue) {
		WebElement element = driver.findElement(By.tagName(attributeValue));
		return element;
	}
	public WebElement findLocatorByLinkText(String attributeValue) {
		WebElement element = driver.findElement(By.linkText(attributeValue));
		return element;
	}
	public String getTextFromWebpage(WebElement element) {
		String text = element.getText();
		return text;
	}
	// 99%-->value-->fixed
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	// 1%-->Anything
	public String getAttributeValue(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	public String getLocatorIdValue(WebElement element) {
		String attribute = element.getAttribute("id");
		return attribute;
	}
	public void quitAllWindow() {
		driver.quit();
	}
	public void quitWindow() {
		driver.close();
	}
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	public void elementSendKeysJS(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setAttribute('value','" + data + "')", element);
	}
	public void elementClick(WebElement element) {
		element.click();
	}
	public void mouseOverAction(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void dragAndDropAction(WebElement sElement, WebElement dElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(sElement, dElement).perform();
	}
	public void singleClickAction(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleClickAction(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void insertTextUsingRobot(WebElement element,String text) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_DELETE);
		element.sendKeys(text);
	}
	public void switchToAlertWindow() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public boolean createNewFolder(String location) {
		File f = new File(location);
		boolean mkdir = f.mkdir();
		return mkdir;
	}
	public boolean createNewFile(String location) throws IOException {
		File f = new File(location);
		boolean createNewFile = f.createNewFile();
		return createNewFile;
	}
	public boolean checkLocationForFile(String location) {
		File f = new File(location);
		boolean file = f.isFile();
		return file;
	}
	public boolean idFileEditable(String location) {
		File f = new File(location);
		boolean canWrite = f.canWrite();
		return canWrite;
	}
	public boolean isFileReadable(String location) {
		File f = new File(location);
		boolean canRead = f.canRead();
		return canRead;
	}
	public boolean isFileExits(String location) {
		File f = new File(location);
		boolean exists = f.exists();
		return exists;
	}
	public File takeScreenShort(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(location));
		return screenshotAs;
	}
	public byte[] takeScreenShortByte() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}
	public WebDriver switchToFrameByIndex(int index) {
		WebDriver frame = driver.switchTo().frame(index);
		return frame;
	}
	public WebDriver switchToFrameByName(String name) {
		WebDriver frame = driver.switchTo().frame(name);
		return frame;
	}
	public WebDriver switchToFrameByLocator(WebElement element) {
		WebDriver frame = driver.switchTo().frame(element);
		return frame;
	}
	public void selectOptionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void selectOptionByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);
	}
	public void selectOptionByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	public void deSelectOptionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	public void deSelectOptionByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByValue(text);
	}
	public void deSelectOptionByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByVisibleText(value);
	}
	public void deSelectAllValue(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}
	public boolean isMultipleOrNot(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public List<WebElement> getAllOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}
	public WebElement firstSelectedOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}
	public String getParentIdWindow(WebElement element) {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public Set<String> getAllWindowId(WebElement element) {
		Set<String> windowHandle = driver.getWindowHandles();
		return windowHandle;
	}
	public WebDriver switchToChildWindow(String text) {
		WebDriver window = driver.switchTo().window(text);
		return window;
	}
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	public void explicitWait(String element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}
	public void scrollDownByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
	}
	public void scrollUpByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-5000)");
	}
	public void scrollDownByElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void scrollUpByElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public boolean webElementDisplaye(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public boolean webElementEnabled(WebElement element) {
		boolean displayed = element.isEnabled();
		return displayed;
	}
	public boolean webElementSelected(WebElement element) {
		boolean displayed = element.isSelected();
		return displayed;
	}
	public void updataDataInCell(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws Exception {
		File file = new File("");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	public void writeCellData(String sheetName, int rowNum, int cellNum, String data) throws Exception {
		File file = new File("");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		String stringCellValue = cell.getStringCellValue();
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	public String getCellData(String sheetName, int rowNum, int cellNum) throws Exception {
		String res = "";
		File file = new File("");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (numericCellValue == check) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
		default:
			break;
		}
		return res;
	}
	public void writeNewRowCellData(String sheetName,int rowNum, int cellNum, String data) throws Exception {
		File file = new File("");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		String stringCellValue = cell.getStringCellValue();
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
	
	
	

	
	
}
