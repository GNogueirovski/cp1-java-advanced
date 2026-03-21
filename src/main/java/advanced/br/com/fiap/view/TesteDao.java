package advanced.br.com.fiap.view;

import advanced.br.com.fiap.dao.FuncionarioDAO;
import advanced.br.com.fiap.dao.FuncionarioDAOImpl;
import advanced.br.com.fiap.entity.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteDao {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        EntityManager em = fabrica.createEntityManager();

        FuncionarioDAO dao = new FuncionarioDAOImpl(em);

        Funcionario funcionario = new Funcionario("Naruto Namikaze", 500, 12.5);

        // Cadastra o Funcionário
        try {
            dao.cadastrar(funcionario);
            dao.commit();
            System.out.printf("Funcionário %s, cadastrado com sucesso! :)", funcionario.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Busca o Funcionário
        try {
            Funcionario busca = dao.buscarPorId(2);
            busca.imprimirInformacao();
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
