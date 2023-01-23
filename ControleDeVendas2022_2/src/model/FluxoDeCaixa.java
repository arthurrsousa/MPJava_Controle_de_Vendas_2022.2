package model;

public class FluxoDeCaixa {
	private double saldo_atual;
	private double saida_dinheiro;
	private double entrada_dinheiro;
	
	public FluxoDeCaixa(double saldo_atual, double saida_dinheiro, double entrada_dinheiro) {
		this.saldo_atual = saldo_atual;
		this.saida_dinheiro = saida_dinheiro;
		this.entrada_dinheiro = entrada_dinheiro;
	}
	
	/*
	public void fluxo_entrada() {
		
	}
	
	public void fluxo_saida() {
		
	}*/
	
	public void saldo() {
		
	}
	
	public double getSaldo_atual() {
		return saldo_atual;
	}
	
	public void setSaldo_atual(double d) {
		this.saldo_atual = d;
	}
	
	public double getSaida_dinheiro() {
		return saida_dinheiro;
	}
	
	public void setSaida_dinheiro(double d) {
		this.saida_dinheiro = d;
	}
	
	public double getEntrada_dinheiro() {
		return entrada_dinheiro;
	}
	
	public void setEntrada_dinheiro(double d) {
		this.entrada_dinheiro = d;
	}
	
}
