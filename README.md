# CP01 - Java Advanced

_Programação em Java, JPA e Annotations_

Esta é uma aplicação para persistência de dados de Funcionários. Tem o objetivo de demonstrar os conhecimentos de 
persistência de dados no banco de dados Oracle, usando JPA / Hibernate.


## 📂 Estrutura de pastas

---

```
teste-cp1
├── src/main
│   ├── java/advanced/br/com/fiap
│   │   ├── annotations  # Anotações customizadas para o projeto
│   │   ├── dao          # Interfaces e Implementações do padrão Data Access Object
│   │   ├── entity       # Classes de domínio que representam as tabelas do banco
│   │   ├── exception    # Exceções personalizadas (erros de commit, ID não encontrado)
│   │   └── view         # Classe principal (Main) para execução do sistema
│   └── resources/META-INF
│       └── persistence.xml # Configurações de persistência de dados (JPA)
├── pom.xml              # Gerenciador de dependências Maven
└── .gitignore           # Arquivos ignorados pelo controle de versão
```

<br>


## 🚀 Tecnologias Utilizadas

---
* **Java JDK:** 21 ou superior
* **Framework de Persistência:** JPA / Hibernate
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** Oracle Database
* **IDE recomendada:** IntelliJ IDEA

<br>


## 📂 Estrutura do Projeto

---

A organização dos pacotes segue as melhores práticas de separação de responsabilidades:

* `annotations`: Contém anotações customizadas para mapeamento ou lógica de negócio.
* `dao`: Interface e implementação.
* `entity`: Classes de modelo (_models_) mapeadas como entidades do banco de dados.
* `exception`: Classes para tratamento de erros específicos.
* `view`: Classe `Main` que contém o ponto de entrada da aplicação para testes.
* `resources/META-INF`: Arquivo `persistence.xml` com as configurações de conexão com banco.

<br>


## 🛠️ Como Executar

---

1. Clone o repositório:

```Bash
git clone https://github.com/GNogueirovski/cp1-java-advanced.git
```

2. Importe o projeto na sua IDE como um projeto Maven.

3. Atualize as dependências do Maven (`pom.xml`).

4. Execute a classe `Main.java` localizada no pacote `br.com.fiap.view`.

<br>


## ⚙️ Configuração do Banco de Dados

---

Para executar o projeto, certifique-se de configurar as credenciais do seu banco Oracle no arquivo:
`src/main/resources/META-INF/persistence.xml`

```xml
<properties>
    <property name="javax.persistence.jdbc.user" value="SeuLoginAqui"/>
    <property name="javax.persistence.jdbc.password" value="SuaSenhaAqui"/>
</properties>
```

<br>


## Diagrama de Classes

---

<img src="./prints/CP01-Diagrama-de-Classes.jpg" alt="CP01-Diagrama-de-Classes"/><br/>


## 🎓 Demonstração

---
Abaixo há os prints das telas do terminal e do banco de dados mostrando o resultado da execução do CRUD. <br>
Saída no terminal para criação do banco.

<img src="./prints/comprovacao-criacao-banco-via-hibernate.png" alt="comprovacao-criacao-banco-via-hibernate"/><br/>


Estado inicial do banco

<img src="./prints/estado-inicial-banco.png" alt="estado-inicial-banco"/><br/>

<br>


### Incerir informações no banco: INSERT

---

Saida no terminal após inserir as informações.

<img src="./prints/print-insert-dos-funcionarios-programa.png" alt="print-insert-dos-funcionarios-programa"/><br/>

Banco após inserção.

<img src="./prints/print-insert-dos-funcionarios-banco.png" alt="print-insert-dos-funcionarios-banco"/><br/>

<br>


### Selecionar: SELECT

---

Saída no terminal após selecionar um funcionário.

<img src="./prints/print-select-do-funcionario-programa.png" alt="print-select-do-funcionario-programa"/><br/>

<br>


### Atualizar informações: UPDATE

---

Atualizar o vigia noturno de ID_FUNCIONARIO 6 de `João Bobo` para `Marcelo Vagner`.

Terminal.

<img src="./prints/print-update-vigia-noturno-programa.png" alt="print-update-vigia-noturno-programa"/><br/>

Banco de Dados, pré-update.

<img src="./prints/print-preupdate-vigia-banco.png" alt="print-preupdate-vigia-banco"/><br/>

Banco de Dados, pós-update.

<img src="./prints/print-posupdate-vigia-banco.png" alt="print-posupdate-vigia-banco"/><br/>

<br>


### Deletar informações: DELETE

---

<img src="./prints/print-delete-funcionario-programa-com-exception.png" alt="print-delete-funcionario-programa-com-exception"/><br/>

<br>


## 👤 Desenvolvedores

---

<div align="center">
  <table>
    <tr>
      <td align="center">
        <a href="https://github.com/AugustoBJunior">
          <img src="https://avatars.githubusercontent.com/u/203031927?v=4" width="115" alt="Augusto Bonomo Jr"/><br />
          <sub><b>Augusto Bonomo Jr</b></sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/GNogueirovski">
          <img src="https://avatars.githubusercontent.com/u/188595664?v=4" width="115" alt="Gabriel Peixoto"/><br />
          <sub><b>Gabriel Peixoto</b></sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/Giovanna-Nerii">
          <img src="https://avatars.githubusercontent.com/u/125685337?v=4" width="115" alt="Giovanna Neri"/><br />
          <sub><b>Giovanna Neri</b></sub>
        </a>
      </td>
    <tr>
      <td align="center">
        <a href="https://github.com/Mariinoue">
          <img src="https://avatars.githubusercontent.com/u/82849390?v=4" width="115" alt="Mariana Inoue"/><br />
          <sub><b>Mariana Inoue</b></sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/NathanaelV">
          <img src="https://avatars.githubusercontent.com/u/59123681?v=4" width="115" alt="Nathanael Vieira"/><br />
          <sub><b>Nathanael Vieira</b></sub>
        </a>
      </td>
    </tr>
  </table>
</div>
