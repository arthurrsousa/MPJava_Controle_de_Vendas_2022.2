package model;

public class ClienteEmpresa extends PessoaJuridica{

	private double total_pago;
	private int compras_realizadas;
	private Recibo[] recibos = new Recibo[20];
	private int qtdRecibos = 0;
	
	public ClienteEmpresa(String n, int tel, String end, int cnpj, String ie, double totalPago, int totalCompras) {
		super(n, tel, end, cnpj, ie);
		this.setTotal_pago(totalPago);
		this.setCompras_realizadas(totalCompras);
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
