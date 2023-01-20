package model;

public abstract class Pessoa {
	private String nome;
	private int telefone;
	private String endereco;
	
	public Pessoa(String n, int tel, String end) {
		this.setNome(n);
		this.setTelefone(tel);
		this.setEndereco(end);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
