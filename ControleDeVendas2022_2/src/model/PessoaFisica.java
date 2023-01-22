package model;

public abstract class PessoaFisica extends Pessoa{

	private int cpf;
	
	public PessoaFisica(String n, int tel, String end, int i) {
		super(n, tel, end);
		this.setCpf(i);
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int i) {
		this.cpf = i;
	}

}
