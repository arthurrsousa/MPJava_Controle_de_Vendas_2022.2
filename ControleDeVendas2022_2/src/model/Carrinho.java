package model;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import control.Cliente;
import control.ControleDados;

public class Carrinho {

	private Produto[] produtos;
	private int[] quantidades;
	private int qtdItens;
	private double total;
	
	public Carrinho(Produto[] listaProds, int[] listaQtd, int i) {
		this.produtos = (listaProds);
		this.setQuantidades(listaQtd);
		this.setQtdItens(i);
	}
	

	public void calcularTotal(Imposto imposto) {
		for (int i = 0; i < 20; i++) {
			if (produtos[i] != null) {
				total += (produtos[i].getValorCompra() * quantidades[i]);
				//System.out.println(produtos[i].getValorVenda());
				//System.out.println(produtos[i].getValorCompra());
				System.out.println("valor total: " + total);
			}
		}
		
		this.setTotal(this.getTotal() + (total * imposto.getValorImposto()));
	}
	
	public boolean finalizarCompra(int posicao, ControleDados d) {
		Random rand = new Random();
		ClientePessoa comprador = d.getClientePes()[posicao];
		FluxoDeCaixa fluxo = d.getFluxoDeCaixa();
		Date date = Calendar.getInstance().getTime();
		
		calcularTotal(d.getImposto());
		
		int recPosicao = comprador.getQtdRecibos();
		Recibo r = new Recibo(rand.nextInt(9999999)+100000, comprador, date, total, quantidades, produtos);
		System.out.println("valor do recibo: " + r.getValor_total());
		
		fluxo.setSaldo_atual(fluxo.getSaldo_atual() + total);

		comprador.setRecibo(comprador.getQtdRecibos(), r);
		comprador.setTotal_pago(comprador.getTotal_pago() + total);
		comprador.setCompras_realizadas(comprador.getCompras_realizadas() + 1);
		
		return true;
		
	}
	
	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProduto(Produto prod , int i) {
		this.produtos[i] = prod;
	}

	public int[] getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(int[] quantidades) {
		this.quantidades = quantidades;
	}

	public void setQuantidade(int quantidade, int i) {
		this.quantidades[i] = quantidade;
	}
	
	public int getQtdItens() {
		return qtdItens;
	}
	
	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}