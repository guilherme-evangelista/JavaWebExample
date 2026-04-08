package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.FormulariosSimplesPage;

public class FormulariosSimplesSteps {

    FormulariosSimplesPage page = new FormulariosSimplesPage();

    @Dado("que estou na aba de Formulários Simples")
    public void que_estou_na_aba_de_formularios_simples() {
        page.acessarAbaFormulariosSimples();
    }

    @Quando("preencho o formulário com dados válidos e aceito os termos")
    public void preencho_o_formulario_com_dados_validos_e_aceito_os_termos() {
        page.preencherCampoNome("John Doe");
        page.preencherCampoEmail("johndoe@example.com");
        page.preencherCampoSenha("Password123");
        page.preencherCampoConfirmarSenha("Password123");
        page.clicarCheckboxAceitoOsTermos();
    }

    @Quando("preencho todos os campos de texto corretamente")
    public void preencho_todos_os_campos_de_texto_corretamente() {
        page.preencherCampoNome("John Doe");
        page.preencherCampoEmail("johndoe@example.com");
        page.preencherCampoSenha("Password123");
        page.preencherCampoConfirmarSenha("Password123");
    }

    @E("clico no botão Enviar sem aceitar os termos")
    public void clico_no_botao_enviar_sem_aceitar_os_termos() {
        page.clicarBotaoEnviar();
    }

    @E("clico no botão Limpar")
    public void clico_no_botao_limpar() {
        page.clicarBotaoLimpar();
    }

    @E("clico no botão Enviar")
    public void clico_no_botao_enviar() {
        page.clicarBotaoEnviar();
    }

    @Quando("preencho o formulário exceto o campo {string}")
    public void preencho_o_formulario_exceto_o_campo(String campo) {
        if (!campo.equals("Nome")) {
            page.preencherCampoNome("John Doe");
        }
        if (!campo.equals("Email")) {
            page.preencherCampoEmail("johndoe@example.com");
        }
        if (!campo.equals("Senha")) {
            page.preencherCampoSenha("Password123");
        }
        if (!campo.equals("Confirmar Senha")) {
            page.preencherCampoConfirmarSenha("Password123");
        }
    }

    @Quando("preencho a senha {string} e a confirmação {string}")
    public void preencho_a_senha_e_a_confirmacao(String senha, String confirmarSenha) {
        page.preencherCampoSenha(senha);
        page.preencherCampoConfirmarSenha(confirmarSenha);
    }

    @Então("visualizo a mensagem {string}")
    public void visualizo_a_mensagem(String mensagem) {
        page.validarMensagemNaTela(mensagem);
    }

    @Então("verifico que todos os campos do formulário foram resetados")
    public void verifico_que_todos_os_campos_do_formulario_foram_resetados() {
        page.validarCampoNomeVazio();
        page.validarCampoEmailVazio();
        page.validarCampoSenhaVazio();
        page.validarCampoConfirmarSenhaVazio();
        page.validarAceiteDeTermosDesmarcado();
    }
}