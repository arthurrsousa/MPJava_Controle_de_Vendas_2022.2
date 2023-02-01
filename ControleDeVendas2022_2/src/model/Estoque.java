package model;

public class Estoque {
	private Produto produto;
	private int qtdAtual;
	private int qtdMinima;
	private int qtdCompras;


	public Estoque(Produto produto, int atual, int min, int compras) {
	this.setProduto(produto);
	this.setQtdAtual(atual);
	this.setQtdMinima(min);
	this.setQtdCompras(compras);
	}


	public int getQtdAtual() {
		return qtdAtual;
	}


	public void setQtdAtual(int qtdAtual) {
		this.qtdAtual = qtdAtual;
	}


	public int getQtdMinima() {
		return qtdMinima;
	}


	public void setQtdMinima(int qtdMinima) {
		this.qtdMinima = qtdMinima;
	}


	public int getQtdCompras() {
		return qtdCompras;
	}


	public void setQtdCompras(int qtdCompras) {
		this.qtdCompras = qtdCompras;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}