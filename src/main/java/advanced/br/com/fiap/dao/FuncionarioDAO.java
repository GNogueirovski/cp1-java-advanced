package advanced.br.com.fiap.dao;

import advanced.br.com.fiap.entity.Funcionario;
import advanced.br.com.fiap.exception.CommitException;
import advanced.br.com.fiap.exception.IdNaoEncontradoException;

public interface FuncionarioDAO {
    void cadastrar(Funcionario funcionario);

    void atualizar(Funcionario funcionario) throws IdNaoEncontradoException;

    void remover(int id) throws IdNaoEncontradoException;

    Funcionario buscarPorId(int id) throws IdNaoEncontradoException;

    void commit() throws CommitException;
}
