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


    @FindBy(xpath = "//div[@class='unknown-patient col-12 mt-2']")
    private WebElement recordMessage;

    public  void validateRecordMessage(String expectedMessage) throws InterruptedException {
        Assert.assertTrue(BrowserUtils.getText(recordMessage).contains(expectedMessage));

    }

    @FindBy(css = ".PersonName-givenName")
    private WebElement patientFirstName;
    @FindBy(css = ".PersonName-familyName")
    private WebElement patientLastName;
    @FindBy(css = "//span[.='100LTM']")
    private WebElement id;


}
