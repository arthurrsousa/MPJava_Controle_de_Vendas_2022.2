package model;

public abstract class PessoaFisica extends Pessoa{

	private String cpf;
	
	public PessoaFisica(String n, int tel, String end, String cpf) {
		super(n, tel, end);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
