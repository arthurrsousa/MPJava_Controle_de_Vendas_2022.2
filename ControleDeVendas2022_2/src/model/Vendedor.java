package model;

public class Vendedor extends PessoaFisica {

	private int quantidade_vendas;
	private float valor_vendas;
	
	public Vendedor(String n, int tel, String end, String cpf, int qtdVendas, float vVendas) {
		super(n, tel, end, cpf);
		this.setQuantidade_vendas(qtdVendas);
		this.setValor_vendas(vVendas);
	}
	
	public int getQuantidade_vendas() {
		return quantidade_vendas;
	}
	
	public void setQuantidade_vendas(int quantidade_vendas) {
		this.quantidade_vendas = quantidade_vendas;
	}
	
	public float getValor_vendas() {
		return valor_vendas;
	}
	
	public void setValor_vendas(float valor_vendas) {
		this.valor_vendas = valor_vendas;
	}

	

}
