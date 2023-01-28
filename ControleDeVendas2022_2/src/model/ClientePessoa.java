package model;

public class ClientePessoa extends PessoaFisica{

	private Recibo[] recibos = new Recibo[20];
	private int qtdRecibos = 0;
	
	public ClientePessoa(String n, int tel, String end, int cpf) {
		super(n, tel, end, cpf);
		// TODO Auto-generated constructor stub
	}

	public void comprar() {
		
	}

	public Recibo[] getRecibo() {
		return recibos;
	}

	public void setRecibo(Recibo[] recibos) {
		this.recibos = recibos;
	}

	public int getQtdRecibos() {
		return qtdRecibos;
	}

	public void setQtdRecibos(int qtdRecibos) {
		this.qtdRecibos = qtdRecibos;
	}
}
