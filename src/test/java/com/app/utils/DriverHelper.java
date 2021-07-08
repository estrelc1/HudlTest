package com.app.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class DriverHelper {

	protected WebDriver driver;
	public WebDriverWait wait;

	public DriverHelper(WebDriver webdriver) {
		driver = webdriver;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public void Log(String logMsg) {
		System.out.println(logMsg);
	}

	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));

		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		}

		else if (locator.startsWith("class=")) {
			result = By.className(locator.replace("class=", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		}

		else if (locator.startsWith("id=")) {
			result = By.id(locator.replace("id=", ""));
		} else if (locator.startsWith("(")) {
			result = By.xpath(locator);
		} else {
			result = By.id(locator);
		}

		return result;
	}

	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getWebDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {

		}

		return result;
	}

	public Boolean isElementDisplayed(String locator) {

		Boolean result = false;
		try {
			getWebDriver().findElement(ByLocator(locator)).isDisplayed();
			result = true;
		} catch (Exception ex) {

		}
		return result;
	}

	public void WaitForElementPresent(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotPresent(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (!isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementEnabled(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotEnabled(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementVisible(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (getWebDriver().findElement(ByLocator(locator)).isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotVisible(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!getWebDriver().findElement(ByLocator(locator)).isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Boolean isElementPresent1(WebElement el) {
		Boolean result = false;
		try {
			el.isDisplayed();
			result = true;
		} catch (Exception ex) {

		}
		return result;
	}

	public void mouseDoubleClick(String locator) {
		this.WaitForElementPresent(locator, 50);
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		Actions builder = new Actions(getWebDriver());
		builder.doubleClick(el).perform();
	}

	public void dragAndDrop(String draggable, String to) {
		WebElement elDraggable = getWebDriver().findElement(ByLocator(draggable));
		WebElement todrag = getWebDriver().findElement(ByLocator(to));
		Actions builder = new Actions(getWebDriver());
		builder.dragAndDrop(elDraggable, todrag).perform();
	}

	public void selectDropDownByVisibleText(WebElement element, String targetValue) {
		Select select = new Select(element);
		select.selectByVisibleText(targetValue);
		// select.selectByValue(targetValue);
	}

	public boolean WaitUntilWebElementIsInvisible(WebElement element) {
		try {
			this.wait = new WebDriverWait(driver, 15);
			this.wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println("WebElement is not visible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is  visible, using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is  visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean WaitUntilWebElementIsVisible(WebElement element) {
		try {
			this.wait = new WebDriverWait(driver, 15);
			this.wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean WaitUntilWebElementIsClickable(WebElement element) {
		try {
			this.wait = new WebDriverWait(driver, 15);
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean waitUntilPreLoadElementDissapears(By element) {
		return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

}
