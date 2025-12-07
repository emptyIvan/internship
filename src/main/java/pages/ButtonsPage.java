package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }
    public By headerLocator = By.xpath("//div[@class='main-header' and text()='Buttons']");
    public static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn");
    public static final By RIGHT_CLICK_BTN = By.id("rightClickBtn");

    public boolean isPageOpen(){
        return driver.findElement(headerLocator).isDisplayed();
    }
}
