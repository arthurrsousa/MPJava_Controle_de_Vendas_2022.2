package control;

import model.*;


public class ControleCliente {
	private Cliente[] cli;
	private int qtdClientes;

	public ControleCliente(ControleDados d) {
		this.cli = d.getCliente();
		this.qtdClientes = d.getQtdClientes();
	}

	public String[] getNomeCliente() {
		String[] s = new String[qtdClientes];
		for(int i = 0; i < qtdClientes; i++) {
			s[i] = cli[i].getNome();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdClientes;
	}

	public void setQtd(int qtd) {
		this.qtdClientes = qtd;
	}

	public String getNome(int i) {		
		return cli[i].getNome();
	}

	public String getCPF(int i) {
		String numCPF = String.valueOf(cli[i].getCpf());
		return numCPF;
	}

	public String getEndereco(int i) {
		return cli[i].getEndereco();
	}

	public String getTelefone(int i) {
		String numTel = String.valueOf(cli[i].getTelefone());
		return numTel;
	}
	
	public double getTotalPago (int i) {
		return cli[i].getTotal_pago();
	}
	
	public String getTotalCompras (int i) {
		String numCompras = String.valueOf(cli[i].getCompras_realizadas());
		return numCompras;
	}

}