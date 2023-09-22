package com.testUI.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {
    public  RegisterPatientPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#checkbox-unknown-patient")
    private WebElement unidentifiedPatientCheckBox;
    @FindBy(xpath = "//select[@id='gender-field']")
    private WebElement patientGender;
    @FindBy(xpath = "//button[@id='next-button']")
    private WebElement nextButton;
    @FindBy (css = "#submit")
    private WebElement confirmButton;

    public void clickUnidentifiedPatient(){
        unidentifiedPatientCheckBox.click();
    }
    public void chooseGender(String patientGender){
        Select select=new Select(this.patientGender);
        select.selectByVisibleText(patientGender);

    }
    public void clickNextButton(){
        nextButton.click();
    }
    public void clickConfirmButton() throws InterruptedException {
        confirmButton.click();
        Thread.sleep(3000);
    }
}
