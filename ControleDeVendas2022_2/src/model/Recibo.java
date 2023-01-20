package model;

public class Recibo {
	private Produto[] produtos;
	private String data;
	private int codigo;
	private float valor_total;
	private String cpf_cnpj;


	public Recibo(Produto[] prods, String data, int codigo, float total, String cpf_cnpj) {
		this.setProdutos(prods);
		this.setData(data);
		this.setCodigo(codigo);
		this.setValor_total(total);
		this.setCpf_cnpj(cpf_cnpj);
		}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getValor_total() {
		return valor_total;
	}

	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
}
