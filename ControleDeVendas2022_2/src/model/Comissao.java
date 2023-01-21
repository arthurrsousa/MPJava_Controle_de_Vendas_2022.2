package model;

public class Comissao {
	private Vendedor vendedor;
	private double procentagem;
	private double valor;
	
	public Comissao(Vendedor vendedor, double porcent, double valor) {
		this.setVendedor(vendedor);
		this.setProcentagem(porcent);
		this.setValor(valor);
	}
	
	public void calcularComissao() {
		
	}

	public double getProcentagem() {
		return procentagem;
	}

	public void setProcentagem(double procentagem) {
		this.procentagem = procentagem;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
