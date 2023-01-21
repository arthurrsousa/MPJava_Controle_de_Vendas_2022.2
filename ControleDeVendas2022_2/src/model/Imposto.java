package model;

public class Imposto {
	private double valorImposto;
	private double valorLiquido;
	
	public Imposto(double imposto, double liquido) {
		this.setValorImposto(imposto);
		this.setValorLiquido(liquido);
	}
	
	public double getValorImposto() {
		return valorImposto;
	}
	
	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}
	
	public double getValorLiquido() {
		return valorLiquido;
	}
	
	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	
}

