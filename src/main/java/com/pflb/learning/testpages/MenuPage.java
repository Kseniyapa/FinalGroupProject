package com.pflb.learning.testpages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

    public MenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href=\"/about\"][@class=\"nl-header-link\"]")
    private WebElement menuItemProduct; //Вкладка "О продукте"

    @FindBy(xpath = "//div[@class=\"section-start__text\"]/h2")
    private WebElement productTitle; //Заголовок вкладки "О продукте"

    @FindBy(xpath = "//a[@href=\"/price\"][@class=\"nl-header-link\"]")
    private WebElement menuItemPrice; //Вкладка "Цена"

    @FindBy(xpath = "//div[@class=\"price-header\"]/h3")
    private WebElement productPrice; //Заголовок вкладки "Цена"

    @FindBy(xpath = "//a[@href=\"/faq\"][@class=\"nl-header-link\"]")
    private WebElement menuItemFAQ; //Вкладка "FAQ"

    @FindBy(xpath = "//div[@class=\"nl--bold nl-faq-header\"]")
    private WebElement productFAQ; //Заголовок вкладки "FAQ"

    @FindBy(xpath = "//a[@href=\"/tester-register\"][@class=\"nl-header-link\"]")
    private WebElement menuItemWantTest; //Вкладка "Хочу тестировать сайты"

    @FindBy(xpath = "//div[@class=\"section-header__info\"]/h1")
    private WebElement productWantTest; //Заголовок вкладки "Хочу тестировать сайты"



    public String getProductTitle() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }

    public void clickItemProduct() {
        menuItemProduct.click();
    }

    public String getPriceTitle() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.getText();
    }

    public void clickItemPrice() {
        menuItemPrice.click();
    }

    public String getFAQTitle() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(productFAQ));
        return productFAQ.getText();
    }

    public void clickItemFAQ() {
        menuItemFAQ.click();
    }

    public String getWantTestTitle() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(productWantTest));
        return productWantTest.getText();
    }

    public void clickItemWantTest() {
        menuItemWantTest.click();
    }

}
