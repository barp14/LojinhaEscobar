package org.BancoDeDados;

import Entidades.Produto;
import Persistencia.VendaPersistencia;
import UtilFolder.Util;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

public class BancoDeDados {
  private MongoDatabase database;
  private static MongoCollection<Document> collection;

  public BancoDeDados() {
    // String de conexão ao MongoDB
    String uri = "mongodb+srv://Cluster17383:mkJ1x6pUeSdA71FO@cluster0.8x86g.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    MongoClient mongoClient = MongoClients.create(uri);
    this.database = mongoClient.getDatabase("LojinhaEscobar");
    this.collection = database.getCollection("Estoque");
  }

  public void salvarProduto(Produto produto) {
    Document doc = new Document("codigo", produto.getCodigo())
        .append("nome", produto.getNome())
        .append("preco", produto.getPreco())
        .append("qtdEstoque", produto.getQtdEstoque());
    collection.insertOne(doc);
    System.out.println("\nProduto inserido com sucesso! ");
    UtilFolder.Util.linha();
  }

  public static Produto buscarProdutoPorCodigo(String codigo) {
    Document doc = collection.find(eq("codigo", codigo)).first();
    if (doc != null) {

        String nome = doc.getString("\nnome");
        Double preco = doc.getDouble("preco");
        Integer qtdEstoque = doc.getInteger("qtdEstoque");

        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em estoque: " + qtdEstoque);
        UtilFolder.Util.linha();
      return null;
    } else {
      System.out.println("Produto não encontrado.");
      UtilFolder.Util.linha();
      return null;
    }
  }

  public void exibirProdutos() {
    for (Document doc : collection.find()) {

      String codigo = doc.getString("codigo");
      String nome = doc.getString("nome");
      Double preco = doc.getDouble("preco");
      Integer qtdEstoque = doc.getInteger("qtdEstoque");

      System.out.println("\nCódigo: " + codigo);
      System.out.println("Nome: " + nome);
      System.out.println("Preço: R$" + preco);
      System.out.println("Quantidade em estoque: " + qtdEstoque);
      Util.linha();
    }
  }

  public static void calcularValorTotal(String codigo) {
    Document doc = collection.find(eq("codigo", codigo)).first();
    if (doc != null) {

      Double preco = doc.getDouble("preco");
      Integer qtdEstoque = doc.getInteger("qtdEstoque");

      Float valorTotal = (float) (preco * qtdEstoque);

      System.out.println("\nValor total desse produto em estoque: R$" + valorTotal);
      UtilFolder.Util.linha();
    } else {
      System.out.println("\nProduto não encontrado.");
      UtilFolder.Util.linha();
    }
  }

    /*
  public void atualizarProduto(String codigo, float novoPreco) {
    Document updateDoc = new Document("$set", new Document("preco", novoPreco));
    collection.updateOne(eq("codigo", codigo), updateDoc);
    System.out.println("Produto atualizado.");
  }

  public void deletarProduto(String codigo) {
    collection.deleteOne(eq("codigo", codigo));
    System.out.println("Produto deletado.");
  }
  */

  public static void venderProduto(String codigo, int qtdCompra){
    Document doc = collection.find(eq("codigo", codigo)).first();

    if (doc != null) {

      int qtdEstoqueAtual = doc.getInteger("qtdEstoque");

      if (qtdEstoqueAtual >= qtdCompra) {
        collection.updateOne(Filters.eq("codigo", codigo),
            Updates.set("qtdEstoque", qtdEstoqueAtual - qtdCompra));

        System.out.println("\nVenda realizada com sucesso!");
        System.out.println("\nQuantidade em estoque: " + (qtdEstoqueAtual - qtdCompra)); // qtdEstoque está atualizando no banco mas não no console

        VendaPersistencia.novaVenda();
        UtilFolder.Util.linha();
      } else {
        System.out.println("\nEstoque insuficiente para a venda.");
        UtilFolder.Util.linha();
      }
    } else {
      System.out.println("\nProduto não encontrado.");
      UtilFolder.Util.linha();
    }
  }
}