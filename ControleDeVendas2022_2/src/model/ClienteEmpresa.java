package model;

public class ClienteEmpresa extends PessoaJuridica{

	private Recibo[] recibos = new Recibo[20];
	private int qtdRecibos = 0;
	
	public ClienteEmpresa(String n, int tel, String end, int cnpj, String ie) {
		super(n, tel, end, cnpj, ie);
		// TODO Auto-generated constructor stub
	}
	
	public void comprar() {
		
	}

	public Recibo[] getRecibos() {
		return recibos;
	}

	public void setRecibos(Recibo[] recibos) {
		this.recibos = recibos;
	}

	public int getQtdRecibos() {
		return qtdRecibos;
	}

	public void setQtdRecibos(int qtdRecibos) {
		this.qtdRecibos = qtdRecibos;
	}

}
