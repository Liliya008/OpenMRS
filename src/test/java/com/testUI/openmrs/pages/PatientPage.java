package com.testUI.openmrs.pages;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;


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
    @FindBy(xpath = "//div[@class='float-sm-right']//span")
    private List<WebElement> allId;
    @FindBy(xpath = "//div[@class='col-11 col-lg-10']")
    private  List<WebElement> generalActionList;

    @FindBy(xpath = "//div[@id='simplemodal-container']//button[@class='confirm right']")
    private WebElement confirmButton;

    @FindBy(xpath = "//span[@class='d-none d-sm-none d-md-inline d-lg-inline']")
    private WebElement actions;

    @FindBy(xpath = "//a[@href]//i[@class='icon-plus']")
    private WebElement addPartVisit;
    @FindBy(xpath = "//div[@id='retrospective-visit-creation-dialog']//button[@class='confirm right']")
    private WebElement addPastVisitConfirmButton;

    @FindBy(xpath = "//div[@class='datetimepicker-days']//tr[1]//th[2][@class='switch']")
    private WebElement yearAndMonth;

    @FindBy(xpath = "//div[@class='datetimepicker-months']//th[2]")
    private WebElement clickChooseYear;

    @FindBy(xpath = "//td[@class='day']")
    private List<WebElement> chooseStartVisitDays;

    @FindBy(xpath = "//div[@class='datetimepicker-years']//span[@class]")
    private List<WebElement> chooseStartVisitYear;

    @FindBy(xpath = "//td//span[@class='month']")
    private List<WebElement> chooseStartVisitMonth;
    @FindBy(xpath = "//li[@class='menu-item viewVisitDetails selected']//span[1]//span[1]")
    private List<WebElement> allAddStartDate;

    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    private WebElement clickPatientName;

    @FindBy(xpath = "//ul[@class='float-left d-none d-lg-block']//div[@class='row']")
    private List<WebElement> endVisit;

    @FindBy(xpath = "//div[@id='end-visit-dialog']//button[1]")
    private WebElement yesButton;

    public String validateFirstName(){
        return BrowserUtils.getText(patientFirstName);
    }

    public String validateLastName(){
        return BrowserUtils.getText(patientLastName);
    }

    public void validateId(String ids){
        for (WebElement id : allId){
            if(id.getText().equals(ids)){
                Assert.assertEquals(ids,BrowserUtils.getText(id));
                break;
            }
        }
    }
    public void clickStartVisit(String startVisit,WebDriver driver)  {
       for(WebElement startVisitButton : generalActionList){
           if(startVisitButton.getText().contains(startVisit)){
               startVisitButton.click();
               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               wait.until(ExpectedConditions.visibilityOf(startVisitButton));
               break;
           }

       }
        confirmButton.click();


    }


    public void hoverOverActionsList(WebDriver driver){
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(actions).build().perform();

    }

    public void clickAddPartVisit() throws InterruptedException {

        addPartVisit.click();
        Thread.sleep(2000);

    }

    public void clickTimeStampTable(String years ,String months ,String days) throws InterruptedException {
        yearAndMonth.click();
        clickChooseYear.click();
        Thread.sleep(2000);

        for (WebElement chooseYear : chooseStartVisitYear){
            if(chooseYear.getText().contains(years)){
                System.out.println(BrowserUtils.getText(chooseYear));
                chooseYear.click();
                break;
            }
        }

        for(WebElement chooseMonth : chooseStartVisitMonth){
            if(chooseMonth.getText().contains(months)){
                System.out.println(BrowserUtils.getText(chooseMonth));
                chooseMonth.click();
                break;
            }
        }

         for(WebElement chooseDay : chooseStartVisitDays){
             if(chooseDay.getText().contains(days)){
                 System.out.println(BrowserUtils.getText(chooseDay));
                 chooseDay.click();
                 break;
             }
         }

         confirmButton.click();
         Thread.sleep(2000);

    }


    public void validateStartDate(WebDriver driver,String startDate){
        Actions actions1 = new Actions(driver);
        actions1.scrollByAmount(300,400);
        for(WebElement date: allAddStartDate){
            if(date.getText().contains(startDate)){
                System.out.println(BrowserUtils.getText(date));
                Assert.assertEquals(startDate,BrowserUtils.getText(date));
                break;
            }
        }
        clickPatientName.click();
    }

    public void clickEndVisit(String endVisitButton){
        for(WebElement endVisitBut :endVisit ){
            if(endVisitBut.getText().contains(endVisitButton)){
                endVisitBut.click();
                break;
            }
        }
        yesButton.click();

    }
}
