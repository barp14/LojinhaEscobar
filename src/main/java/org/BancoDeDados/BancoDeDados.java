package org.BancoDeDados;

import Entidades.Produto;
import Util.Util;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BancoDeDados {
  private MongoDatabase database;
  private MongoCollection<Document> collection;


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
    System.out.println("Produto inserido com sucesso! ");
  }

  /* public Produto buscarProdutoPorCodigo(String codigo) {
    Document doc = collection.find(eq("codigo", codigo)).first();
    if (doc != null) {
      return new Produto(
          doc.getString("codigo"),
          doc.getString("nome"),
          doc.getDouble("preco").floatValue(),
          doc.getInteger("qtdEstoque")
      );
    } else {
      System.out.println("Produto não encontrado.");
      return null;
    }
  }

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

  public void exibirProdutos() {
    for (Document doc : collection.find()) {

      String codigo = doc.getString("codigo");
      String nome = doc.getString("nome");
      Double preco = doc.getDouble("preco");
      Integer qtdEstoque = doc.getInteger("qtdEstoque");

      System.out.println("Código: " + codigo);
      System.out.println("Nome: " + nome);
      System.out.println("Preço: " + preco);
      System.out.println("Quantidade em estoque: " + qtdEstoque);
      Util.linha();
    }
  }
}