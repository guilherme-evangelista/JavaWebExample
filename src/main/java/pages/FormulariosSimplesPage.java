package pages;

import factory.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.report.screenshot.ScenarioRepository.screenShot;

public class FormulariosSimplesPage extends BasePage {

    public FormulariosSimplesPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Formulários Simples')]")
    private WebElement btnFormulariosSimples;

    @FindBy(css = "input[data-testid='input-name']")
    private WebElement inputNome;

    @FindBy(css = "input[data-testid='input-email']")
    private WebElement inputEmail;

    @FindBy(css = "input[data-testid='input-password']")
    private WebElement inputSenha;

    @FindBy(css = "input[data-testid='input-confirm-password']")
    private WebElement inputConfirmarSenha;

    @FindBy(css = "input[data-testid='checkbox-terms']")
    private WebElement checkboxAceitoOsTermos;

    @FindBy(css = "button[data-testid='submit-button']")
    private WebElement btnEnviar;

    @FindBy(css = "button[data-testid='clear-button']")
    private WebElement btnLimpar;

    public static FormulariosSimplesPage actions() {
        return new FormulariosSimplesPage();
    }

    public FormulariosSimplesPage takeScreenShot() {
        screenShot();
        return this;
    }

    public FormulariosSimplesPage acessarAbaFormulariosSimples() {
        acessarPagina("https://playground-for-qa.vercel.app/playground"); 
        clickElement(btnFormulariosSimples);
        return this;
    }

    public FormulariosSimplesPage preencherCampoNome(String nome) {
        typeText(inputNome, nome);
        return this;
    }

    public FormulariosSimplesPage preencherCampoEmail(String email) {
        typeText(inputEmail, email);
        return this;
    }

    public FormulariosSimplesPage preencherCampoSenha(String senha) {
        typeText(inputSenha, senha);
        return this;
    }

    public FormulariosSimplesPage preencherCampoConfirmarSenha(String confirmarSenha) {
        typeText(inputConfirmarSenha, confirmarSenha);
        return this;
    }

    public FormulariosSimplesPage clicarCheckboxAceitoOsTermos() {
        clickElement(checkboxAceitoOsTermos);
        return this;
    }

    public FormulariosSimplesPage clicarBotaoEnviar() {
        clickElement(btnEnviar);
        return this;
    }

    public FormulariosSimplesPage clicarBotaoLimpar() {
        clickElement(btnLimpar);
        return this;
    }

    public FormulariosSimplesPage validarMensagemNaTela(String mensagem) {
        validateTextOnScreen(mensagem);
        return this;
    }

    public FormulariosSimplesPage validarCampoNomeVazio() {
        validateValue(inputNome, "");
        return this;
    }

    public FormulariosSimplesPage validarCampoEmailVazio() {
        validateValue(inputEmail, "");
        return this;
    }

    public FormulariosSimplesPage validarCampoSenhaVazio() {
        validateValue(inputSenha, "");
        return this;
    }

    public FormulariosSimplesPage validarCampoConfirmarSenhaVazio() {
        validateValue(inputConfirmarSenha, "");
        return this;
    }

    public FormulariosSimplesPage validarAceiteDeTermosDesmarcado() {
        validateElementIsNotChecked(checkboxAceitoOsTermos);
        return this;
    }
}