import Persistencia.ProdutoPersistencia;
import Persistencia.VendaPersistencia;
import UtilFolder.Console;

public class Main {
  public static void main(String[] args) {
    int opcao;

    do {
      System.out.println("\nO que deseja: ");
      System.out.println("1 - Cadastrar produto");
      System.out.println("2 - Exibir produtos no estoque");
      System.out.println("3 - Procurar produto por código");
      System.out.println("4 - Calcular valor total");
      System.out.println("5 - Comprar um produto");
      System.out.println("6 - Sair");
      opcao = Console.readInt("\nOpção escolhida: ");

      switch (opcao) {
        case 1:
          ProdutoPersistencia.incluir();
          break;

        case 2:
          ProdutoPersistencia.exibirProdutos();
          break;

        case 3:
          ProdutoPersistencia.buscarProdutoPorCodigo();
          break;

        case 4:
          ProdutoPersistencia.calcularValorTotal();
          break;

        case 5:
          VendaPersistencia.venderProduto();
          break;

        default:
          System.out.println("Opção inválida.");
          break;
      }
    } while (opcao != 5);
  }
}