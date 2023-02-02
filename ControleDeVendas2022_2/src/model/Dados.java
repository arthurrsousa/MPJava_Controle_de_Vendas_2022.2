package model;

public class Dados {
	private FluxoDeCaixa fluxoDeCaixa = new FluxoDeCaixa(10000, 0, 0);
	private Vendedor[] vendedor = new Vendedor[50];
	private int qtdVendedor = 0;
	private ClientePessoa[] clientesPes = new ClientePessoa[50];
	private int qtdClientesPes = 0;
	private ClienteEmpresa[] clientesEmp = new ClienteEmpresa[50];
	private int qtdClientesEmp = 0;
	private Produto[] produtos = new Produto[50];
	private int qtdProdutos = 0;
	private Estoque[] estoques = new Estoque[50];
	private Carrinho carrinho = new Carrinho(null);
	private Fornecedor fornecedor = new Fornecedor("Apple", 619122134, "China", 1221588, "inscricao estadual", 150);
	
	private Recibo[] recibosTeste = new Recibo[50];
	
	/**
	 * Cria instancias de diversas classes do Modelo para auxiliar na apresentacao do software.
	 * 
	 */
	public void fillWithSomeData() {
		//Date d = Calendar.getInstance().getTime();
		recibosTeste[0] = new Recibo(qtdClientesEmp, null, null, qtdClientesEmp, null, produtos);
		
		for(int i = 0; i <= 10; i++) {
			vendedor[i] = new Vendedor("Vendedor"+(i+1), (i+1)*123456, "Endereco"+(i+1),  (i+1)*112233, 0, 0);
			clientesPes[i] = new ClientePessoa("Pessoa"+(i+1), (i+1)*123456, "Endereco"+(i+1),  (i+1)*112233, 0, 0);
			clientesPes[i].setRecibo(recibosTeste);
			produtos[i] = new Produto("Produto"+(i+1), " Apple", " Eletronicos", 5*(i+1), 10*(i+1), " Bom e Barato");
			estoques[i] = new Estoque(produtos[i], 50, 15, 0);
	

			//talvez isso de problema (tirar do loop)
			setQtdVendedor(getQtdVendedor() + 1);
			setQtdClientesPes(getQtdClientesPes() + 1);
			setQtdClientesEmp(getQtdClientesEmp() + 1);
			setQtdProdutos(getQtdProdutos() + 1);
		}
		
	}

	public void inserirEditarFluxoDeCaixa(FluxoDeCaixa caixa) {
		this.fluxoDeCaixa = caixa;
	}

	public void inserirEditarFornecedor(Fornecedor forn) {
		this.fornecedor = forn;
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
		this.estoques[pos].setProduto(p);
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

	public FluxoDeCaixa getFluxoDeCaixa() {
		return fluxoDeCaixa;
	}

	public void setFluxoDeCaixa(FluxoDeCaixa fluxoDeCaixa) {
		this.fluxoDeCaixa = fluxoDeCaixa;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Estoque[] getEstoques() {
		return estoques;
	}

	public void setEstoques(Estoque[] estoques) {
		this.estoques = estoques;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	
}
