# Projeto de Gerenciamento de Viagens

Este projeto é uma aplicação web simples para gerenciar Pessoas, Viagens e Agentes de Viagem utilizando **Spring MVC** com **Thymeleaf** para renderização dos templates HTML. O sistema permite cadastrar, visualizar e relacionar essas entidades com validação de dados e layout responsivo usando Bootstrap.

---

## Sumário

- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura dos Templates Thymeleaf](#estrutura-dos-templates-thymeleaf)

---

## Funcionalidades

- Cadastro de Pessoas com dados pessoais e associação com Viagens e Agentes de Viagem.
- Cadastro de Viagens com destino e período (data de início e fim).
- Cadastro de Agentes de Viagem com nome e e-mail.
- Visualização detalhada de Pessoas incluindo suas Viagens e seu Agente de Viagem.
- Validação de dados nos formulários com mensagens de erro amigáveis.
- Uso de máscaras para campos específicos (ex: CPF).
- Layout responsivo com Bootstrap e ícones com FontAwesome.

---

## Tecnologias Utilizadas

- **Spring MVC**: Framework para construção da aplicação web e MVC.
- **Thymeleaf**: Motor de template para geração dinâmica das páginas HTML.
- **Bootstrap 5**: Biblioteca CSS para design responsivo e componentes prontos.
- **jQuery** e **Inputmask**: Para máscaras em campos de formulário.
- **FontAwesome**: Ícones visuais.
- **Java 17+**: Linguagem base para backend.
- **Maven**: Gerenciador de dependências e build.
- **Banco de Dados**: PostgreSQL.

---

## Estrutura dos Templates Thymeleaf

### 1. Cadastro de Pessoa (`cadastrar-pessoa.html`)

- Formulário que permite inserir ou editar dados pessoais: nome, idade, e-mail, CPF.
- Associação com Viagens via checkboxes múltiplos.
- Associação com Agente de Viagem via dropdown select.
- Mensagens de erro exibidas próximas aos campos.
- Exemplo básico para aplicar máscara de CPF.

### 2. Cadastro de Viagem (`cadastrar-viagem.html`)

- Formulário simples com campos: destino, data de início, data de fim.
- Validação de campos obrigatórios.
- Mensagem de sucesso na gravação da viagem.

### 3. Cadastro de Agente de Viagem (`cadastrar-agente.html`)

- Formulário para cadastro do agente com nome e e-mail.
- Validação simples de campos.

### 4. Visualização da Pessoa (`ver-pessoa.html`)

- Exibe dados pessoais completos da pessoa.
- Lista as viagens associadas em tabela.
- Exibe o agente de viagem associado.
- Mensagens que indicam se não houver viagens ou agente vinculados.
- Uso do `#temporals.format` para exibir datas no formato dd/MM/yyyy.
