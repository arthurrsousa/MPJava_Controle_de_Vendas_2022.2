package view;
import control.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.ControleDados;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

/**
 * Tela de Menu inicial do software que inicia um novo Controle de Dados.
 * @author Arthur Rodrigues Sousa
 *
 */
public class TelaMenu implements ActionListener  {
	private static JFrame janela = new JFrame("Controle de Vendas");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton vendedor = new JButton("Vendedor");
	private static JButton cliente = new JButton("Cliente");
	private static JButton produto = new JButton("Produto");
	private static JButton fornecedor = new JButton("Fornecedor");
	private static JButton fluxo = new JButton("fluxo");

	private static ImageIcon iconCliente = new ImageIcon("src//cliente1.png");
	private static ImageIcon iconFluxo = new ImageIcon("src//fluxo1.png");
	private static ImageIcon iconFornecedor = new ImageIcon("src//fornecedor7.png");
	private static ImageIcon iconProduto = new ImageIcon("src//produto1.png");
	private static ImageIcon iconVendedor = new ImageIcon("src//vendedor1.png");

	public static ControleDados dados = new ControleDados();
	ImageIcon icon = new ImageIcon("fluxo.png");
	
	/**
	 * Customizacao da janela e de seus botoes
	 */
	public TelaMenu() {
		titulo.setFont(new Font("MV Boli", Font.PLAIN, 50));
		titulo.setBounds(450, 10, 400, 100);
		titulo.setIcon(icon);
		
		vendedor.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,25));
		vendedor.setBounds(80, 170, 500, 100);
		vendedor.setIcon(iconVendedor); 
		
		produto.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,25));
		produto.setBounds(80, 300, 500, 100);
		produto.setIcon(iconProduto);
		
		cliente.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,25));
		cliente.setBounds(650, 170, 500, 100);
		cliente.setIcon(iconCliente);
		
		fornecedor.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,25));
		fornecedor.setBounds(650, 300, 500, 100);
		fornecedor.setIcon(iconFornecedor);
		
		fluxo.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE,25));
		fluxo.setBounds(350, 450, 500, 100);
		fluxo.setIcon(iconFluxo);
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(vendedor);
		janela.add(produto);
		janela.add(cliente);
		janela.add(fornecedor);
		janela.add(fluxo);
		
		janela.setSize(1366, 768);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		Color minhaCor = new Color(163, 59, 57);
		janela.getContentPane().setBackground(minhaCor);
		
		Color minhaCor2 = new Color(100, 100, 100);
		fluxo.setBackground(minhaCor2);
		fornecedor.setBackground(minhaCor2);
		cliente.setBackground(minhaCor2);
		produto.setBackground(minhaCor2);
		vendedor.setBackground(minhaCor2);
		
		
	}
	
	/**
	 * Adicao de ActionListener aos botoes para fazerem algo ao serem pressionados
	 */
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();		
		vendedor.addActionListener(menu);
		produto.addActionListener(menu);
		cliente.addActionListener(menu);
		fornecedor.addActionListener(menu);
		fluxo.addActionListener(menu);
	}
	
	/**
	 * Mostra uma nova tela com os dados da Classe selecionada
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		
		if(src == vendedor)
			new TelaLista().mostrarDados(dados, 1);
		
		if(src == produto)
			new TelaLista().mostrarDados(dados, 2);

		if(src == cliente)
			new TelaLista().mostrarDados(dados, 3);
		

	}
}
