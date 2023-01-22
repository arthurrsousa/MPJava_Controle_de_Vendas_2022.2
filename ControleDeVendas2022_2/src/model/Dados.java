package model;

import model.Cliente;
import model.Produto;
import model.Vendedor;

public class Dados {
	private  Vendedor vendedor = new Vendedor("Arthur", "Endereco0", 1000, 55123, 10000.0, 00);
	private Cliente[] clientes = new Cliente[50];
	private int qtdClientes = 0;
	private Produto[] produtos = new Produto[50];
	private int qtdProdutos = 0;

	/**
	 * Cria instancias da classe Cliente e Produto para auxiliar na apresentacao do software.
	 */
	public void fillWithSomeData() {
		//Date d = Calendar.getInstance().getTime();
		for(int i = 0; i <= 4; i++) {
			clientes[i] = new Cliente("Cliente"+(i+1), "Endereco"+(i+1), (i+1)*123456, (i+1)*112233, 00, 00);
			produtos[i] = new Produto("Produto"+(i+1), " MarcaX", " Geral", 10*(i+1), " Bom e Barato");	
		}
		
		setQtdClientes(5);
		setQtdProdutos(5);
	}

	/**
	 * Altera os atributos do Vendedor (@param vend)
	 * 
	 */
	public void inserirEditarVendedor(Vendedor vend) {
		this.vendedor = vend;
	}
	
	/**
	 * Altera os atributos de um Cliente ou adiciona um novo (@param cli). 
	 */
	public void inserirEditarCliente(Cliente cli, int pos) {
		this.clientes[pos] = cli;
		if(pos == qtdClientes) qtdClientes++;
	}
	
	/**
	 * Altera os atributos de um Produto ou adiciona um novo (@param p). 
	 */
	public void inserirEditarProduto(Produto p, int pos) {
		this.produtos[pos] = p;
		if(pos == qtdProdutos) qtdProdutos++;
	}
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vend) {
		this.vendedor = vend;
	}

	
	public Cliente[] getCliente() {
		return clientes;
	}
	
	public void setClientes(Cliente[] cli) {
		this.clientes = cli;
	}
	
	
	public int getQtdClientes() {
		return qtdClientes;
	}
	
	public void setQtdClientes(int qtdClientes) {
		this.qtdClientes = qtdClientes;
	}
	
	
	public Produto[] getProduto() {
		return produtos;
	}
	
	public void setProduto(Produto[] prods) {
		this.produtos = prods;
	}
	
	
	public int getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	
	
	
	
	


}
