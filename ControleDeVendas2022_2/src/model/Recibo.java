package model;

import java.util.Date;

public class Recibo {
	private int codigo;
	private ClientePessoa compradorFis;
	private ClienteEmpresa compradorJur;
	private Date data;
	private double valor_total;
	private int[] qtd;
	private Produto[] produtos;
	

	public Recibo(int cod, ClientePessoa cli, Date dt, double vt, int[] qtd, Produto[] prods) {
		this.setCodigo(cod);
		this.setCompradorFis(cli);
		this.setData(dt);
		this.setValor_total(vt);
		this.setQtd(qtd);
		this.setProdutos(prods);
	}
	
	public Recibo(int cod, ClienteEmpresa cli, Date dt, double vt, int[] qtd, Produto[] prods) {
		this.setCodigo(cod);
		this.setCompradorJur(cli);
		this.setData(dt);
		this.setValor_total(vt);
		this.setQtd(qtd);
		this.setProdutos(prods);
	}
	
	
	public String getCodigo() {
		return String.valueOf(codigo);
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public String getData() {
		return String.valueOf(data);
	}
	
	
	public void setData(Date data) {
		this.data = data;
	}
	
	
	public double getValor_total() {
		return valor_total;
	}
	
	
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	
	public int[] getQtd() {
		return qtd;
	}

	
	public void setQtd(int[] qtd) {
		this.qtd = qtd;
	}
	

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	public ClientePessoa getCompradorFis() {
		return compradorFis;
	}

	public void setCompradorFis(ClientePessoa compradorFis) {
		this.compradorFis = compradorFis;
	}

	public ClienteEmpresa getCompradorJur() {
		return compradorJur;
	}

	public void setCompradorJur(ClienteEmpresa compradorJur) {
		this.compradorJur = compradorJur;
	}

	
	
}

