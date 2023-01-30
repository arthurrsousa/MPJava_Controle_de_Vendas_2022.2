package model;

public abstract class PessoaJuridica extends Pessoa{

	private int cnpj;
	private String insEstadual;
	
	public PessoaJuridica(String n, int tel, String end, int cnpj, String ie) {
		super(n, tel, end);
		this.setCnpj(cnpj);
		this.setInsEstadual(ie);
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getInsEstadual() {
		return insEstadual;
	}

	public void setInsEstadual(String insEstadual) {
		this.insEstadual = insEstadual;
	}

}
