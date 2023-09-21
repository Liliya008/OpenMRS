package com.testUI.openmrs.pages;

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

    @FindBy(xpath = "//tr//td")
   private List<WebElement> tableData;


    public void validateDeletePatientRecord(){
        for (WebElement patientInfo : tableData){
            if (!BrowserUtils.getText(patientInfo).equalsIgnoreCase("John Smith")){
                System.out.println("patient is deleted");
            }
        }
    }
}
