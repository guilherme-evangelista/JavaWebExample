# language: pt
@regressivo @frontend @formularios
Funcionalidade: QA Playground - Formulários Simples

  Contexto:
    Dado que estou na aba de Formulários Simples
  
  Cenário: CT-01 - Cadastro realizado com sucesso
    Quando preencho o formulário com dados válidos e aceito os termos
    E clico no botão Enviar
    Então visualizo a mensagem "Formulário enviado com sucesso!"

  Cenário: CT-02 - Tentativa de cadastro sem aceitar os termos
    Quando preencho todos os campos de texto corretamente
    E clico no botão Enviar sem aceitar os termos
    Então visualizo a mensagem "Você deve aceitar os termos"

  Cenário: CT-03 - Limpar campos do formulário
    Quando preencho o formulário com dados válidos e aceito os termos
    E clico no botão Limpar
    Então verifico que todos os campos do formulário foram resetados

  Cenário: CT-04 - Validar obrigatoriedade do campo Nome
    Quando preencho o formulário exceto o campo "Nome"
    E clico no botão Enviar
    Então visualizo a mensagem "Nome é obrigatório"

  Cenário: CT-05 - Validar obrigatoriedade do campo Email
    Quando preencho o formulário exceto o campo "Email"
    E clico no botão Enviar
    Então visualizo a mensagem "Email é obrigatório"

  Cenário: CT-06 - Validar obrigatoriedade do campo Senha
    Quando preencho o formulário exceto o campo "Senha"
    E clico no botão Enviar
    Então visualizo a mensagem "Senha é obrigatória"

  Cenário: CT-07 - Validar erro de confirmação de senha divergente
    Quando preencho a senha "SENHA_VALIDA" e a confirmação "SENHA_ERRADA"
    E clico no botão Enviar
    Então visualizo a mensagem "Senhas não coincidem"