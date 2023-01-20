package model;

public class Avaliacao {

	private String titulo;
	private String descricao;
	private int nota;
	private ClientePessoa cliente;
	
	public Avaliacao(String titulo, String descricao, int nota, ClientePessoa cliente) {
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setNota(nota);
		this.setCliente(cliente);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public ClientePessoa getCliente() {
		return cliente;
	}

	public void setCliente(ClientePessoa cliente) {
		this.cliente = cliente;
	}

}