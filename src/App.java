import entidade.Pessoa;
import repositorio.Repositorio;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Repositorio repositorio = Repositorio.obterInstancia();
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar nova pessoa");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Consultar pelo ID");
            System.out.println("5 - Consultar todos");

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    sc = new Scanner(System.in);
                    String nome = sc.nextLine();
                    System.out.print("Sobrenome: ");
                    sc = new Scanner(System.in);
                    String sobrenome = sc.nextLine();

                    int idPessoa = repositorio.pessoas().adicionar(new Pessoa(nome, sobrenome));
                    System.out.println("Pessoa criada! ID: " + idPessoa);
                    break;

                case 2:
                    System.out.print("ID a ser atualizado: ");
                    sc = new Scanner(System.in);
                    int idAtualizar = sc.nextInt();

                    System.out.print("Nome: ");
                    sc = new Scanner(System.in);
                    String nomeAtualizar = sc.nextLine();

                    System.out.print("Sobrenome: ");
                    sc = new Scanner(System.in);
                    String sobrenomeAtualizar = sc.nextLine();

                    Pessoa pessoa = new Pessoa(nomeAtualizar, sobrenomeAtualizar);
                    pessoa.setId(idAtualizar);
                    repositorio.pessoas().atualizar(pessoa);
                    System.out.println("Pessoa atualizada! ID: " + idAtualizar);
                    break;

                case 3:
                    System.out.print("ID a ser deletado: ");
                    sc = new Scanner(System.in);
                    int idDeletar = sc.nextInt();

                    repositorio.pessoas().deletarPeloId(idDeletar);
                    System.out.println("Pessoa deletada! ID: " + idDeletar);
                    break;

                case 4:
                    System.out.print("ID a ser consultado: ");
                    sc = new Scanner(System.in);
                    int idConsultar = sc.nextInt();

                    Pessoa pessoaResposta = repositorio.pessoas().obterPeloId(idConsultar);
                    System.out.println(pessoaResposta);
                    break;

                case 5:
                    List<Pessoa> listaPessoas = repositorio.pessoas().obterTodos();
                    for (Pessoa pessoaUn: listaPessoas) {
                        System.out.println(pessoaUn);
                    }
                    break;
            }
        }
    }
}
