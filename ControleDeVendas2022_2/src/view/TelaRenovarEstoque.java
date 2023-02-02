package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.*;
import model.Produto;

public class TelaRenovarEstoque implements ActionListener, ListSelectionListener{

	private JFrame janela;
	private JLabel titulo;
	
	private String[] listaNomes = new String[50];
	private JList<String> listaProdsRenovar;
	private Produto prodSelec;
	
	private JLabel labelQtdRenovar = new JLabel("Renovar: ");
	private JTextField qtdRenovar = new JTextField(String.valueOf(1), 200);
	private JButton botaoRenovar = new JButton("Renovar");
	
	private static ControleDados dados;

	
	public void mostrarProdutos(ControleDados d) {
		dados = d;
		listaNomes = new ControleProduto(dados).getNomeProd();
		listaProdsRenovar = new JList<String>(listaNomes);
		janela = new JFrame("Renovar Produtos");
		titulo = new JLabel("Selecione o Produto a ser Renovado");

		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setBounds(220, 10, 2000, 110);
		listaProdsRenovar.setBounds(150, 120, 500, 250);
		listaProdsRenovar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaProdsRenovar.setVisibleRowCount(10);
		
		labelQtdRenovar.setBounds(30, 400, 150, 25);
		qtdRenovar.setBounds(105, 400, 30, 25);
		botaoRenovar.setBounds(200, 400, 100, 30);

		janela.setLayout(null);
		janela.add(titulo);
		janela.add(listaProdsRenovar);
		janela.add(labelQtdRenovar);
		janela.add(qtdRenovar);
		janela.add(botaoRenovar);

		janela.setSize(800, 600);
		janela.setVisible(true);

		listaProdsRenovar.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		boolean valid = false;

		if(e.getValueIsAdjusting() && src == listaProdsRenovar) {
			prodSelec = dados.getProduto()[listaProdsRenovar.getSelectedIndex()];	
			valid = true;
			
		}
			
		if (valid) {
				botaoRenovar.addActionListener(this); //Botao Adicionar so fara algo depois que um produto for selecionado				
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == botaoRenovar) {
			//System.out.println("Renovar Estoque");
		}
		
	}
}
