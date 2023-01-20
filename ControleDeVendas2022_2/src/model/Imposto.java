package model;

public class Imposto {
	private float valorImporto;
	private float valorLiquido;
	private float aliquota;
	
	
	public Imposto(float imposto, float liquido, float aliq) {
		this.setValorImporto(imposto);
		this.setValorLiquido(liquido);
		this.setAliquota(aliq);
	}
	
	public float getValorImporto() {
		return valorImporto;
	}
	
	public void setValorImporto(float valorImporto) {
		this.valorImporto = valorImporto;
	}
	
	public float getValorLiquido() {
		return valorLiquido;
	}
	
	public void setValorLiquido(float valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	
	public float getAliquota() {
		return aliquota;
	}
	
	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}
}

