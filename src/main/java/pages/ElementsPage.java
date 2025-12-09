package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ElementsPage extends BasePage {
    /**
     * Класс описывающий страницу Elements
     * @param driver
     */
    /**
     * Конструктор класса, позволяет передевать экземпляр драйвера на наследуюемые страницы
     * @param driver
     */
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Локаторы веб элементов, находящихся на странице
     */
    public By header = By.xpath("//div[@class='main-header' and text()='Elements']");
    public By message = By.xpath("//div[text()='Please select an item from left to start practice.']");
    public By textBoxLocator = By.xpath("//span[text()='Text Box']");
    public By checkBoxLocator = By.xpath("//span[text()='Check Box']");
    public By radioButtonLocator = By.xpath("//span[text()='Radio Button']");
    public By dynamicPropertiesLocator = By.xpath("//span[text()='Dynamic Properties']");
    public By buttonsLocator = By.xpath("//span[text()='Buttons']");


    /**
     * Проверка открытия страницы. Возвращает true, когда локаторы отображаются на старинице. Метод findElement находит элемент на странице, метод isDisplayed проверяет,
     * отображается ли эти локаторы на странице, как проверить? подставьте в элемент значение "style="display: none"
     * @return
     */
    public boolean isPageOpen(){
        boolean a = driver.findElement(header).isDisplayed();
        boolean b = driver.findElement(message).isDisplayed();
        return a && b;
    }

    /**
     * Нажимает на вебэлемент "Text Box" и возвращает экземпляр класса (страницы) TextBoxPage для дальнейшей работы с ней
     * @return
     */
    public TextBoxPage openTextBoxPage(){
        driver.findElement(textBoxLocator).click();
        return new TextBoxPage(driver);
    }

    public CheckBoxPage openCheckBoxPage(){
        driver.findElement(checkBoxLocator).click();
        return new CheckBoxPage(driver);
    }
    public RadioButtonsPage openRadioButtonPage(){
        driver.findElement(radioButtonLocator).click();
        return new RadioButtonsPage(driver);
    }
    public DynamicPropertiesPage openDynamicPropertiesPage(){
        driver.findElement(dynamicPropertiesLocator).click();
        return new DynamicPropertiesPage(driver);
    }

    public ButtonsPage openButtonsPage(){
        driver.findElement(buttonsLocator).click();
        return new ButtonsPage(driver);
    }
}
