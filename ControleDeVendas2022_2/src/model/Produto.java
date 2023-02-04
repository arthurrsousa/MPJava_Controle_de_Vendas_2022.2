package model;

public class Produto {

	private String nome;
	private String marca;
	private String categoria;
	private float valorVenda;
	private float valorCompra;
	private String descricao;
	
	public Produto(String nom, String mar, String cat, float vVenda, float vCompra, String des) {
		this.setNome(nom);
		this.setMarca(mar);
		this.setCategoria(cat);
		this.setValorVenda(vVenda);
		this.setValorCompra(vCompra);
		this.setDescricao(des);
	}
	
	
	public String toString() {	
		return "Nome do produto: " + nome +
				"\n" + descricao +
				 "\n Valor: R$" + valorCompra + "\n";
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getMarca() {
		return marca;
	}
	
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public double getValorVenda() {
		return valorVenda;
	}
	
	
	public void setValorVenda(float vVenda) {
		this.valorCompra = vVenda;
	}
	
	public double getValorCompra() {
		return valorCompra;
	}
	
	
	public void setValorCompra(float vCompra) {
		this.valorCompra = vCompra;
	}
}
