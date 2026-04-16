# 🚀 QA Automation Framework - Web

![Status da Pipeline](https://github.com/guilherme-evangelista/JavaWebExample/actions/workflows/pipeline-testes.yml/badge.svg)
[![GitHub Pages](https://img.shields.io/badge/Relatório-Cucumber%20BDD-brightgreen?logo=cucumber)](https://guilherme-evangelista.github.io/JavaWebExample/)

Projeto de automação de testes Web desenvolvido com foco em estabilidade, execução paralela e design patterns de mercado. Estruturado para testes contínuos (CI/CD) com geração de relatórios visuais avançados.

## 🛠️ Stack Tecnológica

* **Linguagem:** Java 17
* **Core de Automação:** Selenium WebDriver 4 (com Selenium Manager nativo)
* **BDD & Especificação:** Cucumber
* **Motor de Execução:** TestNG
* **Geração de Massa de Dados:** DataFaker
* **Relatórios:** Cluecumber Report Plugin
* **CI/CD:** GitHub Actions & GitHub Pages

## 🏗️ Arquitetura e Padrões de Projeto

O framework foi construído visando alta manutenibilidade e resiliência:
* **Page Object Model (POM):** Separação clara entre a lógica de teste e o mapeamento de elementos usando `@FindBy`.
* **BasePage com FluentWait:** Abstração das interações do Selenium para lidar nativamente com sincronização, ignorando exceções comuns (ex: `StaleElementReferenceException`) de forma semelhante ao auto-wait de frameworks modernos em JS.
* **ThreadLocal (Isolamento de Threads):** Gerenciamento seguro das instâncias do WebDriver no `DriverFactory`, permitindo execução de testes estritamente em paralelo sem colisão de dados.
* **Hooks Automatizados:** Captura automática de *screenshots* em caso de falha no cenário e encerramento seguro dos processos do navegador.

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* [JDK 17+](https://adoptium.net/) configurado nas variáveis de ambiente.
* [Maven](https://maven.apache.org/) instalado.
* Navegador Google Chrome instalado.

### Execução Local
Para rodar todos os testes localmente via terminal, garantindo o download das dependências e gerando o relatório final:
```bash
mvn clean test
```
*O relatório será gerado na pasta `target/cluecumber-report`. Basta abrir o arquivo `index.html` no navegador.*

### Execução na Pipeline (CI/CD)
A integração contínua está configurada no arquivo `.github/workflows/pipeline-testes.yml`. Os testes são acionados automaticamente:
1. Em cada `push` para a branch `main`.
2. Na abertura de um `Pull Request`.
3. Manualmente via `Workflow Dispatch` na aba Actions do GitHub.

Os testes rodam em modo *Headless* (sem interface gráfica) no servidor `ubuntu-latest`. Ao final da execução, independentemente de falhas, o relatório é consolidado e publicado automaticamente no **GitHub Pages**.

## 📁 Estrutura de Diretórios

```text
src/
 ├── main/java/
 │    ├── factory/          # Setup de Browsers e ThreadLocal (DriverFactory)
 │    ├── pages/            # BasePage (FluentWaits) e Classes de Página (@FindBy)
 |    └── utils/            # Utilitários (DataFaker, Report, Screenshot, etc)
 └── test/
      ├── java/
      │    ├── runner/      # RunTests (Configuração Cucumber + TestNG Paralelo)
      │    └── stepDefs/    # Implementação dos passos (Gherkin) e Hooks
      └── resources/
           └── features/    # Arquivos de especificação BDD (.feature)
```