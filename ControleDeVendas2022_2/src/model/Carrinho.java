package model;

public class Carrinho {

	private Produto[] produtos;
	
	public void calcular_total() {
		
	}
	
	public void finalizar_compra() {
		
	}
	
	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	
	public Carrinho(Produto[] produtos) {
		this.setProdutos(produtos);
	}
	
}