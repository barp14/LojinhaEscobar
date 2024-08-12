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
  public int getQtdEstoque() {
    return qtdEstoque;
  }
  public void setQtdEstoque(int qtdEstoque) {
    this.qtdEstoque = qtdEstoque;
  }

  public Float calcularValorTotal() {
    return this.preco * this.qtdEstoque;
  }

  public boolean buscarProdutoPorCodigo(String codigo) {
    return this.codigo.equals(codigo);
  }

  public void exibirInfoProduto() {
    System.out.println("Código: " + this.codigo);
    System.out.println("Nome: " + this.nome);
    System.out.println("Preço: " + this.preco);
    System.out.println("Quantidade em Estoque: " + this.qtdEstoque);
    System.out.println("Valor Total em Estoque: " + calcularValorTotal());
  }
}
