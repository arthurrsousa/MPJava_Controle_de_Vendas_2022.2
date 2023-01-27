package control;

import model.*;


public class ControleVendedor {
	private Vendedor[] vend;
	private int qtdVendedor;

	public ControleVendedor(ControleDados d) {
		this.vend = d.getVendedor();
		this.qtdVendedor = d.getQtdVendedor();
	}

	public String[] getNomeVendedor() {
		String[] s = new String[qtdVendedor];
		for(int i = 0; i < qtdVendedor; i++) {
			s[i] = vend[i].getNome();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdVendedor;
	}

	public void setQtd(int qtd) {
		this.qtdVendedor = qtd;
	}

	public String getNome(int i) {		
		return vend[i].getNome();
	}

	public String getCPF(int i) {
		String numCPF = String.valueOf(vend[i].getCpf());
		return numCPF;
	}

	public String getEndereco(int i) {
		return vend[i].getEndereco();
	}

	public String getTelefone(int i) {
		String numTel = String.valueOf(vend[i].getTelefone());
		return numTel;
	}
	
	public int getQuantidadeVendas(int i){
		return vend[i].getQuantidade_vendas();
		
		}
	
	public float getValorVendas(int i){
		return vend[i].getValor_vendas();
		
		}
	
	}