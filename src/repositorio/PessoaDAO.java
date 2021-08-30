package repositorio;

import entidade.Pessoa;

import java.util.List;

public interface PessoaDAO {
    int adicionar(Pessoa p);
    void atualizar(Pessoa p);
    void deletarPeloId(int id);
    Pessoa obterPeloId(int id);
    List<Pessoa> obterTodos();
}
