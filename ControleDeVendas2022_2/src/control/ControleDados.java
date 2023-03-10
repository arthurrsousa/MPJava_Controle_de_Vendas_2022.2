package control;

import java.util.Random;
import java.util.Calendar;
import java.util.Date;

import model.*;

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
	
	public int getQtdVendedor() {
		return this.d.getQtdVendedor();
	}
	
	public ClientePessoa[] getClientePes() {							
		return this.d.getClientePes();
	}
	
	public int getQtdClientePes() {
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
	public Estoque[] getEstoques() {
		return this.d.getEstoques();
	}

	public int getQtdProdutos() {
		return this.d.getQtdProdutos();
	}
	
	public Fornecedor getFornecedor() {							
		return this.d.getFornecedor();
	}
	
	public Recibo[] getRecibo(int cliIndex) {
		return this.d.getClientePes()[cliIndex].getRecibo();
	}
	
	public int getQtdRecibos(int cliIndex) {
		return this.d.getClientePes()[cliIndex].getQtdRecibos();
	}
	
	public FluxoDeCaixa getFluxoDeCaixa() {						
		return this.d.getFluxoDeCaixa();
	}
	
	public Carrinho getCarrinho() {
		return this.d.getCarrinho();
	}
	
	public Imposto getImposto() {
		return this.d.getImposto();
	}
	
	public Desconto getDesconto() {
		return this.d.getDesconto();
	}
	
	/**
	 * Confere se os dados do Vendedor que devem ser do tipo INTEIRO estao corretos
	 * retorna FALSO caso o dado fornecido n�o seja um inteiro
	 * e retorna TRUE caso seja e insere os novos dados do vendedor no sistema.
	 * @return boolean
	 */
	public boolean inserirEditarVendedor(String[] dadosVendedor) {
		if(!dadosVendedor[2].matches("[0-9]+") || !dadosVendedor[4].matches("[0-9]+") || !dadosVendedor[5].matches("[0-9]+")) {
			return false;
		} else {
		Vendedor vend = new Vendedor(dadosVendedor[1], (Integer.parseInt(dadosVendedor[2])), dadosVendedor[3], 
				(Integer.parseInt(dadosVendedor[4])), (Integer.parseInt(dadosVendedor[5])), (Float.parseFloat(dadosVendedor[6])));
		d.inserirEditarVendedor(vend, Integer.parseInt(dadosVendedor[0]));
		System.out.println(dadosVendedor[0]);
		return true;
		}
	}
		
	/**
	 * Altera ou adiciona uma nova instancia de Produto no array de dados.
	 * dadosProd[0] representa o index do array de Produto que deve ser alterado
	 * @return boolean
	 */
	public boolean inserirEditarProduto(String[] dadosProd) {
		System.out.println("criando produto");
		Produto p = new Produto(dadosProd[1], dadosProd[2], dadosProd[3], Float.parseFloat(dadosProd[4]), Float.parseFloat(dadosProd[5]), dadosProd[6] );
		System.out.println(p.getNome());
		System.out.println("produto criado");
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
		ClientePessoa c = new ClientePessoa(dadosCliente[1], (Integer.parseInt(dadosCliente[3])), dadosCliente[2], 
						(Integer.parseInt(dadosCliente[4])), (Double.parseDouble(dadosCliente[5])), (Integer.parseInt(dadosCliente[6])));
				d.inserirEditarClientePessoa(c, Integer.parseInt(dadosCliente[0]));
				return true;
	}
	
	/**
	 * Altera ou adiciona uma nova instancia do fluxo no array de dados.
	 * dadosCliente[0] representa o index do array de fluxo que deve ser alterado.
	 * 
	 * @return boolean
	 */
	public boolean inserirEditarFluxoDeCaixa(String[] dadosFluxo) {
		FluxoDeCaixa caixa = new FluxoDeCaixa((Double.parseDouble(dadosFluxo[1])), (Double.parseDouble(dadosFluxo[2])), (Double.parseDouble(dadosFluxo[3])));
		d.inserirEditarFluxoDeCaixa(caixa);
		return true;
	}
	
	/**
	 * Exclui um produto do array de Dados e 
	 * diminui a quantidade de produtos no sistema
	 * (@param i) e o index do Produto a ser removido.
	 * retorna TRUE ao concluir a exclusao
	 * 
	 * @return boolean
	 */
	public boolean removerProduto(int i) {
		String prodRemovido = d.getProduto()[i].getNome();
		
		if(i == (d.getQtdProdutos() - 1)) { // O prof a ser removido está no final do array
			d.setQtdProdutos(d.getQtdProdutos() - 1);
			d.getProduto()[d.getQtdProdutos()] = null;
			d.getEstoques()[d.getQtdProdutos()]= null;
			return true;
			
		} else { // o prod a ser removido está no meio do array
			int cont = 0;
			while(d.getProduto()[cont].getNome().compareTo(prodRemovido) != 0)
				cont++;
			
			//Rotina swap
			for(int j = cont; j < d.getQtdProdutos() - 1; j++) {
				d.getProduto()[j] = null;
				d.getProduto()[j] = d.getProduto()[j+1];
				d.getEstoques()[j] = null;
				d.getEstoques()[j] = d.getEstoques()[j+1];
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
		String clienteRemovido = d.getClientePes()[i].getNome();
		
		if(i == (d.getQtdClientesPes() - 1)) { // O Cliente a ser removido est� no final do array
			d.setQtdClientesPes(d.getQtdClientesPes() - 1);
			d.getClientePes()[d.getQtdClientesPes()] = null;
			return true;
		} else { // o Cliente a ser removido est� no meio do array
			int cont = 0;
			while(d.getClientePes()[cont].getNome().compareTo(clienteRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < d.getQtdClientesPes() - 1; j++) {
				d.getClientePes()[j] = null;
				d.getClientePes()[j] = d.getClientePes()[j+1];
			}
			d.getClientePes()[d.getQtdClientesPes()] = null;
			d.setQtdClientesPes(d.getQtdClientesPes() - 1);
			return true;
		}
	}
	/**
	 * Exclui um Vendedor do array de Dados e 
	 * diminui a quantidade de vendedores no sistema
	 * (@param i) e o index do Vendedor a ser removido.
	 * retorna TRUE ao concluir a exclusao
	 * @return boolean
	 */
	public boolean removerVendedor(int i) {
		String vendedorRemovido = d.getVendedor()[i].getNome();
		
		if(i == (d.getQtdVendedor() - 1)) { // O Vendedor a ser removido est� no final do array
			d.setQtdVendedor(d.getQtdVendedor() - 1);
			d.getVendedor()[d.getQtdVendedor()] = null;
			return true;
		} else { // o Cliente a ser removido est� no meio do array
			int cont = 0;
			while(d.getVendedor()[cont].getNome().compareTo(vendedorRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < d.getQtdVendedor() - 1; j++) {
				d.getVendedor()[j] = null;
				d.getVendedor()[j] = d.getVendedor()[j+1];
			}
			d.getVendedor()[d.getQtdVendedor()] = null;
			d.setQtdVendedor(d.getQtdVendedor() - 1);
			return true;
		}
	}
	
	public void removerDoCarrinho(int j) {
		// TODO Auto-generated method stub
		
	}

}


