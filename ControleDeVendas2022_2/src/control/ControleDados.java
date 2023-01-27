package control;

import java.util.Random;
import java.util.Calendar;
import java.util.Date;

import model.*;
import modelo.Vendedor;	

/**
 * Classe ControleDados faz o gerenciamento dos dados das classes do sistema.
 * @author Arthur Rodrigues Sousa
 *
 */
public class ControleDados {
	private Dados d = new Dados();
	
	/**
	 * Construtor que injeta dados no sistema usando o metodo da classe Dados
	 */
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
		return d;
	}
	
	public void setDados(Dados d) {
		this.d = d;
	}

	
	public Vendedor[] getVendedor() {							
		return this.d.getVendedor();
	}
	
	public ClientePessoa[] getClientesPes() {							
		return this.d.getClientePes();
	}
	
	public int getQtdClientesPes() {
		return this.d.getQtdClientesPes();
	}
	
	public ClienteEmpresa[] getClienteEmp() {							
		return this.d.getClienteEmp();
	}
	
	public int getQtdClientes() {
		return this.d.getQtdClientesEmp();
	}
	
	public Produto[] getProduto() {
		return this.d.getProduto();
	}

	public int getQtdProdutos() {
		return this.d.getQtdProdutos();
	}
	
	public Fornecedor getFornecedor() {							
		return this.d.getFornecedor();
	}

	public int getQtdVendedor() {
		return this.d.getQtdVendedor();
	}
	
	public Recibo[] getRecibo(int cliIndex) {
		return this.d.getClientePes()[cliIndex].getRecibo();
	}
	
	public int getQtdRecibos(int cliIndex) {
		return this.d.getClientePes()[cliIndex].getQtdRecibos();
	}
	
	
	/**
	 * Confere se os dados do Vendedor que devem ser do tipo INTEIRO estao corretos
	 * retorna FALSO caso o dado fornecido não seja um inteiro
	 * e retorna TRUE caso seja e insere os novos dados do vendedor no sistema.
	 * @return boolean
	 */
	public boolean inserirEditarVendedor(String[] dadosVendedor) {
		if(!dadosVendedor[3].matches("[0-9]+") || !dadosVendedor[4].matches("[0-9]+") || !dadosVendedor[6].matches("[0-9]+")) {
			return false;
		} else {
		Vendedor vend = new Vendedor(dadosVendedor[1], dadosVendedor[2], (Integer.parseInt(dadosVendedor[3])), 
				(Integer.parseInt(dadosVendedor[4])), (Double.parseDouble(dadosVendedor[5])), (Integer.parseInt(dadosVendedor[6])));
		d.inserirEditarVendedor(vend);
		return true;
		}
	}
		
	/**
	 * Altera ou adiciona uma nova instancia de Produto no array de dados.
	 * dadosProd[0] representa o index do array de Produto que deve ser alterado
	 * @return boolean
	 */
	public boolean inserirEditarProduto(String[] dadosProd) {
		Produto p = new Produto(dadosProd[1], dadosProd[2], dadosProd[3], Double.parseDouble(dadosProd[4]), dadosProd[5]);
		d.inserirEditarProduto(p, Integer.parseInt(dadosProd[0]));
		return true;
	}
	
	/**
	 * Altera ou adiciona uma nova instancia de Cliente no array de dados.
	 * dadosCliente[0] representa o index do array de Cliente que deve ser alterado.
	 * Retorna TRUE caso os dados estejam corretos e insere os novos dados do cliente no sistema.
	 * @return boolean
	 */
	public boolean inserirEditarCliente(String[] dadosCliente) {
		if(!dadosCliente[3].matches("[0-9]+") || !dadosCliente[4].matches("[0-9]+") || !dadosCliente[6].matches("[0-9]+")) {
			return false;
		} else {
			Cliente c = new Cliente(dadosCliente[1], dadosCliente[2], (Integer.parseInt(dadosCliente[3])), 
						(Integer.parseInt(dadosCliente[4])), (Double.parseDouble(dadosCliente[5])), (Integer.parseInt(dadosCliente[6])));
				d.inserirEditarCliente(c, Integer.parseInt(dadosCliente[0]));
				return true;
		}
	}
	
	/**
	 * Exclui um produto do array de Dados e 
	 * diminui a quantidade de produtos no sistema
	 * (@param i) e o index do Produto a ser removido.
	 * retorna TRUE ao concluir a exclusao
	 * @return boolean
	 */
	public boolean removerProduto(int i) {
		String prodRemovido = d.getProduto()[i].getNome();

		if(i == (d.getQtdProdutos() - 1)) { // O prof a ser removido está no final do array
			d.setQtdProdutos(d.getQtdProdutos() - 1);
			d.getProduto()[d.getQtdProdutos()] = null;
			return true;
			
		} else { // o prod a ser removido está no meio do array
			int cont = 0;
			while(d.getProduto()[cont].getNome().compareTo(prodRemovido) != 0)
				cont++;
			
			//Rotina swap
			for(int j = cont; j < d.getQtdProdutos() - 1; j++) {
				d.getProduto()[j] = null;
				d.getProduto()[j] = d.getProduto()[j+1];
			}
			
			d.getProduto()[d.getQtdProdutos()] = null;
			d.setQtdProdutos(d.getQtdProdutos() - 1);
			return true;
		}
	}
	
	/**
	 * Exclui um cliente do array de Dados e 
	 * diminui a quantidade de clientes no sistema
	 * (@param i) e o index do Cliente a ser removido.
	 * retorna TRUE ao concluir a exclusao
	 * @return boolean
	 */
	public boolean removerCliente(int i) {
		String clienteRemovido = d.getCliente()[i].getNome();
		
		if(i == (d.getQtdClientes() - 1)) { // O Cliente a ser removido está no final do array
			d.setQtdClientes(d.getQtdClientes() - 1);
			d.getCliente()[d.getQtdClientes()] = null;
			return true;
		} else { // o Cliente a ser removido está no meio do array
			int cont = 0;
			while(d.getCliente()[cont].getNome().compareTo(clienteRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < d.getQtdClientes() - 1; j++) {
				d.getCliente()[j] = null;
				d.getCliente()[j] = d.getCliente()[j+1];
			}
			d.getCliente()[d.getQtdClientes()] = null;
			d.setQtdClientes(d.getQtdClientes() - 1);
			return true;
		}
	}
	
	/**
	 * Finaliza uma compra feita e altera os 
	 * dados de Vendedor e Cliente relacionados a compra.
	 * 
	 * Cria uma nova instancia de Recibo com as informacoes da venda realizada.
	 * 
	 * @param pos - index do Cliente que fez a compra.
	 * @param listaProd - lista de produtos que foram comprados.
	 * @param listaQtd - lista de quantidades dos produtos comprados.
	 * @return boolean
	 */
	public boolean finalizarCompra(int pos, Produto[] listaProd, int[] listaQtd) {
		Random rand = new Random();
		Cliente comprador = d.getCliente()[pos];
		Vendedor vendedor = d.getVendedor();
		double valorTotal = 0;
		Date date = Calendar.getInstance().getTime();
		
		for (int i = 0; i < 10; i++) {
			if (listaProd[i] != null) {
				valorTotal += (listaProd[i].getValor() * listaQtd[i]);
			}
		}
		
		int recPosicao = comprador.getQtdRecibos();
		Recibo r = new Recibo(rand.nextInt(9999999)+100000, comprador, date, valorTotal, listaQtd, listaProd);
		
		vendedor.setSaldo(vendedor.getSaldo() + valorTotal);
		vendedor.setQtd_vendas(vendedor.getQtd_vendas() + 1);

		comprador.setTotal_pago(comprador.getTotal_pago() + valorTotal);
		comprador.setCompras_realizadas(comprador.getCompras_realizadas() + 1);
		comprador.comprar(r, recPosicao);
		
		return true;
		
	}
}