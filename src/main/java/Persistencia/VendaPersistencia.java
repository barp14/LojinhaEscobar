package Persistencia;

import UtilFolder.Console;
import org.BancoDeDados.BancoDeDados;

public class VendaPersistencia {

  public static void venderProduto(){

    BancoDeDados bancoDeDados = new BancoDeDados();
    String codigo = Console.readString("\nCódigo do produto: ");

    int qtdCompra = Console.readInt("\nQuantidade de produtos que deseja comprar: ");

    BancoDeDados.venderProduto(codigo, qtdCompra);

    UtilFolder.Util.linha();
  }

  public static void novaVenda(){
    BancoDeDados bancoDeDados = new BancoDeDados();
    String decisao =  Console.readString("\nDeseja comprar mais algo? (S/N) ");

    switch (decisao){

      case "s":
      case "S":
        venderProduto();
        break;

      case "n":
      case "N":
        break;
    }

    UtilFolder.Util.linha();
  }

}
