package com.testUI.openmrs.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class RegisterPatientPage {
    public RegisterPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#checkbox-unknown-patient")
    private WebElement unidentifiedPatientCheckBox;
    @FindBy(xpath = "//input[@name='givenName']")
    private WebElement newPatientGivenName;
    @FindBy(xpath = "//input[@name='familyName']")
    private WebElement newPatientFamilyName;

    @FindBy(css = "#next-button")
    private WebElement nextButton;
    @FindBy(xpath = "//select[@id='gender-field']")
    private WebElement patientGender;

    @FindBy(css = "#submit")
    private WebElement confirmButton;
    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//select[@id='birthdateMonth-field']")
    private WebElement monthOfBirth;
    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    private WebElement yearOfBirth;
    @FindBy(css = "#address1")
    private WebElement addressField;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//select[@id='relationship_type']")
    private WebElement relationshipType;
    @FindBy(xpath = "//input[@placeholder='Person Name']")
    private WebElement relativeName;
    @FindBy(xpath = "//span[contains(text(),'Name:')]")
    private WebElement displayedName;
    @FindBy(xpath = "//span[contains(text(),'Gender:')]")
    private WebElement displayedGender;
    @FindBy(xpath = "//span[contains(text(),'Birthdate: ')]")
    private WebElement displayedBirthday;
    @FindBy(xpath = "//span[contains(text(),'Address: ')]")
    private WebElement displayedAddress;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//span[contains(text(),'Relatives: ')]")
    private WebElement displayedRelatives;

    @FindBy(css = "#address1")
    private WebElement address;

    @FindBy(xpath = "//select[@id='relationship_type']")
    private WebElement relationshipSelect;

    @FindBy(xpath = "//form[@id='registration']")
    private WebElement iframe;

    public void enterFullNamePatient(String firstName, String lastName) {
        newPatientGivenName.sendKeys(firstName);
        newPatientFamilyName.sendKeys(lastName);
    }

    public void clickUnidentifiedPatient() {
        unidentifiedPatientCheckBox.click();
    }

    public void chooseGender(String patientGender) {
        Select select = new Select(this.patientGender);
        select.selectByVisibleText(patientGender);

    }

    public void enterDateOfBirth(String day, String month, String year) {
        dateOfBirth.sendKeys(day);
        Select select = new Select(monthOfBirth);
        select.selectByVisibleText(month);
        yearOfBirth.sendKeys(year);
    }

    public void verificationOfEnteredInfo(String fullName, String gender, String birthday, String address, String phoneNumber, String relatives) {
        Assert.assertEquals(fullName, BrowserUtils.getText(displayedName));
        Assert.assertEquals(gender, BrowserUtils.getText(displayedGender));
        Assert.assertEquals(birthday, BrowserUtils.getText(displayedBirthday));
        Assert.assertEquals(address, BrowserUtils.getText(displayedAddress));
        Assert.assertEquals(phoneNumber, BrowserUtils.getText(this.phoneNumber));
        Assert.assertEquals(relatives, BrowserUtils.getText(displayedRelatives));
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void clickConfirmButton() throws InterruptedException {
        confirmButton.click();
        Thread.sleep(3000);
    }

    public void addressInput(String address) {
        this.address.sendKeys(address);
        nextButton.click();
    }

    public void phoneNumberInput(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
        nextButton.click();
    }

    public void selectRelationship(WebDriver driver, String selectRelationshipType, String name) throws InterruptedException {
//        driver.switchTo().frame(iframe);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        WebElement text = wait.until(ExpectedConditions.visibilityOf(relationshipSelect));
//        BrowserUtils.selectBy(text, selectRelationshipType, "text");
//        nextButton.click();
    }

}
