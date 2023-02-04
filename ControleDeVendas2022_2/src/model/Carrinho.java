package model;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;

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
	
	/**
	 * Finaliza uma compra feita e altera os 
	 * dados de FluxoDeCaixa e Cliente relacionados a compra.
	 * 
	 * Cria uma nova instancia de Recibo com as informacoes da venda realizada.
	 * 
	 * @param posicao - index do Cliente que fez a compra.
	 * @return boolean
	 */
	public boolean finalizarCompra(int posicao, ControleDados d) {
		Random rand = new Random();
		ClientePessoa comprador = d.getClientePes()[posicao];
		FluxoDeCaixa fluxo = d.getFluxoDeCaixa();
		Date date = Calendar.getInstance().getTime();
		
		calcularTotal(d.getImposto());
		
		int recPosicao = comprador.getQtdRecibos();
		Recibo r = new Recibo(rand.nextInt(9999999)+100000, comprador, date, total, quantidades, produtos);
		
		fluxo.setSaldo_atual(fluxo.getSaldo_atual() + total);

		comprador.setRecibo(comprador.getQtdRecibos(), r);
		comprador.setQtdRecibos(comprador.getQtdRecibos() + 1);
		comprador.setTotal_pago(comprador.getTotal_pago() + total);
		comprador.setCompras_realizadas(comprador.getCompras_realizadas() + 1);
		
		System.out.println("nome do recibo do Comprador: "
				+ comprador.getNome()
				+ "\n valor total: "
				+ r.getValor_total());
		return true;
	}
	
	public boolean removerDoCarrinho(int pos, JButton[] botaoRemover) {
		qtdItens = 0;
		int i = 0;
		while (i < produtos.length) {
			if (produtos[i] != null) {
				qtdItens++;
			}
			i++;
		}
		
		if(pos == (qtdItens - 1)) { // O Item a ser removido est� no final do array
			produtos[qtdItens - 1] = null;
			quantidades[pos] = 0;
			botaoRemover[pos] = null;
			return true;
			
		} else { // o item a ser removido est� no meio do array
			//Rotina swap
			for(int j = pos; j < qtdItens - 1; j++) {
				produtos[j] = null;
				produtos[j] = produtos[j+1];
				quantidades[j] = 0;
				quantidades[j] = quantidades[j+1];
				botaoRemover[j] = null;
				botaoRemover[j] = botaoRemover[j+1];
			}
			
			produtos[qtdItens - 1] = null;
			
			//Zera o carrinho
			produtos = new Produto[20];
			quantidades = new int[20];
			qtdItens = 0;
			total = 0;
			
			return true;
		}
		
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