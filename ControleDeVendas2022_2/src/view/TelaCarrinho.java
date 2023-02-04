package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.*;
import model.*;

public class TelaCarrinho implements ActionListener, ListSelectionListener{

	private JFrame janela;
	private JLabel titulo;
	
	private Carrinho carrinho;
	private JLabel[] labelCarrinho = new JLabel[20]; 
	private JButton botaoProdutos = new JButton("Selecionar Produto");
	private JButton botaoFinalizar = new JButton("Finalizar Compra");

	//private Produto[] listaCarrinhoProd = new Produto[10];
	//private int qtdCarrinhoProd;
	//private int[] listaCarrinhoQtd = new int[10];
	private Produto prodSelec;
	
	private JFrame frameProdutos;
	private JList<String> listaProdsCadastrados;
	private JLabel labelQtdItem = new JLabel("Quantidade: ");
	private JTextField qtdItem = new JTextField(String.valueOf(1), 200);
	private JButton botaoAdicionar = new JButton("Adicionar");
	private String[] listaNomes = new String[50];
	private JButton[] botaoRemover = new JButton[10];
	
	private int opcaoPag;
	private JCheckBox pix = new JCheckBox("Pix");
	private JCheckBox cartao = new JCheckBox("Cartão");
	private JCheckBox boleto = new JCheckBox("Boleto");
	//private JCheckBox desconto = new JCheckBox("Desconto");
	
	private ControleDados dados;
	private int posicao;
	
	public void mostrarCarrinho(ControleDados d, int pos) {
		dados = d;
		posicao = pos;
		janela = new JFrame("Carrinho");
		carrinho = dados.getCarrinho(); 
		
		titulo = new JLabel("Realize as Compras Aqui");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(70, 10, 250, 30);
		
		pix.setBounds(15, 100, 80, 30);
		cartao.setBounds(95, 100, 80, 30);
		boleto.setBounds(185, 100, 80, 30);
		
		//Mostra os produtos no carrinho
		if (carrinho.getProdutos() != null) {
			//System.out.println("Primeiro Item  " + carrinhoProd[0]);
			int i = 0;
			while (i < 20) {
				//System.out.println("OK while i");
				if (carrinho.getProdutos()[i] != null) {
					
					labelCarrinho[i] = new JLabel(carrinho.getQuantidades()[i] + "x    " + carrinho.getProdutos()[i].getNome());
					botaoRemover[i] = new JButton("X");
					labelCarrinho[i].setBounds(35, (130+20*(i+1)), 180, 25);
					labelCarrinho[i].setBackground(Color.lightGray);
					
					botaoRemover[i].setBounds(320, (130+20*(i+1)), 15, 15);
					botaoRemover[i].setBackground(Color.red);
					botaoRemover[i].setOpaque(true);
					botaoRemover[i].setBorder(null);
					botaoRemover[i].setBorderPainted(true);
					
					janela.add(labelCarrinho[i]);
					janela.add(botaoRemover[i]);
					botaoRemover[i].addActionListener(this);
				}
				i++;
			}
		}
		
		janela.setLayout(null);
		janela.setSize(400, 420);
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		botaoProdutos.setBounds(30, 60, 150, 30);
		botaoFinalizar.setBounds(200, 60, 150, 30);
		
		janela.add(titulo);
		janela.add(botaoProdutos);
		janela.add(botaoFinalizar);
		janela.add(pix);
		janela.add(cartao);
		janela.add(boleto);
		
		botaoProdutos.addActionListener(this);
		botaoFinalizar.addActionListener(this);
		
		pix.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
            	 if(e.getStateChange() == ItemEvent.SELECTED) {
            		 opcaoPag = 1;
            		 System.out.println("PIX: op " + opcaoPag);
            	 };
             }    
          });
		cartao.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
            	 if(e.getStateChange() == ItemEvent.SELECTED) {
            		 opcaoPag = 2;
            		 System.out.println("CARTAO: op " + opcaoPag);
            	 };
             }    
          });
		boleto.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
            	 if(e.getStateChange() == ItemEvent.SELECTED) {
            		 opcaoPag = 3;
            		 System.out.println("BOLETO: op " + opcaoPag);
            	 };
             }    
          });
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaProdsCadastrados) {
			prodSelec = dados.getProduto()[listaProdsCadastrados.getSelectedIndex()];	
			boolean valid = true;
			
			for (int k = 0; k < 10; k++) {
				if (prodSelec == carrinho.getProdutos()[k]) {					
					valid = false;
					//mensagemProdutoRepetido();
					botaoAdicionar.removeActionListener(this);
					break;
				}
			}
			
			if (valid) {
				botaoAdicionar.addActionListener(this); //Botao Adicionar so fara algo depois que um produto for selecionado				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		//Abre tela de Selecao de Produtos
		if(src == botaoProdutos) {
			System.out.println("ABRINDO LISTA DE SELECAO DE PRODS");
			botaoProdutos.removeActionListener(this);
			botaoFinalizar.removeActionListener(this);
			botaoProdutos.removeActionListener(this);		
			janela.dispose();
			listaNomes = new ControleProduto(dados).getNomeProd();
			listaProdsCadastrados = new JList<String>(listaNomes);
			frameProdutos = new JFrame("Produtos");
			titulo = new JLabel("Selecione um Produto");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaProdsCadastrados.setBounds(20, 50, 350, 120);
			listaProdsCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaProdsCadastrados.setVisibleRowCount(5);
			
			labelQtdItem.setBounds(30, 180, 150, 25);
			qtdItem.setBounds(105, 180, 30, 25);
			botaoAdicionar.setBounds(200, 180, 100, 30);	
			
			frameProdutos.setLayout(null);

			frameProdutos.add(titulo);
			frameProdutos.add(listaProdsCadastrados);
			frameProdutos.add(labelQtdItem);
			frameProdutos.add(qtdItem);
			frameProdutos.add(botaoAdicionar);

			frameProdutos.setSize(400, 250);
			frameProdutos.setVisible(true);
			
			//abre novamente o carrinho ao fechar a selecao de produtos
			frameProdutos.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        mostrarCarrinho(dados, posicao);
			    }
			});

			listaProdsCadastrados.addListSelectionListener((ListSelectionListener) this);
		}
		
		if(src == botaoAdicionar && prodSelec != null) {
			
			//botaoRemover[j].removeActionListener(this);
			botaoAdicionar.removeActionListener(this);
			botaoProdutos.removeActionListener(this);
			botaoFinalizar.removeActionListener(this);
			
			System.out.println("Botao Adicionar foi acionado");
			
			if (Integer.parseInt(qtdItem.getText()) > 0) {
				botaoAdicionar.addActionListener(this);
				for (int i = 0; i < 10; i++) {
					if (carrinho.getProdutos()[i] == null) {
	
						//System.out.println("OK for botaoAdd && prodSelec");
						carrinho.setProduto(prodSelec, i);
						//System.out.println("OK carProd  " + listaCarrinhoProd[i]);
						carrinho.setQuantidade(Integer.parseInt(qtdItem.getText()), i);
						//System.out.println("OK carQtd  " + listaCarrinhoQtd[i]);
						//qtdCarrinhoProd++;
						break;
					}
				}
				//Reseta o produto selecionado e fecha a janela de Selecao apos confirmar
				prodSelec = null;
				frameProdutos.dispose();
				mostrarCarrinho(dados, posicao);
			}
		}
			
			int j = 0;
			while(carrinho.getProdutos()[j] != null) {
				if(src == botaoRemover[j]) {
					
					botaoRemover[j].removeActionListener(this);
					botaoProdutos.removeActionListener(this);
					botaoAdicionar.removeActionListener(this);
					botaoFinalizar.removeActionListener(this);
					
					carrinho.removerDoCarrinho(j, botaoRemover);
					janela.dispose();
					mostrarCarrinho(dados, posicao);
					break;
				}
				j++;
				
			}
			
			if (src == botaoFinalizar) {
				System.out.println(labelCarrinho[0]);
				System.out.println("Botao finalizar foi acionado");
				/*int k = 0;
				while(carrinho.getProdutos()[k] != null) {
					System.out.println(carrinho.getProdutos()[k].getNome());
					System.out.println("valor de k: " + k);
					k++;
				}*/
				if (labelCarrinho[0] != null) {
					System.out.println("Finalizando Compra :D");
					carrinho.finalizarCompra(posicao, dados, opcaoPag);
					//System.out.println(dados.getRecibo(posicao)[dados.getQtdRecibos(posicao)].getCodigo());	
					//System.out.println(dados.getRecibo(posicao)[dados.getQtdRecibos(posicao)].getValor_total());	
					janela.dispose();				
				}
			}
		}
		
	}


