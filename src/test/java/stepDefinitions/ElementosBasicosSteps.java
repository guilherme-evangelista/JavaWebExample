package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.ElementosBasicosPage;

public class ElementosBasicosSteps {

    ElementosBasicosPage page = new ElementosBasicosPage();

    @Given("que estou na tela inicial QA Playground")
    public void que_estou_na_tela_inicial_qa_playground() {
        page.acessarPaginaInicial();
    }

    @When("clico no botão clique aqui")
    public void clico_no_botao_clique_aqui() {
        page.clicarBotaoSimples();
    }

    @When("clico no botão duplo clique")
    public void clico_no_botao_duplo_clique() {
        page.clicarBotaoDuplo();
    }

    @When("escrevo no campo de texto {string}")
    public void escrevo_no_campo_de_texto(String texto) {
        page.preencherTexto(texto);
    }

    @When("seleciono a opcao no dropdown de framework {string}")
    public void seleciono_a_opcao_no_dropdown_de_framework(String framework) {
        page.selecionarDropdown(framework);
    }

    @When("altero o valor do slider para {string}")
    public void altero_o_valor_do_slider_para(String valor) {
        page.alterarSlider(valor);
    }

    @When("clico no interruptor")
    public void clico_no_interruptor() {
        page.clicarInterruptor();
    }

    @Then("a URL atual deve ser a correta")
    public void a_url_atual_deve_ser_a_correta() {
        page.validateUrl(ElementosBasicosPage.URL);
    }

    @Then("valido que o botão clique aqui possui {string} clique")
    public void valido_que_o_botao_clique_aqui_possui_clique(String quantidade) {
        page.validarQuantidadeCliquesSimples(quantidade);
    }

    @Then("valido que o botão duplo clique possui {string} clique")
    public void valido_que_o_botao_duplo_clique_possui_clique(String quantidade) {
        page.validarQuantidadeCliquesDuplo(quantidade);
    }

    @Then("valido que o campo de texto possui digitado {string}")
    public void valido_que_o_campo_de_texto_possui_digitado(String texto) {
        page.validarValorInput(texto);
    }

    @Then("valido que o dropdown de framework exibe a opcao {string}")
    public void valido_que_o_dropdown_de_framework_exibe_a_opcao(String texto) {
        page.validarOpcaoDropdown(texto);
    }

    @Then("valido que o slider possui o valor {string}")
    public void valido_que_o_slider_possui_o_valor(String valor) {
        page.validarValorSlider(valor);
    }

    @Then("valido que o interruptor esta ativado")
    public void valido_que_o_interruptor_esta_ativado() {
        page.validarEstadoInterruptor(true);
    }

    @Then("valido que o interruptor esta desativado")
    public void valido_que_o_interruptor_esta_desativado() {
        page.validarEstadoInterruptor(false);
    }
}