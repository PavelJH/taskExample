package pages.samplepagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamplePage {
    WebDriver driver;
    public SamplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//select[@name='g2599-experienceinyears']")
    WebElement selectInput;
    @FindBy(xpath = "//input[@id='g2599-name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@id='g2599-email']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@id='g2599-name']")
    WebElement searchResult;

    @FindBy(xpath = "//input[@id='g2599-website']")
    WebElement webSite;

    @FindBy(xpath = "//input[@value='Automation Testing']")
    WebElement autoTestingChoice;

    @FindBy(xpath = "//input[@value='Other']")
    WebElement autoEducation;

    @FindBy(xpath = "//textarea[@id='contact-form-comment-g2599-comment']")
    WebElement commentary;
    @FindBy(xpath = "//button[normalize-space()='Alert Box : Click Here']")
    WebElement alertBoxButton;







    public void fillDataGlobalSQA(String firstName, String emailField, String webField){
        nameInput.clear();
        nameInput.sendKeys(firstName);
        emailInput.clear();
        emailInput.sendKeys(emailField);
        webSite.clear();
        webSite.sendKeys(webField);
    }

    public void selectValue(String value) {
        Select select = new Select(driver.findElement(By.name("g2599-experienceinyears")));
        select.selectByVisibleText(value);
    }
    public void choiceValueData(){
        autoTestingChoice.click();
        autoEducation.click();
    }
    public void commentaryField(String comment) {
        commentary.clear();
        commentary.sendKeys(comment);
    }
    public void clickAlertBoxButton() {
        alertBoxButton.click();
    }
    public String getTextAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }




}
