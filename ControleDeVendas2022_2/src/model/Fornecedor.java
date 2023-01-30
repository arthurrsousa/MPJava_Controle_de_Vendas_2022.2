package model;

public class Fornecedor extends PessoaJuridica{

	private float valorEntrega;

	public Fornecedor(String n, int tel, String end, int cnpj, String ie, int ra, float entrega) {
		super(n, tel, end, cnpj, ie);
		this.setValorEntrega(entrega);
	}
	
	public void renovar_estoque(Estoque estoqueProd, int qtd, FluxoDeCaixa caixa) {
		estoqueProd.setQtdAtual(estoqueProd.getQtdAtual() + qtd);
		
		double valorRenovacao = (estoqueProd.getProduto().getValorCompra()) * qtd;
		
		caixa.setSaldo_atual(caixa.getSaldo_atual() - valorRenovacao - valorEntrega);
		caixa.setSaida_dinheiro(caixa.getSaida_dinheiro() - valorRenovacao - valorEntrega);
	}

	public float getValorEntrega() {
		return valorEntrega;
	}

	public void setValorEntrega(float valorEntrega) {
		this.valorEntrega = valorEntrega;
	}
	
	
}
