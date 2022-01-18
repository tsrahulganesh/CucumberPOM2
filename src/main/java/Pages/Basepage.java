package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static Stepdef.sharedsd.getDriver;
import static java.time.Duration.ofSeconds;


public class Basepage {

        public WebElement webAction(By locator) {

            Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(ofSeconds(50)) // max time
                    .pollingEvery(ofSeconds(5)) // every 5 seconds
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(ElementClickInterceptedException.class)
                    .ignoring(ElementNotInteractableException.class)
                    .ignoring(ArithmeticException.class)
                    .withMessage(
                            "Webdriver waited for 50 seconds but still " +
                                    "could not find the element therefore " +
                                    "Timeout Exception has been thrown");

            WebElement element = wait.until(new Function<WebDriver, WebElement>() {

                public WebElement apply(WebDriver driver)
                {
                    return driver.findElement(locator);
                }

            });

            return element;
        }


    public static ArrayList<String> getElementTextList(By locator)
    {
        List<WebElement> elements = getDriver().findElements(locator);

        ArrayList<String> txtList = new ArrayList<>();

        for(int i=0;i<elements.size();i++)
            txtList.add(elements.get(i).getText());

        return txtList;

    }
    public void clickOn(By locator) {

        // driver.findElement(By.xpath("")).click();

        //   webAction(locator) -->  driver.findElement(locator).click();

        //getDriver().findElement(locator).click();
        //driver.findElement(locator).click();
        webAction(locator).click();

        //SharedSD.getDriver().findElement(locator).click();
    }


    public void setValue(By locator, String value) {
        webAction(locator).sendKeys(value);
    }

    public String getTextFromElement(By locator) {

        return webAction(locator).getText();
    }

    public void selectFromDropdown(By locator, String dropdownText) {

        WebElement wb = webAction(locator);
        Select select = new Select(wb);
        //select element by visible text
        select.selectByVisibleText(dropdownText);
    }

    public void selectFromDropdown(By locator, int index) {
        WebElement wb = webAction(locator);
        Select select = new Select(wb);
        //select element by index
        select.selectByIndex(index);
    }
}
