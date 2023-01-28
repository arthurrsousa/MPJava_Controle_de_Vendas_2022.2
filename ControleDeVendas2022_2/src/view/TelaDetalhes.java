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
import model.Produto;

/**
 * Tela de detalhes das instancias das classes do software
 * @author Arthur Rodrigues Sousa
 *
 */
public class TelaDetalhes implements ActionListener {

	private JFrame janela;
	
	//Pessoa
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelEnd = new JLabel("Endereco: ");
	private JTextField valorEnd;
	private JLabel labelCPF = new JLabel("CPF: ");
	private JTextField valorCPF;
	private JLabel labelTelefone = new JLabel("Telefone");
	private JTextField valorTelefone;
	
	//Vendedor
	private JLabel labelSaldo = new JLabel("Saldo Atual (R$): ");
	private JTextField valorSaldo;
	private JLabel labelQtdVendas = new JLabel("Quantidade de Vendas: ");
	private JTextField valorQtdVendas;
	private JLabel labelvalorVendas = new JLabel("Valor de Vendas: ");
	private JTextField valorVendas;
	
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
	private JLabel labelValorVenda = new JLabel("Valor de venda: ");
	private JTextField valorVenda;
	private JLabel labelValorCompra = new JLabel("Valor de compra: ");
	private JTextField valorCompra;
	private JLabel labelDesc = new JLabel("Descrição: ");
	private JTextField valorDesc;
	
	//Recibo
	private JLabel valorCodigo;
	private JLabel valorComprador = new JLabel();
	private JLabel valorData = new JLabel();
	private JLabel valorValorTotal = new JLabel();					
	private JLabel valorQtd = new JLabel();
	private JLabel valorProd = new JLabel();
	private JLabel[] listaRecibo = new JLabel[10];
	private Produto[] listaItens;
	private int[] listaQtds;
			
			
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
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
		if (op == 1) s = "Detalhe de Vendedor";
		if (op == 2) s = "Cadastro de Produto";
		if (op == 3) s = "Cadastro de Cliente";
		if (op == 4) s = "Detalhe de Produto";
		if (op == 5) s = "Detalhe de Cliente";
		if (op == 10) s = "Detalhe de Fornecedor";

		janela = new JFrame(s);
		
		//Preenche dados com dados do Fornecedor
		//String n, int tel, String end, int cnpj, String ie, int ra, float entrega
		if (op == 10) {
			valorNome = new JTextField(dados.getFornecedor().getNome(), 200);
			valorTelefone = new JTextField(String.valueOf(dados.getFornecedor().getTelefone()), 200);		
			valorEnd = new JTextField(dados.getFornecedor().getEndereco(), 200);
			valorCnpj = new JTextField(dados.getFornecedor().getCnpj(), 200);
			valorIE = new JTextField(String.valueOf(dados.getFornecedor().getInsEstadual()), 200);

			valorRA = new JTextField(dados.getFornecedor().getRa(), 200);
			valorEntrega = new JTextField(dados.getFornecedor().getValorEntrega(), 200);

		} 

		//Preenche dados com dados do Vendedor
		if (op == 1) {
			valorNome = new JTextField(dados.getVendedor()[pos].getNome(), 200);
			valorEnd = new JTextField(dados.getVendedor()[pos].getEndereco(), 200);
			valorCPF = new JTextField(String.valueOf(dados.getVendedor()[pos].getCpf()), 200);
			valorTelefone = new JTextField(String.valueOf(dados.getVendedor()[pos].getTelefone()), 200);		

			valorVendas = new JTextField(String.valueOf(dados.getVendedor()[pos].getValor_vendas()), 200);
			valorQtdVendas = new JTextField(String.valueOf(dados.getVendedor()[pos].getQuantidade_vendas()), 200);

		} 
		
		//Preenche dados com dados do Produto clicado
		else if (op == 4) {  
			valorNome = new JTextField(dados.getProduto()[pos].getNome(), 200);
			valorMarca = new JTextField(String.valueOf(dados.getProduto()[pos].getMarca()),200);
			valorCateg = new JTextField(String.valueOf(dados.getProduto()[pos].getCategoria()), 200);
			valorDesc = new JTextField(String.valueOf(dados.getProduto()[pos].getDescricao()), 200);
			valorVenda = new JTextField(String.valueOf(dados.getProduto()[pos].getValorVenda()), 200);
			valorCompra = new JTextField(String.valueOf(dados.getProduto()[pos].getValorCompra()), 200);

		}
		
		//Preenche dados com dados do Cliente clicado
		else if (op == 5) {
			valorNome = new JTextField(dados.getCliente()[pos].getNome(), 200);
			valorEnd = new JTextField(dados.getCliente()[pos].getEndereco(), 200);
			valorCPF = new JTextField(String.valueOf(dados.getCliente()[pos].getCpf()), 200);
			valorTelefone = new JTextField(String.valueOf(dados.getCliente()[pos].getTelefone()), 200);		

			valorTotalPago = new JTextField(String.valueOf(dados.getCliente()[pos].getTotal_pago()), 200);
			valorTotalCompras = new JTextField(String.valueOf(dados.getCliente()[pos].getCompras_realizadas()), 200);
		} 
		
		
		else { //Não preenche com dados
			valorNome = new JTextField(200);
			valorEnd = new JTextField(200);
			valorCPF = new JTextField(200);
			valorTelefone = new JTextField(200);
			valorSaldo = new JTextField(200);
			valorQtdVendas = new JTextField(200);
			valorTotalPago = new JTextField(200);
			valorTotalCompras = new JTextField(200);
			valorMarca = new JTextField(200);
			valorCateg = new JTextField(200);
			valorDesc = new JTextField(200);
			valorValor = new JTextField(200);

			botaoSalvar.setBounds(245, 205, 115, 30);
			this.janela.add(botaoSalvar);
		}
		
			//================Vendedor================
		if (op == 1) {
			labelNome.setBounds(30, 20, 150, 25);
			valorNome.setBounds(180, 20, 180, 25);
			
			labelEnd.setBounds(30, 50, 150, 25);
			valorEnd.setBounds(180, 50, 180, 25);
			
			labelCPF.setBounds(30, 80, 150, 25);
			valorCPF.setBounds(180, 80, 180, 25);
			
			labelTelefone.setBounds(30, 110, 150, 25);
			valorTelefone.setBounds(180, 110, 180, 25);
			
			labelSaldo.setBounds(30, 140, 150, 25);
			valorSaldo.setBounds(180, 140, 180, 25);
			
			labelQtdVendas.setBounds(30, 170, 150, 25);
			valorQtdVendas.setBounds(180, 170, 70, 25);

		}
		
		//================Cliente================
		if (op == 5 || op == 3) {
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
		if (op == 4 || op == 2) {
			labelNome.setBounds(30, 20, 150, 25);
			valorNome.setBounds(180, 20, 180, 25);
			
			labelMarca.setBounds(30, 50, 150, 25);
			valorMarca.setBounds(180, 50, 180, 25);
			
			labelCateg.setBounds(30, 80, 150, 25);
			valorCateg.setBounds(180, 80, 180, 25);
			
			labelValor.setBounds(30, 110, 150, 25);
			valorValor.setBounds(180, 110, 180, 25);
	
			labelDesc.setBounds(30, 140, 150, 25);
			valorDesc.setBounds(180, 140, 180, 25);
		}

		//Coloca os campos relacionados a Pessoa
		if (op == 1 || op == 3 || op == 5) {
			
			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelEnd);
			this.janela.add(valorEnd);
			this.janela.add(labelCPF);
			this.janela.add(valorCPF);
			this.janela.add(labelTelefone);
			this.janela.add(valorTelefone);
		}

		//Coloca campos relacionados a Vendedor
		if (op == 1) {

			this.janela.add(labelSaldo);
			this.janela.add(valorSaldo);
			this.janela.add(labelQtdVendas);
			this.janela.add(valorQtdVendas);
		}
		
		//Coloca campos relacionados a Cliente
		if (op == 3 || op == 5) {

			this.janela.add(labelTotalPago);
			this.janela.add(valorTotalPago);
			this.janela.add(labelTotalCompras);
			this.janela.add(valorTotalCompras);
			
		}
			
		//Coloca campos relacionados a Produto
		if (op == 2 || op == 4) {

			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelMarca);
			this.janela.add(valorMarca);
			this.janela.add(labelCateg);
			this.janela.add(valorCateg);
			this.janela.add(labelValor);
			this.janela.add(valorValor);
			this.janela.add(labelDesc);
			this.janela.add(valorDesc);
		}

		//Coloca botoes
		if (op == 1) {
			botaoSalvar.setBounds(120, 215, 115, 30);
			this.janela.add(botaoSalvar);
		}
		
		if (op == 4) {
			botaoSalvar.setBounds(180, 175, 115, 30);
			botaoExcluir.setBounds(50, 175, 115, 30);
			this.janela.add(botaoSalvar);
			this.janela.add(botaoExcluir);
		}
		
		if (op == 5) {
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
	}

	/**
	 * Sobrecarga que acrecenta o index do cliente portador do recibo a ser detalhado.
	 * Apresenta na tela o valor total da compra realizada, os produtos e seus precos.
	 * @param index - posicao do Cliente no array
	 */
	public void inserirEditar(int op, ControleDados d, int pos, int index) {

		if (op == 7) {
			s = "Detalhe do Recibo";
			janela = new JFrame(s);
			
			//Preenche dados com dados do Recibo
			valorCodigo = new JLabel("Codigo da Nota:  " + dados.getRecibo(index)[pos].getCodigo(), SwingConstants.LEFT);
			valorComprador = new JLabel("CPF do Cliente:  " + dados.getRecibo(index)[pos].getComprador().getCpf(), SwingConstants.LEFT);
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
					
					listaRecibo[i] = new JLabel(listaQtds[i] + "x         " + listaItens[i].getNome() + "         R$" + (listaItens[i].getValor()), SwingConstants.CENTER);
					listaRecibo[i].setBounds(35, (120+20*(i+1)), 300, 25);
					listaRecibo[i].setBackground(Color.lightGray);
					
					janela.add(listaRecibo[i]);
				}
				i++;
			}
			
			this.janela.setLayout(null);
			this.janela.setSize(450, 390);
			this.janela.setVisible(true);
		}
	}

	/**
	 * Realiza uma acao dependendo do botao selecionado
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			try {
				boolean res = false;
				if(opcao == 2) //cadastro de novo Produto
					novoDado[0] = Integer.toString(dados.getQtdProdutos());
				
				else if (opcao == 3) // cadastro de novo Cliente
					novoDado[0] = Integer.toString(dados.getQtdClientes());
				
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				novoDado[1] =  valorNome.getText();
				
					//Vendedor
				if (opcao == 1) {  
					novoDado[2] =  valorEnd.getText();
					novoDado[3] =  valorCPF.getText();
					novoDado[4] =  valorTelefone.getText();
					novoDado[5] =  valorSaldo.getText();
					novoDado[6] =  valorQtdVendas.getText();
					res = dados.inserirEditarVendedor(novoDado);
				
					//Produto
				} else if (opcao == 2 || opcao == 4) {  
					novoDado[2] =  valorMarca.getText();
					novoDado[3] =  valorCateg.getText();
					novoDado[4] =  valorValor.getText();
					novoDado[5] =  valorDesc.getText();
					res = dados.inserirEditarProduto(novoDado);	
					
					//Cliente
				} else if (opcao == 3 || opcao == 5) {  
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
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}
		

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 4) {//exclui Produto
				res = dados.removerProduto(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusao(); 
			}
				
			if (opcao == 5){ //exclui Cliente
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
			new TelaDetalhes().inserirEditar(5, dados, posicao);
		}
		
		//=============Abre selecao de Produto
		if(src == botaoComprar) {
			new TelaCarrinho().mostrarCarrinho(dados, posicao);
		}	
		
		
		if(src == botaoRecibos) {
			new TelaLista().mostrarDados(dados, 4, posicao);
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
	 * Mostra mensagem caso cadastro seja bem sucedido.
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * Mostra mensagem caso cadastro seja mau sucedido.
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mostra mensagem caso exclusao seja mal sucedida.
	 */
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}