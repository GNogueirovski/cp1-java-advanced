package advanced.br.com.fiap.view;

import advanced.br.com.fiap.dao.FuncionarioDAO;
import advanced.br.com.fiap.dao.FuncionarioDAOImpl;
import advanced.br.com.fiap.entity.Funcionario;
import advanced.br.com.fiap.entity.FuncionarioSenior;
import advanced.br.com.fiap.entity.VigiaNoturno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //Criar a fabrica
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        //Criar o Entity manager
        EntityManager em = fabrica.createEntityManager();

        //Instanciar o DAO
        FuncionarioDAO dao = new FuncionarioDAOImpl(em);

        //Cadastrar um Cliente (CREATE -> INSERT)
        VigiaNoturno funcionario = new VigiaNoturno("malaquias", 10, 25.5F,1.2);

        try {
            dao.cadastrar(funcionario);
            dao.commit();
            System.out.println();
            funcionario.exibirSQL(funcionario, "INSERT");
            funcionario.imprimirInformacao();
            System.out.println("Funcionario cadastrado!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
