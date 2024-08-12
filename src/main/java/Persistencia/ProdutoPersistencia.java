package Persistencia;

import Entidades.Produto;
import UtilFolder.Console;
import org.BancoDeDados.BancoDeDados;

public class ProdutoPersistencia {

  public static void incluir(){
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

    } catch (Exception e){
      System.out.println("Impossível adicionar o produto.");

    }
  }

  public static void exibirProdutos(){
    BancoDeDados bancoDeDados = new BancoDeDados();
    bancoDeDados.exibirProdutos();
  }

  public static void buscarProdutoPorCodigo(){
    BancoDeDados bancoDeDados = new BancoDeDados(); // se tirar isso aqui o console da que o BD
    String codigo = Console.readString("Código do produto: ");
    BancoDeDados.buscarProdutoPorCodigo(codigo);
  }

  public static void calcularValorTotal() {
    BancoDeDados bancoDeDados = new BancoDeDados();
    String codigo = Console.readString("Código do produto: ");
    BancoDeDados.calcularValorTotal(codigo);
  }

}
