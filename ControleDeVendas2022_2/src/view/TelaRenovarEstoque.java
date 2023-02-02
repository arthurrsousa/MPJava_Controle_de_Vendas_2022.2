package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.*;
import model.Estoque;
import model.Produto;

public class TelaRenovarEstoque implements ActionListener, ListSelectionListener{

	private JFrame janela;
	private JLabel titulo;
	
	private String[] listaNomes = new String[50];
	private JList<String> listaProdsRenovar;
	
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
			valid = true;
			
		}
			
		if (valid) {
				botaoRenovar.addActionListener(this); //Botao Renovar so fara algo depois que um produto for selecionado				
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		boolean res;
		if (src == botaoRenovar) {

			Estoque estoqueSelec = dados.getEstoques()[listaProdsRenovar.getSelectedIndex()];
			res = dados.getFornecedor().renovar_estoque(estoqueSelec, Integer.parseInt(qtdRenovar.getText()), dados.getFluxoDeCaixa());
			
			if (res) {
				mensagemSucessoRenovacao();
			}else {
				System.out.println("chamando mensagem de erro");
				mensagemErroRenovacao();	
				botaoRenovar.removeActionListener(this);
			}
		}
		
	}
	
	public void mensagemSucessoRenovacao() {
		JOptionPane.showMessageDialog(null, "Estoque renovado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroRenovacao() {
		System.out.println("mensagem de erro");
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao renovar o estoque!\n"
				+ "Tenha certeza de que possui saldo suficiente em caixa", null, 
				JOptionPane.ERROR_MESSAGE);
		//janela.dispose();
	}
	
}
