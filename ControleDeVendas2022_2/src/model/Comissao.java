package model;

public class Comissao {
	private float procentagem;
	
	public Comissao(float porcent) {
		this.setProcentagem(porcent);
	}
	
	public void calcularComissao() {
		
	}

	public float getProcentagem() {
		return procentagem;
	}

	public void setProcentagem(float procentagem) {
		this.procentagem = procentagem;
	}
}
