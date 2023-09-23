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
    @FindBy (xpath = "//input[@name='givenName']")
//    private WebElement newPatientGivenName;
//    @FindBy (xpath = "//input[@name='familyName']")
//    private WebElement newPatientFamilyName;
//
//    @FindBy(css = "#next-button")
//    private WebElement nextButton;
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


//public class RegisterPatientPage {
//    public RegisterPatientPage(WebDriver driver){
//        PageFactory.initElements(driver,this);
//    }
//    @FindBy (xpath = "//input[@name='givenName']")
//    private WebElement newPatientGivenName;
//    @FindBy (xpath = "//input[@name='familyName']")
//    private WebElement newPatientFamilyName;
//
//    @FindBy(css = "#next-button")
//    private WebElement nextButton;
//
//    @FindBy(xpath = "//select[@id = 'gender-field']")
//    private WebElement selectGender;
//    @FindBy(xpath = "//input[@id='birthdateDay-field']")
//    private WebElement dateOfBirth;
//    @FindBy(xpath = "//select[@id='birthdateMonth-field']")
//    private WebElement monthOfBirth;
//    @FindBy(xpath = "//input[@id='birthdateYear-field']")
//    private WebElement yearOfBirth;
//    @FindBy(css = "#address1")
//    private WebElement addressField;
//    @FindBy(xpath = "//input[@name='phoneNumber']")
//    private WebElement phoneNumberField;
//    @FindBy(xpath = "//select[@id='relationship_type']")
//    private WebElement relationshipType;
//    @FindBy(xpath = "//span[contains(text(),'Name:')]")
//    private WebElement displayedName;
//    @FindBy(xpath = "//span[contains(text(),'Gender:')]")
//    private WebElement displayedGender;
//    @FindBy(xpath = "//span[contains(text(),'Birthdate: ')]")
//    private WebElement displayedBirthday;
//    @FindBy(xpath = "//span[contains(text(),'Address: ')]")
//    private WebElement displayedAddress;
//    @FindBy(xpath = "//span[contains(text(),'Phone Number:')]")
//    private WebElement displayedPhoneNumber;
//    @FindBy(xpath = "//span[contains(text(),'Relatives: ')]")
//    private WebElement displayedRelatives;
//    @FindBy(css = "#submit")
//    private WebElement confirmButton;
//
//
//
//
//
//>>>>>>> Stashed changes
}
