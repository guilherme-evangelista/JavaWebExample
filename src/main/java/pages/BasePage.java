package pages;

import factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePage {

    private static final int DEFAULT_TIMEOUT = 8;

    private FluentWait<WebDriver> getWait(int timeoutInSeconds) {
        return new FluentWait<>(DriverFactory.getDriver())
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void acessarPagina(String url) {
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);
    }

    public void clickElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickElement(By locator) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
        getDriver().findElement(locator).click();
    }

    public void doubleClickElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        new Actions(getDriver()).doubleClick(element).perform();
    }

    public void typeText(WebElement element, String text) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void pressKey(WebElement element, Keys key) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(key);
    }

    public void selectOptionByVisibleText(WebElement element, String optionText) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(optionText);
    }

    public void checkElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        if (element.isSelected()) {
            element.click();
        }
    }

    public void setSliderValue(WebElement element, String value) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));", element, value);
    }

    public void acceptAlertOrConfirm() {
        Alert alert = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void cancelConfirm() {
        Alert alert = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    public void typeInPromptAndAccept(String textToType) {
        Alert alert = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(textToType);
        alert.accept();
    }

    public void validateAlertText(String expectedText) {
        Alert alert = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(expectedText), "Texto do alerta diferente do esperado.");
    }

    public void validateUrl(String expectedUrl) {
        boolean isUrlCorrect = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertTrue(isUrlCorrect, "URL atual é diferente da esperada.");
    }

    public void validateText(WebElement element, String expectedText) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().contains(expectedText), "Elemento não contém o texto: " + expectedText);
    }

    public void validateValue(WebElement element, String expectedValue) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getAttribute("value"), expectedValue, "Valor do elemento incorreto.");
    }

    public void validateAttribute(WebElement element, String attribute, String expectedValue) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getAttribute(attribute), expectedValue, "Atributo " + attribute + " incorreto.");
    }

    public void validateElementIsVisible(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed(), "Elemento deveria estar visível.");
    }

    public void validateElementDoesNotExist(WebElement element) {
        boolean isInvisibleOrNotPresent = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOf(element));
        Assert.assertTrue(isInvisibleOrNotPresent, "Elemento não deveria existir/estar visível.");
    }

    public void validateElementIsChecked(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isSelected(), "Elemento deveria estar marcado (checked).");
    }

    public void validateQuantityOfElements(WebElement element, int expectedQuantity) {
        List<WebElement> elements = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(element));
        Assert.assertEquals(elements.size(), expectedQuantity, "Quantidade de elementos incorreta.");
    }

    public void validateTextsInElementsAreSortedByAscendingOrder(List<WebElement> elements) {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(elements));

        List<String> actualTexts = new ArrayList<>();
        for (WebElement el : elements) {
            actualTexts.add(el.getText().trim());
        }

        List<String> expectedSortedTexts = new ArrayList<>(actualTexts);
        Collections.sort(expectedSortedTexts);

        Assert.assertEquals(actualTexts, expectedSortedTexts, "Os elementos não estão ordenados de forma ascendente.");
    }
}