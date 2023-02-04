package model;

public class ClientePessoa extends PessoaFisica{

	private double total_pago;
	private int compras_realizadas;
	private Recibo[] recibos = new Recibo[20];
	private int qtdRecibos = 0;
	
	public ClientePessoa(String n, int tel, String end, int cpf, double totalPago, int totalCompras) {
		super(n, tel, end, cpf);
		this.setTotal_pago(totalPago);
		this.setCompras_realizadas(totalCompras);
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
	
	public void setRecibo(int i, Recibo rec) {
		this.recibos[i] = rec;
	}

	public int getQtdRecibos() {
		return qtdRecibos;
	}

	public void setQtdRecibos(int qtdRecibos) {
		this.qtdRecibos = qtdRecibos;
	}

	public double getTotal_pago() {
		return total_pago;
	}

	public void setTotal_pago(double total_pago) {
		this.total_pago = total_pago;
	}

	public int getCompras_realizadas() {
		return compras_realizadas;
	}

	public void setCompras_realizadas(int compras_realizadas) {
		this.compras_realizadas = compras_realizadas;
	}
}
