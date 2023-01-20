package model;

public class Fornecedor extends PessoaJuridica{

	private Produto[] produtos;
	private float valorEntrega;

	public Fornecedor(String n, int tel, String end, int cnpj, String ie, int ra, Produto[] prods, float entrega) {
		super(n, tel, end, cnpj, ie, ra);
		this.setProdutos(prods);
		this.setValorEntrega(entrega);
	}


	public float getValorEntrega() {
		return valorEntrega;
	}

	public void setValorEntrega(float valorEntrega) {
		this.valorEntrega = valorEntrega;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	
	
}
