package model;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Carrinho {

	private Produto[] produtos;
	private int[] quantidades;
	//private double total;
	
	public double calcular_total(Imposto imposto) {
		
		double total = 0;
		for (int k = 0; k < produtos.length; k++) {
			total += produtos[k].getValorVenda() * quantidades[k];
		}
		
		total += (total * imposto.getValorImposto());
		return total;
	}
	
	public void finalizar_compra(FluxoDeCaixa caixa,Vendedor vendedor, Imposto imposto) {
		caixa.setSaldo_atual( caixa.getSaldo_atual() - this.calcular_total(imposto));
		caixa.setEntrada_dinheiro(caixa.getEntrada_dinheiro() + this.calcular_total(imposto));
		vendedor.setQuantidade_vendas(vendedor.getQuantidade_vendas() + 1);
		
		/*Random rand = new Random();
		
		Cliente comprador = d.getCliente()[pos];
		Vendedor vendedor = d.getVendedor();
		double valorTotal = 0;
		Date date = Calendar.getInstance().getTime();

		Recibo r = new Recibo(rand.nextInt(9999999)+100000, comprador, date, valorTotal, listaQtd, listaProd);

		
		for (int i = 0; i < 10; i++) {
			if (listaProd[i] != null) {
				valorTotal += (listaProd[i].getValor() * listaQtd[i]);
			}
		}
		
		int recPosicao = comprador.getQtdRecibos();
		Recibo r = new Recibo(rand.nextInt(9999999)+100000, comprador, date, valorTotal, listaQtd, listaProd);
		
		vendedor.setSaldo(vendedor.getSaldo() + valorTotal);
		vendedor.setQuantidade_vendas(vendedor.getQuantidade_vendas() + 1);

		comprador.setTotal_pago(comprador.getTotal_pago() + valorTotal);
		comprador.setCompras_realizadas(comprador.getCompras_realizadas() + 1);
		comprador.comprar(r, recPosicao);
		
		return true;*/
	}
	
	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	
	public Carrinho(Produto[] produtos) {
		this.setProdutos(produtos);
	}

	public int[] getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(int[] quantidades) {
		this.quantidades = quantidades;
	}

	/*public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}*/
	
}