package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.github.javafaker.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.samplepagetest.MassageSent;
import pages.samplepagetest.SamplePage;

public class SelectTest extends TestBase{
    Faker faker = new Faker();
    SamplePage samplePage;
    MassageSent massageSent;
    String firstName = faker.name().firstName();
    String emailName = faker.internet().emailAddress();
    String webSite = "https://skilldesk.starta.university/members/login";

    Lorem comment = faker.lorem();
    @Test
    public void selectTest() throws InterruptedException {
        samplePage = new SamplePage(driver);
        samplePage.selectValue("5-7");
        Thread.sleep(5000);
    }
    @Test
    public void fillingInformation() throws InterruptedException {
        samplePage = new SamplePage(driver);
        samplePage.fillDataGlobalSQA(firstName,emailName,webSite);
        samplePage.selectValue("1-3");
        samplePage.choiceValueData();
        samplePage.commentaryField(String.valueOf(comment));
        samplePage.clickAlertBoxButton();
        Assert.assertTrue(samplePage.getTextAlert().contains("Do you really fill rest of the form?"));
        samplePage.acceptAlert();
        Assert.assertTrue(samplePage.getTextAlert().contains("Good Luck. Go for it"));
        samplePage.acceptAlert();

        massageSent = new MassageSent(driver);
        Thread.sleep(5000);
        //String actualResult = massageSent.getTextFormName();
        Assert.assertTrue(massageSent.getTextFormName().contains("Name: " + firstName));

        //split раздеоение про побелу
    }
}
