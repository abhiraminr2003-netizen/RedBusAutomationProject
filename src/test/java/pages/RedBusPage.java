package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedBusPage {

    WebDriver driver;

    // From
    By from = By.id("srcinput");

    // To
    By to = By.id("destinput");

    // Date
    By date = By.xpath("//div[@aria-label='Select date of journey']");

    // 20th date
    By date20 = By.xpath("//span[text()='20']");

    // Search buses
    By searchBuses = By.xpath("//button[contains(.,'Search buses')]");

    public RedBusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFrom(String location) {
        driver.findElement(from).sendKeys(location);
    }

    public void enterTo(String location) {
        driver.findElement(to).click();
        driver.findElement(to).sendKeys(location);
    }

    public void clickDate() {
        driver.findElement(date).click();
    }

    public void selectDate() {
        driver.findElement(date20).click();
    }

    public void clickSearchBuses() {
        driver.findElement(searchBuses).click();
    }
}