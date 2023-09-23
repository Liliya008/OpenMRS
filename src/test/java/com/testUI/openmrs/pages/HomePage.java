package com.testUI.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='apps']//a[4]")
    private WebElement registerPatientButton;
registerPatientRevised
    @FindBy(xpath = "//div[@id='apps']//a[1]")
    private WebElement findPatientRecordButton;


    @FindBy (css = "#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    private WebElement findPatientRecordButton;
    public void findPatientButton(){
        findPatientRecordButton.click();
    }


    public void chooseRegisterPatient(){
        registerPatientButton.click();
    }
    public void chooseFindPatientRecord(){
        findPatientRecordButton.click();
    }


}
