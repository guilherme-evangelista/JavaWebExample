package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.report.screenshot.ScenarioRepository.screenShot;

public class ElementosBasicosPage extends BasePage {

    public static final String URL = "https://playground-for-qa.vercel.app/playground";

    public ElementosBasicosPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Clique aqui')]")
    private WebElement btnCliqueAqui;

    @FindBy(xpath = "//button[contains(text(), 'Duplo clique')]")
    private WebElement btnDuploClique;

    @FindBy(css = "input[placeholder='Digite algo...']")
    private WebElement inputTexto;

    @FindBy(css = "[data-testid='section-elementos-basicos'] [data-testid='select-input']")
    private WebElement dropdown;

    @FindBy(css = "input[data-testid='range-input']")
    private WebElement slider;

    @FindBy(css = "button[data-testid='toggle-switch']")
    private WebElement switchInterruptor;

    private By getOpcaoDropdownLocator(String nomeFramework) {
        return By.cssSelector("button[data-testid='select-option-" + nomeFramework + "']");
    }

    public static ElementosBasicosPage actions(){
        return new ElementosBasicosPage();
    }

    public ElementosBasicosPage takeScreenShot() {
        screenShot();
        return this;
    }

    public ElementosBasicosPage acessarPaginaInicial() {
        acessarPagina(URL);
        return this;
    }

    public ElementosBasicosPage clicarBotaoSimples() {
        clickElement(btnCliqueAqui);
        return this;
    }

    public ElementosBasicosPage clicarBotaoDuplo() {
        doubleClickElement(btnDuploClique);
        return this;
    }

    public ElementosBasicosPage preencherTexto(String texto) {
        typeText(inputTexto, texto);
        return this;
    }

    public ElementosBasicosPage selecionarDropdown(String opcao) {
        clickElement(dropdown);
        clickElement(getOpcaoDropdownLocator(opcao));
        return this;
    }

    public ElementosBasicosPage alterarSlider(String valor) {
        setSliderValue(slider, valor);
        return this;
    }

    public ElementosBasicosPage clicarInterruptor() {
        clickElement(switchInterruptor);
        return this;
    }

    public ElementosBasicosPage validarQuantidadeCliquesSimples(String quantidade) {
        validateText(btnCliqueAqui, quantidade);
        return this;
    }

    public ElementosBasicosPage validarQuantidadeCliquesDuplo(String quantidade) {
        validateText(btnDuploClique, quantidade);
        return this;
    }

    public ElementosBasicosPage validarValorInput(String textoEsperado) {
        validateValue(inputTexto, textoEsperado);
        return this;
    }

    public ElementosBasicosPage validarOpcaoDropdown(String textoEsperado) {
        validateText(dropdown, textoEsperado);
        return this;
    }

    public ElementosBasicosPage validarValorSlider(String valorEsperado) {
        validateValue(slider, valorEsperado);
        return this;
    }

    public ElementosBasicosPage validarEstadoInterruptor(boolean estadoEsperado) {
        String estadoString = estadoEsperado ? "true" : "false";
        validateAttribute(switchInterruptor, "aria-checked", estadoString);
        return this;
    }
}