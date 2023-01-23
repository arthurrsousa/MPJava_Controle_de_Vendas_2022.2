package view;
import control.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import control.*;
import java.awt.Font;

/**
 * Tela de Menu inicial do software que inicia um novo Controle de Dados.
 * @author Arthur Rodrigues Sousa
 *
 */
public class TelaMenu implements ActionListener {
	private static JFrame janela = new JFrame("Controle de Vendas");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton vendedor = new JButton("Vendedor");
	private static JButton cliente = new JButton("Cliente");
	private static JButton produto = new JButton("Produto");
	private static JButton fornecedor = new JButton("Fornecedor");
	private static JButton fluxo = new JButton("fluxo");
	private static ImageIcon iconCliente = new ImageIcon("D:\\desktop\\icons\\cliente1.png");
	private static ImageIcon iconFluxo = new ImageIcon("D:\\\\\\\\desktop\\\\\\\\icons\\\\\\\\fluxo1.png");
	private static ImageIcon iconFornecedor = new ImageIcon("D:\\\\desktop\\\\icons\\\\fornecedor7.png");
	private static ImageIcon iconProduto = new ImageIcon("D:\\\\desktop\\\\icons\\\\produto1.png");
	private static ImageIcon iconVendedor = new ImageIcon("D:\\\\desktop\\\\icons\\\\vendedor1.png");
	public static ControleDados dados = new ControleDados();
	ImageIcon icon = new ImageIcon("fluxo.png");
	
	/**
	 * Customizacao da janela e de seus botoes
	 */
	
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);
		vendedor.setBounds(140, 50, 100, 30);
		produto.setBounds(140, 100, 100, 30);
		cliente.setBounds(140, 150, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(vendedor);
		janela.add(produto);
		janela.add(cliente);
		
		janela.setSize(400, 250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	/**
	 * Adicao de ActionListener aos botoes para fazerem algo ao serem pressionados
	 */
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		vendedor.addActionListener(menu);
		produto.addActionListener(menu);
		cliente.addActionListener(menu);
	}
	
	/**
	 * Mostra uma nova tela com os dados da Classe selecionada
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		/*
		if(src == vendedor)
			new TelaLista().mostrarDados(dados, 1);
		
		if(src == produto)
			new TelaLista().mostrarDados(dados, 2);

		if(src == cliente)
			new TelaLista().mostrarDados(dados, 3);
		*/
	}
}
