package advanced.br.com.fiap.dao;

import advanced.br.com.fiap.entity.Funcionario;
import advanced.br.com.fiap.exception.CommitException;
import advanced.br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;

public class FuncionarioDAOImpl implements FuncionarioDAO {
    private EntityManager em;

    public FuncionarioDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        em.persist(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) throws IdNaoEncontradoException {
        buscarPorId(funcionario.getId());
        em.merge(funcionario);
    }

    @Override
    public void remover(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = buscarPorId(id);
        em.remove(funcionario);
    }

    @Override
    public Funcionario buscarPorId(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario == null){
            throw new IdNaoEncontradoException("Funcionário não foi encontrado");
        }
        return funcionario;
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
