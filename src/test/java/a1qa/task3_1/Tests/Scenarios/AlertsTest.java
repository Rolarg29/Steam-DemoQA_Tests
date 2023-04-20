package a1qa.task3_1.Tests.Scenarios;


import a1qa.task3_1.PageObjects.AlertsPage;
import a1qa.task3_1.PageObjects.AlertsWindowsPage;
import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.PageObjects.MainPage;
import a1qa.task3_1.Tests.BaseTest;
import a1qa.task3_1.Utilities.BaseElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void alertsTest(){
        //step 1
        BaseElement.visit(BaseForm.mainUrl);
        Assert.assertTrue(MainPage.toolsQaLogoDisplayed(), "The element from Main Page is NOT displayed");

        //step 2
        MainPage.clickAFWButton();
        AlertsWindowsPage.clickAlertsButton();
        Assert.assertTrue(AlertsPage.alertsFormsDisplayed(), "The Alerts forms are NOT displayed");

        //step 3
        AlertsPage.clickAlertButton(AlertsPage.alertButton);
        Assert.assertEquals(AlertsPage.getAlertText(), "You clicked a button");

        //step 4
        AlertsPage.clickOk();
        Assert.assertTrue(AlertsPage.alertClosed(), "Page not enabled");

        //step 5
        AlertsPage.clickAlertButton(AlertsPage.alertConfirmButton);
        Assert.assertEquals(AlertsPage.getAlertText(), "Do you confirm action?");

        //step 6
        AlertsPage.clickOk();
        Assert.assertTrue(AlertsPage.alertClosed(), "Page not enabled");
        Assert.assertEquals(AlertsPage.getResultText(AlertsPage.alertConfirmResult), "You selected Ok");

        //step 7
        AlertsPage.clickAlertButton(AlertsPage.alertPromptButton);
        Assert.assertEquals(AlertsPage.getAlertText(), "Please enter your name");

        //step 8
        String randomText= AlertsPage.alertRandomText();
        AlertsPage.clickOk();
        Assert.assertEquals(AlertsPage.getResultText(AlertsPage.alertPromptResult), "You entered " + randomText);










    }

}