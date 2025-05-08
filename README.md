# Sistema de Gestão para PetShop 🐾

Sistema desenvolvido em Java com foco na organização e gestão de um PetShop. Permite o cadastro de clientes, animais, funcionários, além do agendamento e consulta de serviços como banho, tosa e consulta veterinária.

## ✨ Funcionalidades

- 📋 Cadastro de clientes com nome, CPF e animais (Gato ou Cachorro)  
- 👩‍💼 Cadastro de funcionários com nome, CPF, ID e cargo  
- 📆 Agendamento de serviços (Banho, Tosa ou Consulta) com data e hora  
- 🗓️ Consulta da agenda por data (LocalDate)  
- 🔍 Consulta de clientes e funcionários cadastrados  

## 🛠️ Tecnologias e Conceitos Utilizados

- Java 8+
- Programação Orientada a Objetos (POO): herança, abstração, polimorfismo e composição  
- Interface `Agendavel` para padronizar o agendamento de serviços  
- Estrutura de dados em memória (Listas, Arrays e Map)  
- Interface gráfica simples com `JOptionPane`  
- Tratamento de exceções com `try-catch`  

## 📦 Estrutura de Classes

- `Pessoa` (abstrata): base para `Cliente` e `Funcionario`  
- `Animal` (abstrata): base para `Cachorro` e `Gato`  
- `Servico` (abstrata): base para `Banho`, `Tosa` e `ConsultaVeterinaria`, implementa `Agendavel`  
- `SistemaPetShop`: responsável pelos cadastros e agendamentos  
- `Main`: interface interativa com o usuário baseada em menus  

## ▶️ Como Executar

1️⃣ Clone o repositório:

```bash
git clone https://github.com/seuusuario/sistema-gestao-petshop.git
cd sistema-gestao-petshop
