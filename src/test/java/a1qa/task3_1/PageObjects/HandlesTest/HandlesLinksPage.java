package a1qa.task3_1.PageObjects.HandlesTest;

import a1qa.task3_1.PageObjects.BaseForm;
import a1qa.task3_1.Utilities.Elements.BaseElement;
import a1qa.task3_1.Utilities.Logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandlesLinksPage extends BaseForm {

    private static final LoggerUtil logger = new LoggerUtil(HandlesLinksPage.class);
    private static final By linksWindowsHeader = By.xpath("//div[contains(text(),'Links')]");
    private static final By dropDownElements = By.xpath("//div[normalize-space()='Elements']//span");
    private static final By linksMenu = By.xpath("//span[normalize-space()='Links']");

    public HandlesLinksPage(WebDriver driver) {
        super(driver);
    }

    public static void clickElementsDropDown(){
        try {
            logger.debug("Clicking 'Elements' drop Down");
            BaseElement.click(dropDownElements);
        }catch (Exception e){
            logger.error("Failed to click 'Elements' drop Down; " + e.getMessage());
        }
    }

    public static void clickLinksMenu(){
        try {
            logger.debug("Clicking 'Links' menu");
            BaseElement.click(linksMenu);
        }catch (Exception e){
            logger.error("Failed to click 'Links' menu; " + e.getMessage());
        }
    }

    public static boolean linksWindowOpen(){
        try{
            logger.info("Links window opened correctly");
            return BaseElement.isDisplayed(linksWindowsHeader);
        }catch (Exception e){
            logger.error("Failed to open 'Links Window Page'; " + e.getMessage());
            return false;
        }
    }

}
