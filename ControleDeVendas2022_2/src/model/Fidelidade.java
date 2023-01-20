package model;

public class Fidelidade {
	
	private float desconto;
	private int compras_minimas;
	
	public Fidelidade(float desconto, int compras_minimas) {
		this.setDesconto(desconto);
		this.setCompras_minimas(compras_minimas);
	}

	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	public int getCompras_minimas() {
		return compras_minimas;
	}
	
	public void setCompras_minimas(int compras_minimas) {
		this.compras_minimas = compras_minimas;
	}

}
