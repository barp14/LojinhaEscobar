package Entidades;

public class Produto {
  public String codigo;
  private String nome;
  private Float preco;
  private int qtdEstoque;

  public Produto(String codigo, String nome, Float preco, int qtdEstoque) {
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
    this.qtdEstoque = qtdEstoque;
  }

  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public Float getPreco() {
    return preco;
  }
  public void setPreco(Float preco) {
    this.preco = preco;
  }
  public int getQtdEstoque()
  {
    return qtdEstoque;
  }
  public void setQtdEstoque(int qtdEstoque)
  {
    this.qtdEstoque = qtdEstoque;
  }
}
