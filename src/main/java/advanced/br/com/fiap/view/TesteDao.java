package advanced.br.com.fiap.view;

import advanced.br.com.fiap.dao.FuncionarioDAO;
import advanced.br.com.fiap.dao.FuncionarioDAOImpl;
import advanced.br.com.fiap.entity.Funcionario;
import advanced.br.com.fiap.entity.FuncionarioSenior;
import advanced.br.com.fiap.entity.VigiaNoturno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteDao {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        EntityManager em = fabrica.createEntityManager();

        FuncionarioDAO dao = new FuncionarioDAOImpl(em);

        Funcionario funcionario = new Funcionario("Naruto Namikaze", 152, 12.5);
        FuncionarioSenior funcSenior = new FuncionarioSenior("Might Guy", 104, 35.0);
        VigiaNoturno noturno = new VigiaNoturno("Kurt Wagner", 176, 15.0, 12.5);

        // Cadastra o Funcionário
        try {
            // Está dando erro:
//            funcionario.exibirSQL(funcionario, "INSERT");
            dao.cadastrar(funcionario);
            dao.cadastrar(funcSenior);
            dao.cadastrar(noturno);
            dao.commit();
            System.out.printf("Funcionário %s, cadastrado com sucesso! :)", funcionario.getNome());
            System.out.printf("Funcionário %s, cadastrado com sucesso! :)", funcSenior.getNome());
            System.out.printf("Funcionário %s, cadastrado com sucesso! :)", noturno.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Busca o Funcionário
        try {
            Funcionario buscaFunc = dao.buscarPorId(funcionario.getId());
            buscaFunc.imprimirInformacao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Atualizar Funcionário
        try {
            funcionario.setNome("Naruto Uzumaki");
            dao.atualizar(funcionario);
            dao.commit();
            System.out.printf("Funcionário %s, atualizado com sucesso", funcionario.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remover Funcionário
        try {
            dao.remover(funcionario.getId());
            dao.commit();
            System.out.printf("Funcionário %s, removido com sucesso!", funcionario.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
