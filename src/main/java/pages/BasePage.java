package pages;

import factory.DriverFactory;
import org.openqa.selenium.*;
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
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class);
    }

    WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void acessarPagina(String url) {
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            element.click();
            return true;
        });
    }

    public void clickElement(By locator) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            getDriver().findElement(locator).click();
            return true;
        });
    }

    public void doubleClickElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            js.executeScript("var evt = new MouseEvent('dblclick', {bubbles: true, cancelable: true, view: window}); arguments[0].dispatchEvent(evt);", element);
            return true;
        });
    }

    public void typeText(WebElement element, String text) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            element.clear();
            element.sendKeys(text);
            return true;
        });
    }

    public void pressKey(WebElement element, Keys key) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            element.sendKeys(key);
            return true;
        });
    }

    public void selectOptionByVisibleText(WebElement element, String optionText) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(optionText);
            return true;
        });
    }

    public void checkElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            if (!element.isSelected()) {
                element.click();
            }
            return true;
        });
    }

    public void uncheckElement(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            if (element.isSelected()) {
                element.click();
            }
            return true;
        });
    }

    public void setSliderValue(WebElement element, String value) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            
            js.executeScript(
                "var input = arguments[0];" +
                "var val = arguments[1];" +
                "input.focus();" + 
                "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                "if (nativeInputValueSetter) {" +
                "    nativeInputValueSetter.call(input, val);" +
                "}" +
                "input.value = val;" +
                "input.dispatchEvent(new Event('input', { bubbles: true }));" +
                "input.dispatchEvent(new Event('change', { bubbles: true }));", 
                element, value);
            return true;
        });
    }

    public void acceptAlertOrConfirm() {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void cancelConfirm() {
        getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public void typeInPromptAndAccept(String textToType) {
        Alert alert = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(textToType);
        alert.accept();
    }

    public void validateAlertText(String expectedText) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Alert alert = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.alertIsPresent());
            Assert.assertTrue(alert.getText().contains(expectedText), "Texto do alerta diferente do esperado.");
            return true;
        });
    }

    public void validateUrl(String expectedUrl) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl, "URL atual é diferente da esperada.");
            return true;
        });
    }

    public void validateText(WebElement element, String expectedText) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Assert.assertTrue(element.getText().contains(expectedText), "Elemento não contém o texto: " + expectedText);
            return true;
        });
    }

    public void validateValue(WebElement element, String expectedValue) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Assert.assertEquals(element.getDomProperty("value"), expectedValue, "Valor do elemento incorreto.");
            return true;
        });
    }

    public void validateAttribute(WebElement element, String attribute, String expectedValue) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Assert.assertEquals(element.getAttribute(attribute), expectedValue, "Atributo " + attribute + " incorreto.");
            return true;
        });
    }

    public void validateElementIsVisible(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Assert.assertTrue(element.isDisplayed(), "Elemento deveria estar visível.");
            return true;
        });
    }

    public void validateElementDoesNotExist(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            try {
                Assert.assertFalse(element.isDisplayed(), "Elemento não deveria estar visível.");
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return true;
            }
            return true;
        });
    }

    public void validateElementIsChecked(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Assert.assertTrue(element.isSelected(), "Elemento deveria estar marcado (checked).");
            return true;
        });
    }

    public void validateQuantityOfElements(WebElement element, int expectedQuantity) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            List<WebElement> elements = getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(element));
            Assert.assertEquals(elements.size(), expectedQuantity, "Quantidade de elementos incorreta.");
            return true;
        });
    }

    public void validateTextOnScreen(String expectedText) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            WebElement element = getDriver().findElement(By.xpath("//*[contains(text(), '" + expectedText + "')]"));
            Assert.assertTrue(element.isDisplayed(), "O texto '" + expectedText + "' não está visível na tela.");
            return true;
        });
    }

    public void validateElementIsNotChecked(WebElement element) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            Assert.assertFalse(element.isSelected(), "O elemento deveria estar desmarcado (unchecked).");
            return true;
        });
    }

    public void validateTextsInElementsAreSortedByAscendingOrder(List<WebElement> elements) {
        getWait(DEFAULT_TIMEOUT).until(d -> {
            List<String> actualTexts = new ArrayList<>();
            for (WebElement el : elements) {
                actualTexts.add(el.getText().trim());
            }

            List<String> expectedSortedTexts = new ArrayList<>(actualTexts);
            Collections.sort(expectedSortedTexts);

            Assert.assertEquals(actualTexts, expectedSortedTexts, "Os elementos não estão ordenados de forma ascendente.");
            return true;
        });
    }
}