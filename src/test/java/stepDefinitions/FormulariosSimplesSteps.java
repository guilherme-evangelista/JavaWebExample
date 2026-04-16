package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.FormulariosSimplesPage;
import utils.DataFaker;

public class FormulariosSimplesSteps {

    @Given("que estou na aba de Formulários Simples")
    public void que_estou_na_aba_de_formularios_simples() {
        FormulariosSimplesPage.actions()
            .acessarAbaFormulariosSimples()
            .takeScreenShot();
    }

    @When("preencho o formulário com dados válidos e aceito os termos")
    public void preencho_o_formulario_com_dados_validos_e_aceito_os_termos() {
        String nome = DataFaker.getNome();
        String email = DataFaker.getEmail();
        String senha = DataFaker.getSenha();

        FormulariosSimplesPage.actions().preencherCampoNome(nome)
            .preencherCampoEmail(email)
            .preencherCampoSenha(senha)
            .preencherCampoConfirmarSenha(senha)
            .clicarCheckboxAceitoOsTermos()
            .takeScreenShot();
    }

    @When("preencho todos os campos de texto corretamente")
    public void preencho_todos_os_campos_de_texto_corretamente() {
        String nome = DataFaker.getNome();
        String email = DataFaker.getEmail();
        String senha = DataFaker.getSenha();

        FormulariosSimplesPage.actions().preencherCampoNome(nome)
            .preencherCampoEmail(email)
            .preencherCampoSenha(senha)
            .preencherCampoConfirmarSenha(senha)
            .takeScreenShot();
    }

    @And("clico no botão Enviar sem aceitar os termos")
    public void clico_no_botao_enviar_sem_aceitar_os_termos() {
        FormulariosSimplesPage.actions()
            .clicarBotaoEnviar()
            .takeScreenShot();
    }

    @And("clico no botão Limpar")
    public void clico_no_botao_limpar() {
        FormulariosSimplesPage.actions()
            .clicarBotaoLimpar()
            .takeScreenShot();
    }

    @And("clico no botão Enviar")
    public void clico_no_botao_enviar() {
        FormulariosSimplesPage.actions()
            .clicarBotaoEnviar()
            .takeScreenShot();
    }

    @When("preencho o formulário exceto o campo {string}")
    public void preencho_o_formulario_exceto_o_campo(String campo) {
        String nome = DataFaker.getNome();
        String email = DataFaker.getEmail();
        String senha = DataFaker.getSenha();

        if (!campo.equals("Nome")) {
            FormulariosSimplesPage.actions()
                .preencherCampoNome(nome)
                .takeScreenShot();
        }
        if (!campo.equals("Email")) {
            FormulariosSimplesPage.actions()
                .preencherCampoEmail(email)
                .takeScreenShot();
        }
        if (!campo.equals("Senha")) {
            FormulariosSimplesPage.actions()
                .preencherCampoSenha(senha)
                .takeScreenShot();
        }
        if (!campo.equals("Confirmar Senha")) {
            FormulariosSimplesPage.actions()
                .preencherCampoConfirmarSenha(senha)
                .takeScreenShot();
        }
    }

    @When("preencho a senha {string} e a confirmação {string}")
    public void preencho_a_senha_e_a_confirmacao(String senha, String confirmarSenha) {
        FormulariosSimplesPage.actions()
            .preencherCampoSenha(senha)
            .preencherCampoConfirmarSenha(confirmarSenha)
            .takeScreenShot();
    }

    @Then("visualizo a mensagem {string}")
    public void visualizo_a_mensagem(String mensagem) {
        FormulariosSimplesPage.actions()
            .takeScreenShot()
            .validarMensagemNaTela(mensagem);
    }

    @Then("verifico que todos os campos do formulário foram resetados")
    public void verifico_que_todos_os_campos_do_formulario_foram_resetados() {
        FormulariosSimplesPage.actions()
            .takeScreenShot()
            .validarCampoNomeVazio()
            .validarCampoEmailVazio()
            .validarCampoSenhaVazio()
            .validarCampoConfirmarSenhaVazio()
            .validarAceiteDeTermosDesmarcado();
    }
}