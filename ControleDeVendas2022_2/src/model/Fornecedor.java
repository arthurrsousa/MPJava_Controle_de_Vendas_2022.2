package model;

public class Fornecedor extends PessoaJuridica{

	private float valorEntrega;

	public Fornecedor(String n, int tel, String end, int cnpj, String ie, float entrega) {
		super(n, tel, end, cnpj, ie);
		this.setValorEntrega(entrega);
	}
	
	public boolean renovar_estoque(Estoque estoqueProd, int qtd, FluxoDeCaixa caixa) {
		double valorRenovacao = (estoqueProd.getProduto().getValorCompra()) * qtd + valorEntrega;
		try {
			if (valorRenovacao > caixa.getSaldo_atual()) {
				return false;
			}
			estoqueProd.setQtdAtual(estoqueProd.getQtdAtual() + qtd);
			
			caixa.setSaldo_atual(caixa.getSaldo_atual() - valorRenovacao - valorEntrega);
			caixa.setSaida_dinheiro(caixa.getSaida_dinheiro() - valorRenovacao - valorEntrega);
			
			System.out.println("Estoque Renovado");
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}

	public float getValorEntrega() {
		return valorEntrega;
	}

	public void setValorEntrega(float valorEntrega) {
		this.valorEntrega = valorEntrega;
	}
	
	
}
