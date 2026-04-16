package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.ElementosBasicosPage;

public class ElementosBasicosSteps {

    @Given("que estou na tela inicial QA Playground")
    public void que_estou_na_tela_inicial_qa_playground() {
        ElementosBasicosPage.actions()
            .acessarPaginaInicial()
            .takeScreenShot();
    }

    @When("clico no botão clique aqui")
    public void clico_no_botao_clique_aqui() {
        ElementosBasicosPage.actions()
            .clicarBotaoSimples()
            .takeScreenShot();
    }

    @When("clico no botão duplo clique")
    public void clico_no_botao_duplo_clique() {
        ElementosBasicosPage.actions()
            .clicarBotaoDuplo()
            .takeScreenShot();
    }

    @When("escrevo no campo de texto {string}")
    public void escrevo_no_campo_de_texto(String texto) {
        ElementosBasicosPage.actions()
            .preencherTexto(texto)
            .takeScreenShot();
    }

    @When("seleciono a opcao no dropdown de framework {string}")
    public void seleciono_a_opcao_no_dropdown_de_framework(String framework) {
        ElementosBasicosPage.actions()
            .selecionarDropdown(framework)
            .takeScreenShot();
    }

    @When("altero o valor do slider para {string}")
    public void altero_o_valor_do_slider_para(String valor) {
        ElementosBasicosPage.actions()
            .alterarSlider(valor)
            .takeScreenShot();
    }

    @When("clico no interruptor")
    public void clico_no_interruptor() {
        ElementosBasicosPage.actions()
            .clicarInterruptor()
            .takeScreenShot();
    }

    @Then("a URL atual deve ser a correta")
    public void a_url_atual_deve_ser_a_correta() {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validateUrl(ElementosBasicosPage.URL);
    }

    @Then("valido que o botão clique aqui possui {string} clique")
    public void valido_que_o_botao_clique_aqui_possui_clique(String quantidade) {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validarQuantidadeCliquesSimples(quantidade);
    }

    @Then("valido que o botão duplo clique possui {string} clique")
    public void valido_que_o_botao_duplo_clique_possui_clique(String quantidade) {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validarQuantidadeCliquesDuplo(quantidade);
    }

    @Then("valido que o campo de texto possui digitado {string}")
    public void valido_que_o_campo_de_texto_possui_digitado(String texto) {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validarValorInput(texto);
    }

    @Then("valido que o dropdown de framework exibe a opcao {string}")
    public void valido_que_o_dropdown_de_framework_exibe_a_opcao(String texto) {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validarOpcaoDropdown(texto);
    }

    @Then("valido que o slider possui o valor {string}")
    public void valido_que_o_slider_possui_o_valor(String valor) {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validarValorSlider(valor);
    }

    @Then("valido que o interruptor esta ativado")
    public void valido_que_o_interruptor_esta_ativado() {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validarEstadoInterruptor(true);
    }

    @Then("valido que o interruptor esta desativado")
    public void valido_que_o_interruptor_esta_desativado() {
        ElementosBasicosPage.actions()
            .takeScreenShot()
            .validarEstadoInterruptor(false);
    }
}