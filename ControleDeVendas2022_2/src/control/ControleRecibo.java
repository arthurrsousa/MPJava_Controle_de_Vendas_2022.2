package control;

import model.*;


public class ControleRecibo {
	private Recibo[] rec;
	private int qtdRecibos;


	public ControleRecibo(ControleDados d, int cliIndex) {
		this.rec = d.getRecibo(cliIndex);
		this.qtdRecibos = d.getQtdRecibos(cliIndex);
	}


	public String[] getCodigoRec() {
		String[] s = new String[qtdRecibos];
		for(int i = 0; i < qtdRecibos; i++) {
			s[i] = String.valueOf(rec[i].getCodigo());
		}
		return s;
	}
	
	
	public int getQtd() {
		return qtdRecibos;
	}

	public void setQtd(int qtd) {
		this.qtdRecibos = qtd;
	}

	
	public String getCodigo(int i) {		
		return String.valueOf(rec[i].getCodigo());
	}

	public ClientePessoa getComprador(int i) {
		return rec[i].getCompradorFis();
	}

	public String getData(int i) {
		return String.valueOf(rec[i].getData());
	}

	public double getValor(int i) {
		return rec[i].getValor_total();
	}
	
	public Produto[] getProdutos (int i) {
		return rec[i].getProdutos();
	}
	
	public int[] getQtds (int i) {
		return rec[i].getQtd();
	}

}