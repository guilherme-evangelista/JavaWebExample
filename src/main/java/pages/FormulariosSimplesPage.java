package pages;

import factory.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void acessarAbaFormulariosSimples() {
        acessarPagina("https://playground-for-qa.vercel.app/playground"); 
        clickElement(btnFormulariosSimples);
    }

    public void preencherCampoNome(String nome) {
        typeText(inputNome, nome);
    }

    public void preencherCampoEmail(String email) {
        typeText(inputEmail, email);
    }

    public void preencherCampoSenha(String senha) {
        typeText(inputSenha, senha);
    }

    public void preencherCampoConfirmarSenha(String confirmarSenha) {
        typeText(inputConfirmarSenha, confirmarSenha);
    }

    public void clicarCheckboxAceitoOsTermos() {
        clickElement(checkboxAceitoOsTermos);
    }

    public void clicarBotaoEnviar() {
        clickElement(btnEnviar);
    }

    public void clicarBotaoLimpar() {
        clickElement(btnLimpar);
    }

    public void validarMensagemNaTela(String mensagem) {
        validateTextOnScreen(mensagem);
    }

    public void validarCampoNomeVazio() {
        validateValue(inputNome, "");
    }

    public void validarCampoEmailVazio() {
        validateValue(inputEmail, "");
    }

    public void validarCampoSenhaVazio() {
        validateValue(inputSenha, "");
    }

    public void validarCampoConfirmarSenhaVazio() {
        validateValue(inputConfirmarSenha, "");
    }

    public void validarAceiteDeTermosDesmarcado() {
        validateElementIsNotChecked(checkboxAceitoOsTermos);
    }
}