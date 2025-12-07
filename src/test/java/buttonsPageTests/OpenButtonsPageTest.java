package buttonsPageTests;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ButtonsPage;
import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.MainPage;

import static browser.Config.START_URL;

public class OpenButtonsPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    private ButtonsPage buttonsPage;
    private ElementsPage elementsPage;


    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        driver.get(START_URL);
        elementsPage = mainPage.openElements();

    }
    @Test
    public void step_1(){
        elementsPage.openTextBoxPage();
        //Assert.assertTrue(buttonsPage.isPageOpen());
    }
    /*@Test
    public void step_2(){
        WebElement doubleClickBtn = driver.findElement(ButtonsPage.DOUBLE_CLICK_BTN);
        WebElement rightClickBtn = driver.findElement(ButtonsPage.RIGHT_CLICK_BTN);
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        actions.contextClick(rightClickBtn).perform();
    }*/
    @Test
    public void step_3(){
        WebElement element = driver.findElement(By.xpath("//div[text()='Widgets']"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    @AfterTest
    public void afterTest(){

        driver.quit();
    }
}

