package com.testUI.openmrs.pages;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;


public class PatientPage {
    public PatientPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/div/div/p")
    private WebElement successUnidentifiedMessage;
    public void validateSuccessUnidentifiedMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(successUnidentifiedMessage));
    }

    @FindBy(css = ".PersonName-givenName")
    private WebElement patientFirstName;
    @FindBy(css = ".PersonName-familyName")
    private WebElement patientLastName;
    @FindBy(css = "//span[.='100LTM']")
    private WebElement id;


}
