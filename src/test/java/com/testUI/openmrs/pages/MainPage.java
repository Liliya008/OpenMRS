package com.testUI.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = ".icon-search")
    private WebElement findPatientRecordButton;

    public void clickFindPatientRecord(){
        findPatientRecordButton.click();
    }

}
