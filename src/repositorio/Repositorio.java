package repositorio;

public class Repositorio {
    private static Repositorio instancia;
    private final PessoaDAO instanciaPessoaDao = new PessoaDAOImpl();

    private Repositorio() { }

    public static Repositorio obterInstancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }

    public PessoaDAO pessoas() {
        return instanciaPessoaDao;
    }
}
