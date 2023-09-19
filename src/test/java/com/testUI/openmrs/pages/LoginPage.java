package com.testUI.openmrs.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(css = "#Laboratory")
    private WebElement laboratory;

    @FindBy(xpath = "//input[@id='loginButton']")
    private WebElement loginButton;

    @FindBy(css = "#error-message")
    private WebElement errorMessage;

    public void provideCredentials(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }
    public void login(){
        laboratory.click();
        loginButton.click();
    }

    public void validateTitle(WebDriver driver, String title){
        Assert.assertEquals(title,driver.getTitle());
    }

    public void validateErrorMessage(String expectedErrorMessage){
        Assert.assertEquals(expectedErrorMessage,BrowserUtils.getText(errorMessage));

    }



}
