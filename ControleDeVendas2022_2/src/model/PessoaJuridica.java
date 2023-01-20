package model;

public abstract class PessoaJuridica extends Pessoa{

	private int cnpj;
	private String insEstadual;
	private int ra;
	
	public PessoaJuridica(String n, int tel, String end, int cnpj, String ie, int ra) {
		super(n, tel, end);
		this.setCnpj(cnpj);
		this.setInsEstadual(ie);
		this.setRa(ra);
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

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

}
