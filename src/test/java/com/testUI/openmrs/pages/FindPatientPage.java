package com.testUI.openmrs.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class FindPatientPage {
    public FindPatientPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input")
    private WebElement searchBar;
    @FindBy(xpath = "//tr//td")
   private List<WebElement> tableData;
    @FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
    private WebElement deletePatientButton;
    @FindBy(css = "#delete-reason")
    private WebElement deleteReasonBox;
    @FindBy(xpath = "//div[contains(@id,'delete-patient')]//button[.='Confirm']")
    private WebElement deleteConfirmButton;


    public void searchPatient(String patientName){
        searchBar.sendKeys(patientName);

    }
    public void selectPatient(String patientName) throws InterruptedException {
        Thread.sleep(2000);
    for (WebElement patient : tableData){
        if (BrowserUtils.getText(patient).equalsIgnoreCase(patientName)){
            patient.click();
            break;
        }
    }
    }

    public void clickDeletePatientButton(){
        deletePatientButton.click();
    }
    public void deleteReason(String reason){
        deleteReasonBox.sendKeys(reason);
    }
    public void clickDeleteConfirmButton(){
        deleteConfirmButton.click();
    }
    public void validateDeletePatientRecord(String patientName){
        for (WebElement patientInfo : tableData)
                Assert.assertFalse(BrowserUtils.getText(patientInfo).equalsIgnoreCase(patientName));
            }
        }



