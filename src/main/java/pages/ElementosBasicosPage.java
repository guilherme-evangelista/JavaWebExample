package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void acessarPaginaInicial() {
        acessarPagina(URL);
    }

    public void clicarBotaoSimples() {
        clickElement(btnCliqueAqui);
    }

    public void clicarBotaoDuplo() {
        doubleClickElement(btnDuploClique);
    }

    public void preencherTexto(String texto) {
        typeText(inputTexto, texto);
    }

    public void selecionarDropdown(String opcao) {
        clickElement(dropdown);
        clickElement(getOpcaoDropdownLocator(opcao));
    }

    public void alterarSlider(String valor) {
        setSliderValue(slider, valor);
    }

    public void clicarInterruptor() {
        clickElement(switchInterruptor);
    }

    public void validarQuantidadeCliquesSimples(String quantidade) {
        validateText(btnCliqueAqui, quantidade);
    }

    public void validarQuantidadeCliquesDuplo(String quantidade) {
        validateText(btnDuploClique, quantidade);
    }

    public void validarValorInput(String textoEsperado) {
        validateValue(inputTexto, textoEsperado);
    }

    public void validarOpcaoDropdown(String textoEsperado) {
        validateText(dropdown, textoEsperado);
    }

    public void validarValorSlider(String valorEsperado) {
        validateValue(slider, valorEsperado);
    }

    public void validarEstadoInterruptor(boolean estadoEsperado) {
        String estadoString = estadoEsperado ? "true" : "false";
        validateAttribute(switchInterruptor, "aria-checked", estadoString);
    }
}