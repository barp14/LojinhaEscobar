package Persistencia;

import Entidades.Produto;
import Util.Console;
import org.BancoDeDados.BancoDeDados;

public class ProdutoPersistencia {

  public static boolean incluir(){
    BancoDeDados bancoDeDados = new BancoDeDados();

    String codigo;
    String nome;
    Float preco;
    int qtdEstoque;

    try{
      codigo = Console.readString("Digite o código do produto: ");
      nome = Console.readString("Digite o nome do produto: ");
      preco = Console.readFloat("Digite o preço do produto: ");
      qtdEstoque = Console.readInt("Digite a quantidade em estoque: ");

      Produto novoProduto = new Produto(codigo, nome, preco, qtdEstoque);
      bancoDeDados.salvarProduto(novoProduto);
      return true;

    } catch (Exception e){
      System.out.println("Impossível adicionar o produto.");
      return false;

    }
  }

  public static void exibir(){
    BancoDeDados bancoDeDados = new BancoDeDados();
    bancoDeDados.exibirProdutos();
  }

}
