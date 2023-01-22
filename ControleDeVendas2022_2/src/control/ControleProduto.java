package controle;

import modelo.*;

/**
 * Classe ControleProduto faz o gerenciamento dos dados da classe Produto.
 * @author Arthur Rodrigues Sousa
 *
 */
public class ControleProduto {
	private Produto[] p;
	private int qtdProds;

	/**
	 * Construtor da classe que recebe os dados (@param d) dos produtos gerados pela classe Dados.
	 */
	public ControleProduto(ControleDados d) {
		this.p = d.getProduto();
		this.qtdProds = d.getQtdProdutos();
	}

	/**
	 * retorna o nome dos produtos cadastrados no sistema.
	 * @return String[]
	 */
	public String[] getNomeProd() {
		String[] s = new String[qtdProds];
		for(int i = 0; i < qtdProds; i++) {
			s[i] = this.p[i].getNome();
		}

		return s;
	}
	
	public int getQtd() {
		return qtdProds;
	}

	public void setQtd(int qtd) {
		this.qtdProds = qtd;
	}
	

	public String getNome(int i) {		
		return p[i].getNome();
	}

	public String getMarca(int i) {
		return p[i].getMarca();
	}

	public String getCateg(int i) {
		return p[i].getCategoria();
	}

	public double getValor(int i) {
		return p[i].getValor();
	}
	
	public String getDesc (int i) {
		return p[i].getDescricao();
	}

	public void setQtdProds(int qtdProds) {
		this.qtdProds = qtdProds;
	}
}
