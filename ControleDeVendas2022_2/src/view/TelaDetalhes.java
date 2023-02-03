package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.*;

/**
 * Tela de detalhes das instancias das classes do software
 * @author Arthur Rodrigues Sousa
 *
 */
public class TelaDetalhes implements ActionListener {

	private JFrame janela;
	
	//Pessoa Juridica e Fisica
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelEnd = new JLabel("Endereco: ");
	private JTextField valorEnd;
	private JLabel labelTelefone = new JLabel("Telefone");
	private JTextField valorTelefone;
	private JLabel labelCPF = new JLabel("CPF: ");
	private JTextField valorCPF;
	private JLabel labelCnpj = new JLabel("CNPJ: ");
	private JTextField valorCnpj;
	private JLabel labelIE = new JLabel("Inscrição Estadual: "); 
	private JTextField valorIE;
	
	
	//Vendedor
	private JLabel labelQtdVendas = new JLabel("Quantidade de Vendas: ");
	private JTextField valorQtdVendas;
	private JLabel labelvVendas = new JLabel("Valor de Vendas: ");
	private JTextField valorvVendas;
	
	//Cliente
	private JLabel labelTotalPago = new JLabel("Total Pago: ");
	private JTextField valorTotalPago;
	private JLabel labelTotalCompras = new JLabel("Compras Realizadas: ");
	private JTextField valorTotalCompras;
	private JButton botaoRefresh = new JButton("Refresh");
	private JButton botaoComprar = new JButton("Comprar");
	private JButton botaoRecibos = new JButton("Recibos");

	//Produto
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField valorMarca;
	private JLabel labelCateg = new JLabel("Categoria: ");
	private JTextField valorCateg;
	private JLabel labelValorCompra = new JLabel("Valor de compra: ");
	private JTextField valorCompra;
	private JLabel labelValorVenda = new JLabel("Valor de venda: ");
	private JTextField valorVenda;
	private JLabel labelDesc = new JLabel("Descrição: ");
	private JTextField valorDesc;
	
	//Estoque
	private JLabel labelProduto = new JLabel("Produto: ");
	private JTextField valorProduto;
	private JLabel labelQtdAtual = new JLabel("Quantidade Atual: ");
	private JTextField valorQtdAtual;
	private JLabel labelQtdMinima = new JLabel("Quantidade Minima: ");
	private JTextField valorQtdMinima;
	private JLabel labelQtdComprada = new JLabel("Quantidade Comprada: ");
	private JTextField valorQtdComprada;
	
	//Fornecedor
	private JLabel labelEntrega = new JLabel("Valor da Entrega: ");
	private JTextField valorEntrega;
	private JButton botaoRenovarEstoque = new JButton("Renovar Estoque de Produto");
	
	//Fluxo
	private JLabel labelsaldo_atual = new JLabel("Saldo atual: ");
	private JTextField valorsaldo_atual;
	private JLabel labelsaida_dinheiro = new JLabel("Saida dinheiro: ");
	private JTextField valorsaida_dinheiro;
	private JLabel labelentrada_dinheiro = new JLabel("Entrada dinheiro: ");
	private JTextField valorentrada_dinheiro;
	
	//Recibo
	private JLabel valorCodigo;
	private JLabel valorComprador = new JLabel();
	private JLabel valorData = new JLabel();
	private JLabel valorValorTotal = new JLabel();					
	private JLabel valorQtd = new JLabel();
	private JLabel valorProd = new JLabel();
	private JLabel[] listaRecibo = new JLabel[10];
	//private Produto[] listaItens;
	private int[] listaQtds;
			
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoEstoque = new JButton("Estoque");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Altera os dados que serao apresentados dependendo do botao (opcao) selecionado.
	 * @param op - opcao selecionada.
	 * @param d - controle de dados do sistema.
	 * @param pos - posicao no array da instancia a ser detalhada.
	 */
	public void inserirEditar(int op, ControleDados d, int pos) {
		opcao = op;
		dados = d;
		posicao = pos;
		if (op == 10) s = "Detalhe de Vendedor";
		if (op == 11) s = "cadastro de Vendedor";
		if (op == 20) s = "Detalhe de Produto";
		if (op == 21) s = "Cadastro de Produto";
		if (op == 30) s = "Cadastro de Cliente";
		if (op == 31) s = "Detalhe de Cliente";
		if (op == 70) s = "Detalhe de Fornecedor";
		if (op == 69) s = "Estoque";
		if (op == 80) s = "Salvar do Fluxo";

		janela = new JFrame(s);
		
		//Preenche dados com dados do Fornecedor
		if (op == 70) {
			valorNome = new JTextField(dados.getFornecedor().getNome(), 200);
			valorTelefone = new JTextField(String.valueOf(dados.getFornecedor().getTelefone()), 200);		
			valorEnd = new JTextField(dados.getFornecedor().getEndereco(), 200);
			valorCnpj = new JTextField(String.valueOf(dados.getFornecedor().getCnpj()), 200);
			valorIE = new JTextField(String.valueOf(dados.getFornecedor().getInsEstadual()), 200);
			valorEntrega = new JTextField(String.valueOf(dados.getFornecedor().getValorEntrega()), 200);
		} 
		//Prenche dados com dados do FluxoDeCaixa clicado
		else if (op == 80) {
			valorsaldo_atual = new JTextField(String.valueOf(dados.getFluxoDeCaixa().getSaldo_atual()), 200);
			valorsaida_dinheiro = new JTextField(String.valueOf(dados.getFluxoDeCaixa().getSaida_dinheiro()), 200);
			valorentrada_dinheiro = new JTextField(String.valueOf(dados.getFluxoDeCaixa().getEntrada_dinheiro()), 200);
		}
		//Preenche dados com dados do Vendedor
		else if (op == 10 || op == 11) {
			System.out.println("OP = 10");
			valorNome = new JTextField(dados.getVendedor()[pos].getNome(), 200);
			valorEnd = new JTextField(dados.getVendedor()[pos].getEndereco(), 200);
			valorCPF = new JTextField(String.valueOf(dados.getVendedor()[pos].getCpf()), 200);
			valorTelefone = new JTextField(String.valueOf(dados.getVendedor()[pos].getTelefone()), 200);		

			valorvVendas = new JTextField(String.valueOf(dados.getVendedor()[pos].getValor_vendas()), 200);
			valorQtdVendas = new JTextField(String.valueOf(dados.getVendedor()[pos].getQuantidade_vendas()), 200);
		} 
		
		//Preenche dados com dados do Produto clicado
		else if (op == 20) {  
			valorNome = new JTextField(dados.getProduto()[pos].getNome(), 200);
			valorMarca = new JTextField(dados.getProduto()[pos].getMarca(),200);
			valorCateg = new JTextField(String.valueOf(dados.getProduto()[pos].getCategoria()), 200);
			valorDesc = new JTextField(String.valueOf(dados.getProduto()[pos].getDescricao()), 200);
			valorVenda = new JTextField(String.valueOf(dados.getProduto()[pos].getValorVenda()), 200);
			valorCompra = new JTextField(String.valueOf(dados.getProduto()[pos].getValorCompra()), 200);
		}
		
		//Preenche dados com dados do ClienteFis clicado
		else if (op == 31) {
			valorNome = new JTextField(dados.getClientePes()[pos].getNome(), 200);
			valorEnd = new JTextField(dados.getClientePes()[pos].getEndereco(), 200);
			valorTelefone = new JTextField(String.valueOf(dados.getClientePes()[pos].getTelefone()), 200);		
			valorCPF = new JTextField(String.valueOf(dados.getClientePes()[pos].getCpf()), 200);
			
			valorTotalPago = new JTextField(String.valueOf(dados.getClientePes()[pos].getTotal_pago()), 200);
			valorTotalCompras = new JTextField(String.valueOf(dados.getClientePes()[pos].getCompras_realizadas()), 200);
		} 
		

		// Preenche dados com dados do Estoque
		else if (op == 69) {
			valorProduto = new JTextField(dados.getEstoques()[pos].getProduto().getNome(), 200);
			valorQtdAtual = new JTextField(String.valueOf(dados.getEstoques()[pos].getQtdAtual()), 200);
			valorQtdMinima = new JTextField(String.valueOf(dados.getEstoques()[pos].getQtdMinima()), 200);		
			valorQtdComprada = new JTextField(String.valueOf(dados.getEstoques()[pos].getQtdCompras()), 200);
			
		} 

		
		else { //Não preenche com dados
			valorNome = new JTextField(200);
			valorEnd = new JTextField(200);
			valorCPF = new JTextField(200);
			valorTelefone = new JTextField(200);
			valorCnpj = new JTextField(200);
			valorQtdVendas = new JTextField(200);
			valorTotalPago = new JTextField(200);
			valorTotalCompras = new JTextField(200);
			valorMarca = new JTextField(200);
			valorCateg = new JTextField(200);
			valorDesc = new JTextField(200);
			valorCompra = new JTextField(200);

			botaoSalvar.setBounds(245, 205, 115, 30);
			this.janela.add(botaoSalvar);
		}
		
		//================Fornecedor================
			if (op == 70) {
				labelNome.setBounds(30, 20, 150, 25);
				valorNome.setBounds(180, 20, 180, 25);
				
				labelEnd.setBounds(30, 50, 150, 25);
				valorEnd.setBounds(180, 50, 180, 25);
				
				labelCnpj.setBounds(30, 80, 150, 25);
				valorCnpj.setBounds(180, 80, 180, 25);
				
				labelTelefone.setBounds(30, 110, 150, 25);
				valorTelefone.setBounds(180, 110, 180, 25);
				
				labelIE.setBounds(30, 140, 150, 25);
				valorIE.setBounds(180, 140, 180, 25);
				
				labelEntrega.setBounds(30, 170, 150, 25);
				valorEntrega.setBounds(180, 170, 70, 25);
			}
			
		//================FLUXO================	

		if (op == 80 ) {
			labelsaldo_atual.setBounds(30, 20, 150, 25);
			valorsaldo_atual.setBounds(180, 20, 180, 25);
					
			labelsaida_dinheiro.setBounds(30, 50, 150, 25);
			valorsaida_dinheiro.setBounds(180, 50, 180, 25);
			
			labelentrada_dinheiro.setBounds(30, 80, 150, 25);
			valorentrada_dinheiro.setBounds(180, 80, 180, 25);
				
		}
			//================Vendedor================
		if (op == 10 || op == 11) {
			labelNome.setBounds(30, 20, 150, 25);
			valorNome.setBounds(180, 20, 180, 25);
			
			labelEnd.setBounds(30, 50, 150, 25);
			valorEnd.setBounds(180, 50, 180, 25);
			
			labelCPF.setBounds(30, 80, 150, 25);
			valorCPF.setBounds(180, 80, 180, 25);
			
			labelTelefone.setBounds(30, 110, 150, 25);
			valorTelefone.setBounds(180, 110, 180, 25);
			
			labelvVendas.setBounds(30, 140, 150, 25);
			valorvVendas.setBounds(180, 140, 180, 25);
			
			labelQtdVendas.setBounds(30, 170, 150, 25);
			valorQtdVendas.setBounds(180, 170, 70, 25);
		}
		
		//================Cliente================
		if (op == 30 || op == 31) {
			labelNome.setBounds(30, 20, 150, 25);
			valorNome.setBounds(180, 20, 210, 25);
			
			labelEnd.setBounds(30, 50, 150, 25);
			valorEnd.setBounds(180, 50, 210, 25);
			
			labelCPF.setBounds(30, 80, 150, 25);
			valorCPF.setBounds(180, 80, 210, 25);
			
			labelTelefone.setBounds(30, 110, 150, 25);
			valorTelefone.setBounds(180, 110, 210, 25);
			
			labelTotalPago.setBounds(30, 140, 150, 25);
			valorTotalPago.setBounds(180, 140, 210, 25);
			
			labelTotalCompras.setBounds(30, 170, 150, 25);
			valorTotalCompras.setBounds(180, 170, 210, 25);
		}
		
		//================Produto================
		if (op == 20 || op == 21) {
			labelNome.setBounds(30, 20, 150, 25);
			valorNome.setBounds(180, 20, 180, 25);
			
			labelMarca.setBounds(30, 50, 150, 25);
			valorMarca.setBounds(180, 50, 180, 25);
			
			labelCateg.setBounds(30, 80, 150, 25);
			valorCateg.setBounds(180, 80, 180, 25);
			
			labelValorVenda.setBounds(30, 110, 150, 25);
			valorVenda.setBounds(180, 110, 180, 25);
	
			labelDesc.setBounds(30, 140, 150, 25);
			valorDesc.setBounds(180, 140, 180, 25);
		}
		//================Estoque================
		if (op == 69) {
			labelProduto.setBounds(30, 20, 150, 25);
			valorProduto.setBounds(180, 20, 180, 25);
			
			labelQtdAtual.setBounds(30, 50, 150, 25);
			valorQtdAtual.setBounds(180, 50, 180, 25);
			
			labelQtdMinima.setBounds(30, 80, 150, 25);
			valorQtdMinima.setBounds(180, 80, 180, 25);
			
			labelQtdComprada.setBounds(30, 110, 150, 25);
			valorQtdComprada.setBounds(180, 110, 180, 25);
			
		}

		//Coloca os campos relacionados a Pessoa
		if (op == 10 || op == 30 || op == 31 || op == 70) {
			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelEnd);
			this.janela.add(valorEnd);
			this.janela.add(labelTelefone); 
			this.janela.add(valorTelefone);
		}

		//Coloca campos relacionados a Vendedor
		if (op == 10|| op == 11) {
			this.janela.add(labelCPF);
			this.janela.add(valorCPF);
			this.janela.add(labelvVendas);
			this.janela.add(valorvVendas);
			this.janela.add(labelQtdVendas);
			this.janela.add(valorQtdVendas);
		}
		
		//Coloca campos relacionados a ClientePessoa
		if (op == 30 || op == 31) {
			this.janela.add(labelCPF);
			this.janela.add(valorCPF);	
			this.janela.add(labelTotalPago);
			this.janela.add(valorTotalPago);	
			this.janela.add(labelTotalCompras);
			this.janela.add(valorTotalCompras);	
		}

		//Coloca campos relacionados a Fornecedor
		if (op == 70) {
			this.janela.add(labelCnpj); 
			this.janela.add(valorCnpj);
			this.janela.add(labelIE); 
			this.janela.add(valorIE);
			this.janela.add(labelEntrega);
			this.janela.add(valorEntrega);
		}
		//Coloca campos relacionados a Fluxo
		if (op == 80 ) {
			this.janela.add(labelentrada_dinheiro); 
			this.janela.add(valorentrada_dinheiro);
			this.janela.add(labelsaida_dinheiro); 
			this.janela.add(valorsaida_dinheiro);
			this.janela.add(labelsaldo_atual);
			this.janela.add(valorsaldo_atual);
		}
		//Coloca campos relacionados a Produto
		if (op == 21 || op == 20) {

			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelMarca);
			this.janela.add(valorMarca);
			this.janela.add(labelCateg);
			this.janela.add(valorCateg);
			this.janela.add(labelValorVenda);
			this.janela.add(valorVenda);
			this.janela.add(labelDesc);
			this.janela.add(valorDesc);
		}
		//Coloca campos relacionados a Estoque
		if (op == 69) {
			
			this.janela.add(labelProduto);
			this.janela.add(valorProduto);
			this.janela.add(labelQtdAtual);
			this.janela.add(valorQtdAtual);
			this.janela.add(labelQtdMinima);
			this.janela.add(valorQtdMinima);
			this.janela.add(labelQtdComprada);
			this.janela.add(valorQtdComprada);
			
		}

		//Coloca botoes
		if (op == 70) {
			botaoSalvar.setBounds(120, 215, 115, 30);
			botaoRenovarEstoque.setBounds(280, 260, 90, 30);
			this.janela.add(botaoSalvar);
			this.janela.add(botaoRenovarEstoque);
		}
		
		if (op == 10) {
			botaoSalvar.setBounds(120, 215, 115, 30);
			botaoExcluir.setBounds(280, 205, 75, 30);
			this.janela.add(botaoSalvar);
			this.janela.add(botaoExcluir);
		}
		
		if (op == 20) {
			botaoSalvar.setBounds(180, 175, 115, 30);
			botaoExcluir.setBounds(50, 175, 115, 30);
			botaoEstoque.setBounds(115, 210, 115, 30);
			this.janela.add(botaoSalvar);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoEstoque);
		}
		if (op == 69) {
			botaoSalvar.setBounds(170, 175, 115, 30);
			this.janela.add(botaoSalvar);
			
		}
		
		if (op == 31) {
			botaoSalvar.setBounds(200, 205, 70, 30);
			botaoExcluir.setBounds(280, 205, 75, 30);
			botaoRefresh.setBounds(50, 260, 90, 30);
			botaoComprar.setBounds(165, 260, 90, 30);
			botaoRecibos.setBounds(280, 260, 90, 30);
	
			this.janela.add(botaoSalvar);
			this.janela.add(botaoExcluir);
			this.janela.add(botaoRefresh);
			this.janela.add(botaoComprar);	
			this.janela.add(botaoRecibos);	
		}

		this.janela.setLayout(null);

		this.janela.setSize(450, 390);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoRefresh.addActionListener(this);
		botaoComprar.addActionListener(this);		
		botaoRecibos.addActionListener(this);
		botaoEstoque.addActionListener(this);
		botaoRenovarEstoque.addActionListener(this);
	}

	/**
	 * Sobrecarga que acrecenta o index do cliente portador do recibo a ser detalhado.
	 * Apresenta na tela o valor total da compra realizada, os produtos e seus precos.
	 * @param index - posicao do Cliente no array
	 */
	public void inserirEditar(int op, ControleDados d, int pos, int index) {
/*
		if (op == 7) {
			s = "Detalhe do Recibo";
			janela = new JFrame(s);
			
			//Preenche dados com dados do Recibo
			valorCodigo = new JLabel("Codigo da Nota:  " + dados.getRecibo(index)[pos].getCodigo(), SwingConstants.LEFT);
			//valorComprador = new JLabel("CPF do Cliente:  " + dados.getRecibo(index)[pos].getComprador().getCpf(), SwingConstants.LEFT);
			valorData = new JLabel(String.valueOf("Compra feita em:  " + dados.getRecibo(index)[pos].getData()), SwingConstants.LEFT);
			valorValorTotal = new JLabel(String.valueOf("Valor Total:  R$" + dados.getRecibo(index)[pos].getValor_total()), SwingConstants.LEFT);	
			

			valorCodigo.setBounds(30, 20, 300, 25);
			valorComprador.setBounds(30, 50, 300, 25);
			valorData.setBounds(30, 80, 300, 25);
			valorValorTotal.setBounds(30, 110, 300, 25);
	
			
			this.janela.add(valorCodigo);
			this.janela.add(valorComprador);
			this.janela.add(valorData);
			this.janela.add(valorValorTotal);
			this.janela.add(valorQtd);
			this.janela.add(valorProd);
			
			listaItens = dados.getRecibo(index)[pos].getProdutos();
			listaQtds = dados.getRecibo(index)[pos].getQtd();
			
			int i = 0;
			while (i < 10) {  //Lista os produtos comprados, a quantidade e o preco de cada um 
				if (listaItens[i] != null) {
					
					listaRecibo[i] = new JLabel(listaQtds[i] + "x         " + listaItens[i].getNome() + "         R$" + (listaItens[i].getValorVenda()), SwingConstants.CENTER);
					listaRecibo[i].setBounds(35, (120+20*(i+1)), 300, 25);
					listaRecibo[i].setBackground(Color.lightGray);
					
					janela.add(listaRecibo[i]);
				}
				i++;
			}
			
			this.janela.setLayout(null);
			this.janela.setSize(450, 390);
			this.janela.setVisible(true);
		}*/
	}

	/**
	 * Realiza uma acao dependendo do botao selecionado
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			try {
				boolean res = false;
				if(opcao == 21) //cadastro de novo Produto
					novoDado[0] = Integer.toString(dados.getQtdProdutos());
				
				else if (opcao == 30) // cadastro de novo Cliente
					novoDado[0] = Integer.toString(dados.getQtdClientes());

				else if (opcao == 11) // cadastro de novo Vendedor
					novoDado[0] = Integer.toString(dados.getQtdVendedor());
				
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				novoDado[1] =  valorNome.getText();
				
					//Vendedor
				if (opcao == 10 || opcao == 11) {  
					novoDado[2] =  valorTelefone.getText();
					novoDado[3] =  valorEnd.getText();
					novoDado[4] =  valorCPF.getText();
					novoDado[5] =  valorQtdVendas.getText();
					novoDado[6] =  valorvVendas.getText();
					res = dados.inserirEditarVendedor(novoDado);
				
					//Produto
				} else if (opcao == 21 || opcao == 20) {  
					novoDado[2] =  valorMarca.getText();
					novoDado[3] =  valorCateg.getText();
					novoDado[4] =  valorVenda.getText();
					novoDado[5] =  valorCompra.getText();
					novoDado[6] =  valorDesc.getText();
					res = dados.inserirEditarProduto(novoDado);	
					
					//Cliente
				} else if (opcao == 30 || opcao == 31) {  
					novoDado[2] =  valorEnd.getText();
					novoDado[3] =  valorCPF.getText();
					novoDado[4] =  valorTelefone.getText();
					novoDado[5] =  valorTotalPago.getText();
					novoDado[6] =  valorTotalCompras.getText();
					res = dados.inserirEditarCliente(novoDado);
				} 

				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				//mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				//mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 20) {//exclui Produto
				res = dados.removerProduto(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusao(); 
			}
			
			if (opcao == 10 || opcao == 11) {//exclui Vendedor
				res = dados.removerVendedor(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusao(); 
			}
				
			if (opcao == 31){ //exclui Cliente
				res = dados.removerCliente(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusao(); 
			}
		}
		
		if(src == botaoRefresh) {
			janela.dispose();botaoSalvar.setBounds(200, 205, 70, 30);
			botaoExcluir.removeActionListener(this);
			botaoRefresh.removeActionListener(this);
			botaoComprar.removeActionListener(this);
			botaoRecibos.removeActionListener(this);
			new TelaDetalhes().inserirEditar(31, dados, posicao);
		}
		
		//=============Abre selecao de Produto
		if(src == botaoComprar) {
			new TelaCarrinho().mostrarCarrinho(dados, posicao);
		}		
		
		if(src == botaoRecibos) {
			new TelaLista().mostrarDados(dados, 20, posicao);
		}
		
		if(src == botaoEstoque) {
			new TelaDetalhes().inserirEditar(69, dados, posicao);
		}	
		
		if(src == botaoRenovarEstoque) {
			new TelaRenovarEstoque().mostrarProdutos(dados);
		}	
	}

	/**
	 * Mostra mensagem caso exclusao seja bem sucedida.
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Mostra mensagem caso exclusao seja mal sucedida.
	 */
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostra mensagem caso cadastro seja bem sucedido.
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * Mostra mensagem caso cadastro seja mal sucedido.
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao salvar os dados!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}