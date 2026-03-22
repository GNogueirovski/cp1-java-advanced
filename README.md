# CP01 - Java Advanced

_Programação em Java, JPA e Annotations_

Esta é uma aplicação para persistência de dados de Funcionários. Tem o objetivo de demonstrar os conhecimentos de
persistência de dados no banco de dados Oracle, usando JPA / Hibernate, herança de entidades e anotações customizadas.


## 📂 Estrutura de Pastas

---

```
cp1-java-advanced
├── prints/                          # Prints de execução do projeto
├── src/main
│   ├── java/advanced/br/com/fiap
│   │   ├── annotations              # Anotação customizada @Descricao
│   │   ├── dao                      # Interface e implementação do padrão DAO
│   │   ├── entity                   # Entidades JPA (Funcionario, FuncionarioSenior, VigiaNoturno)
│   │   ├── exception                # Exceções personalizadas (CommitException, IdNaoEncontradoException)
│   │   └── view                     # Classe TesteDao com o ponto de entrada da aplicação
│   └── resources/META-INF
│       └── persistence.xml          # Configurações de persistência JPA (conexão Oracle)
├── pom.xml                          # Gerenciador de dependências Maven
└── .gitignore                       # Arquivos ignorados pelo controle de versão
```

<br>


## 🚀 Tecnologias Utilizadas

---
* **Java JDK:** 21 ou superior
* **Framework de Persistência:** JPA / Hibernate 5.4
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** Oracle Database (FIAP)
* **IDE recomendada:** IntelliJ IDEA

<br>


## 📦 Estrutura do Projeto

---

A organização dos pacotes segue as melhores práticas de separação de responsabilidades:

* `annotations`: Contém a anotação customizada `@Descricao`, aplicada na entidade `Funcionario` para descrever a tabela.
* `dao`: Interface `FuncionarioDAO` e sua implementação `FuncionarioDAOImpl`, com as operações `cadastrar`, `atualizar`, `remover`, `buscarPorId` e `commit`.
* `entity`: Classes mapeadas como entidades JPA:
  * `Funcionario` — entidade base, mapeada para a tabela `TB_FUNCIONARIO`.
  * `FuncionarioSenior` — estende `Funcionario`; calcula bônus de 5% a cada 15h trabalhadas.
  * `VigiaNoturno` — estende `Funcionario`; possui campo adicional `adicional_noturno` e cálculo de salário com adicional percentual.
* `exception`: `CommitException` (erro na transação) e `IdNaoEncontradoException` (registro não encontrado).
* `view`: Classe `TesteDao` — ponto de entrada da aplicação; executa operações de INSERT, SELECT, UPDATE e DELETE.
* `resources/META-INF`: Arquivo `persistence.xml` com as configurações de conexão e comportamento do Hibernate.

<br>


## 🧬 Herança de Entidades

---

O projeto utiliza a estratégia **Single Table Inheritance** do JPA: todas as subclasses (`FuncionarioSenior` e `VigiaNoturno`) são armazenadas na mesma tabela `TB_FUNCIONARIO` da entidade pai `Funcionario`.

```
Funcionario  (TB_FUNCIONARIO)
├── FuncionarioSenior
│     └── Bônus de 5% a cada 15h trabalhadas
└── VigiaNoturno
      └── Adicional noturno percentual + bônus por dias trabalhados
```

<br>


## 🖼️ Demonstração do Funcionamento

---

### 1. Estado inicial do banco de dados

Estado da tabela `TB_FUNCIONARIO` antes da execução da aplicação (tabela vazia):

![Estado inicial do banco](prints/estado-inicial-banco.png)

<br>

### 2. Criação automática da tabela via Hibernate

O Hibernate cria automaticamente a estrutura da tabela no Oracle ao iniciar a aplicação (`hibernate.hbm2ddl.auto=update`):

![Comprovação de criação do banco via Hibernate](prints/comprovacao-criacao-banco-via-hibernate.png)

<br>

### 3. INSERT — Cadastro dos funcionários

**Saída no console** após o cadastro de `Funcionario`, `FuncionarioSenior` e `VigiaNoturno`:

![INSERT dos funcionários no programa](prints/print-insert-dos-funcionarios-programa.png)

**Registros inseridos no banco de dados:**

![INSERT dos funcionários no banco](prints/print-insert-dos-funcionarios-banco.png)

<br>

### 4. SELECT — Busca por ID

Saída no console após a busca do funcionário base (`Maria das Flores`) pelo seu ID:

![SELECT do funcionário no programa](prints/print-select-do-funcionario-programa.png)

<br>

### 5. UPDATE — Atualização do Vigia Noturno

**Estado do banco antes da atualização** (nome original: `João Bobo`):

![Banco antes do UPDATE](prints/print-preupdate-vigia-banco.png)

**Saída no console** após a atualização do nome para `Marcelo Vagner`:

![UPDATE do Vigia Noturno no programa](prints/print-update-vigia-noturno-programa.png)

**Estado do banco após a atualização:**

![Banco após o UPDATE](prints/print-posupdate-vigia-banco.png)

<br>

### 6. DELETE — Remoção e tratamento de exceção

Remoção do `FuncionarioSenior` (`Ayrton Senna`) e lançamento da exceção `IdNaoEncontradoException` ao tentar buscá-lo novamente:

![DELETE do funcionário com exceção no programa](prints/print-delete-funcionario-programa-com-exception.png)

<br>


## ⚙️ Configuração do Banco de Dados

---

Para executar o projeto, configure as credenciais do seu banco Oracle no arquivo:
`src/main/resources/META-INF/persistence.xml`

```xml
<properties>
    <property name="javax.persistence.jdbc.user" value="SeuRMaqui"/>
    <property name="javax.persistence.jdbc.password" value="SuaSenhaAqui"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl"/>
</properties>
```

<br>


## 🛠️ Como Executar

---

1. Clone o repositório:

```bash
git clone https://github.com/GNogueirovski/cp1-java-advanced.git
```

2. Importe o projeto na sua IDE como um projeto Maven.

3. Atualize as dependências do Maven (`pom.xml`).

4. Configure suas credenciais Oracle no arquivo `src/main/resources/META-INF/persistence.xml`.

5. Execute a classe `TesteDao.java` localizada no pacote `advanced.br.com.fiap.view`.

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
    </tr>
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
