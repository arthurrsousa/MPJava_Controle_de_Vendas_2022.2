package model;

public class Dados {
	private  Vendedor[] vendedor = new Vendedor[50];
	private int qtdVendedor = 0;
	private ClientePessoa[] clientesPes = new ClientePessoa[50];
	private int qtdClientesPes = 0;
	private ClienteEmpresa[] clientesEmp = new ClienteEmpresa[50];
	private int qtdClientesEmp = 0;
	private Produto[] produtos = new Produto[50];
	private int qtdProdutos = 0;
	

	/**
	 * Cria instancias da classe Cliente e Produto para auxiliar na apresentacao do software.
	 * 
	 */
	public void fillWithSomeData() {
		//Date d = Calendar.getInstance().getTime();
		for(int i = 0; i <= 4; i++) {
			clientesPes[i] = new ClientePessoa("Pessoa"+(i+1), (i+1)*123456, "Endereco"+(i+1),  (i+1)*112233);
			//clientesEmp[i] = new ClienteEmpresa("Empresa"+(i+1), "Endereco"+(i+1), (i+1)*123456, (i+1)*112233, 00, 00);
			produtos[i] = new Produto("Produto"+(i+1), " MarcaX", " Geral", 5*(i+1), 10*(i+1), " Bom e Barato");
		}
		
		setQtdClientesPes(getQtdClientesPes() + 1);
		setQtdClientesEmp(getQtdClientesEmp() + 1);
		setQtdProdutos(getQtdProdutos() + 1);
	}

	/**
	 * Altera os atributos de um Vendedor ou adiciona um novo(@param vend)
	 * 
	 */
	public void inserirEditarVendedor(Vendedor vend, int pos) {
		this.vendedor[pos] = vend;
		if(pos == qtdVendedor) qtdVendedor++;
	}
	
	/**
	 * Altera os atributos de um Cliente ou adiciona um novo (@param cli). 
	 */
	public void inserirEditarClientePessoa(ClientePessoa cli, int pos) {
		this.clientesPes[pos] = cli;
		if(pos == qtdClientesPes) qtdClientesPes++;
	}
	
	public void inserirEditarClienteEmpresa(ClienteEmpresa cli, int pos) {
		this.clientesEmp[pos] = cli;
		if(pos == qtdClientesEmp) qtdClientesEmp++;
	}
	
	/**
	 * Altera os atributos de um Produto ou adiciona um novo (@param p). 
	 */
	public void inserirEditarProduto(Produto p, int pos) {
		this.produtos[pos] = p;
		if(pos == qtdProdutos) qtdProdutos++;
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

	public Vendedor[] getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor[] vendedor) {
		this.vendedor = vendedor;
	}

	public int getQtdVendedor() {
		return qtdVendedor;
	}

	public void setQtdVendedor(int qtdVendedor) {
		this.qtdVendedor = qtdVendedor;
	}

	public ClientePessoa[] getClientePes() {
		return clientesPes;
	}

	public void setClientePes(ClientePessoa[] clientesPes) {
		this.clientesPes = clientesPes;
	}

	public int getQtdClientesPes() {
		return qtdClientesPes;
	}

	public void setQtdClientesPes(int qtdClientesPes) {
		this.qtdClientesPes = qtdClientesPes;
	}

	public ClienteEmpresa[] getClienteEmp() {
		return clientesEmp;
	}

	public void setClienteEmp(ClienteEmpresa[] clientesEmp) {
		this.clientesEmp = clientesEmp;
	}

	public int getQtdClientesEmp() {
		return qtdClientesEmp;
	}

	public void setQtdClientesEmp(int qtdClientesEmp) {
		this.qtdClientesEmp = qtdClientesEmp;
	}
	
	
	
	


}
