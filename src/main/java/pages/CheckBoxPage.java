package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }
    public By headerLocator = By.xpath("//div[@class='main-header' and text()='Check Box']");
    public static final String CHECK_BOX_INPUT_XPATH = "//input[@type='checkbox'][following-sibling::span[text()='%s']]";
    public static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/following-sibling::span[@class='rct-checkbox']";
    public static final String BUTTON_TOGGLE = CHECK_BOX_INPUT_XPATH + "/../preceding-sibling::button[@title='Toggle']";
    public static final String LIST_CHECKBOX_XPATH = CHECK_BOX_INPUT_XPATH + "/ancestor::li[contains(@class,'%s')]";
    public static final String LIST_CHECKBOX_OPEN = "expanded";
    public static final String LIST_CHECKBOX_CLOSED = "collapsed";
    public boolean isPageOpen(){
        return driver.findElement(headerLocator).isDisplayed();
    }
    public boolean getCheckBoxState(String checkBoxName){
        return driver.findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH,checkBoxName))).isSelected();
    }
    public void setCheckBox(String checkBoxName, boolean state){
        //String locator = String.format(CHECK_BOX_XPATH, checkBoxName) + "/following-sibling::span[@class='rct-checkbox']";
        if (!getCheckBoxState(checkBoxName)==state){
            driver.findElement(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName))).click();
        }
    }
    public void openListCheckBox(String checkBoxName){
        if (!isCheckBoxDisplay(checkBoxName)){
            failure();
        }
        if (isListCheckBoxClosed(checkBoxName)){
            driver.findElement(By.xpath(String.format(BUTTON_TOGGLE,checkBoxName))).click();
        }
    }
    public boolean isCheckBoxDisplay(String checkBoxName){
        return driver.findElement(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName))).isDisplayed();
    }
    public boolean isListCheckBoxOpen(String checkBoxName){
        return driver.findElement(By.xpath(String.format(LIST_CHECKBOX_XPATH,checkBoxName,LIST_CHECKBOX_OPEN))).isDisplayed();
    }
    public boolean isListCheckBoxClosed(String checkBoxName){
        return driver.findElement(By.xpath(String.format(LIST_CHECKBOX_XPATH,checkBoxName,LIST_CHECKBOX_CLOSED))).isDisplayed();
    }
}
