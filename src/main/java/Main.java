import Persistencia.ProdutoPersistencia;
import Util.Console;

public class Main {
  public static void main(String[] args) {
    int opcao;

    do {

      System.out.println("\nO que deseja: ");
      System.out.println("1 - Cadastrar produto");
      System.out.println("2 - Exibir produtos no estoque");
      opcao = Console.readInt("\nOpção escolhida: ");

      switch (opcao) {
        case 1:
          ProdutoPersistencia.incluir();
          break;

        case 2:
          ProdutoPersistencia.exibir();
          break;

        default:
          System.out.println("Opção inválida.");
          break;
      }
    } while (opcao != 2);
  }
}