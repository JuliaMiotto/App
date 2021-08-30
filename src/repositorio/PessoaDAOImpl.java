package repositorio;

import entidade.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoaDAOImpl implements PessoaDAO {
    private final Map<Integer, Pessoa> dados = new HashMap<>();
    private int identificador = 0;

    @Override
    public int adicionar(Pessoa p) {
        p.setId(identificador);
        dados.put(identificador, p);
        identificador++;
        return p.getId();
    }

    @Override
    public void atualizar(Pessoa p) {
        dados.replace(p.getId(), p);
    }

    @Override
    public void deletarPeloId(int id) {
        dados.remove(id);
    }

    @Override
    public Pessoa obterPeloId(int id) {
        return dados.get(id);
    }

    @Override
    public List<Pessoa> obterTodos() {
        return new ArrayList<>(dados.values());
    }
}
