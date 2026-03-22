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

        Funcionario funcionario = new Funcionario("Maria das Flores", 149, 22.5);
        FuncionarioSenior funcSenior = new FuncionarioSenior("Ayrton Senna", 112, 45.0);
        VigiaNoturno noturno = new VigiaNoturno("João Bobo", 176, 15.0, 15.5);

        // Cadastra o Funcionário
        try {
            dao.cadastrar(funcionario);
            dao.cadastrar(funcSenior);
            dao.cadastrar(noturno);
            dao.commit();

            System.out.printf("\n\nFuncionário %s, cadastrado com sucesso!\n", funcionario.getNome());
            funcionario.exibirSQL(funcionario, "INSERT");
            System.out.printf("\n\nFuncionário %s, cadastrado com sucesso!\n", funcSenior.getNome());
            funcSenior.exibirSQL(funcSenior, "INSERT");
            System.out.printf("\n\nFuncionário %s, cadastrado com sucesso!\n", noturno.getNome());
            noturno.exibirSQL(noturno, "INSERT");
            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Seleciona Funcionário
        try {
            Funcionario funcionarioEncontrado = dao.buscarPorId(funcionario.getId());
            funcionarioEncontrado.exibirSQL(funcionarioEncontrado, "SELECT");
            funcionarioEncontrado.imprimirInformacao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Atualiza Vigia Noturno, que herda de Funcionário
        try {
            noturno.imprimirInformacao();
            noturno.setNome("Marcelo Vagner");
            dao.atualizar(noturno);
            dao.commit();
            noturno.exibirSQL(noturno, "UPDATE");
            System.out.printf("\nFuncionário %s, atualizado com sucesso\n\n", noturno.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remove Funcionário
        try {
            dao.remover(funcSenior.getId());
            dao.commit();
            System.out.println();
            funcSenior.exibirSQL(funcSenior, "DELETE");
            System.out.printf("\nFuncionário %s, removido com sucesso!\n\n", funcSenior.getNome());
            Funcionario funcionarioRemovido = dao.buscarPorId(funcSenior.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
