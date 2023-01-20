package model;

public class FluxoDeCaixa {
	private int saldo_atual;
	private int saida_dinheiro;
	private int entrada_dinheiro;
	
	public FluxoDeCaixa(int saldo_atual, int saida_dinheiro,int entrada_dinheiro) {
		this.saldo_atual = saldo_atual;
		this.saida_dinheiro = saida_dinheiro;
		this.entrada_dinheiro = entrada_dinheiro;
	}
	
	public void fluxo_entrada() {
		
	}
	
	public void fluxo_saida() {
		
	}
	
	public void saldo() {
		
	}
	
	public int getSaldo_atual() {
		return saldo_atual;
	}
	
	public void setSaldo_atual(int saldo_atual) {
		this.saldo_atual = saldo_atual;
	}
	
	public int getSaida_dinheiro() {
		return saida_dinheiro;
	}
	
	public void setSaida_dinheiro(int saida_dinheiro) {
		this.saida_dinheiro = saida_dinheiro;
	}
	
	public int getEntrada_dinheiro() {
		return entrada_dinheiro;
	}
	
	public void setEntrada_dinheiro(int entrada_dinheiro) {
		this.entrada_dinheiro = entrada_dinheiro;
	}
	
}
