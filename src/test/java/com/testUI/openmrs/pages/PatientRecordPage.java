package com.testUI.openmrs.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class PatientRecordPage {
        public PatientRecordPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
        @FindBy(css = ".form-control")
        private WebElement searchBar;
        @FindBy(css = ".dataTables_info")
        private WebElement patientAmount;
        @FindBy(css = ".dataTables_empty")
        private WebElement notificationMessage;
        public void nameInput(String name) {
            searchBar.sendKeys(name);
        }
        public void amountValidation(WebDriver driver,String amount) {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement text =wait.until(ExpectedConditions.visibilityOf(patientAmount));
            BrowserUtils.scrollWithJS(driver,patientAmount);
            Assert.assertTrue(BrowserUtils.getText(patientAmount).contains(amount));
        }
        public void messageValidation(WebDriver driver,String massage){
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement text =wait.until(ExpectedConditions.visibilityOf(notificationMessage));
            Assert.assertEquals(massage,BrowserUtils.getText(notificationMessage));
        }
    }

