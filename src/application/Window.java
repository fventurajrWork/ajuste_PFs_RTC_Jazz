package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import domain.Ajuste;
import helpers.PorExtenso;
import net.miginfocom.swing.MigLayout;

public class Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6;
	private JTextField pfOriginal, diasSuporte, pfAjustado, pfSuporte;
	private JTextField pfAjustadoPorExtenso, pfSuportePorExtenso;
	private JButton btnAjustar, btnProximoAjuste;
	private JSpinner mes;
	private JMenu help;
	private JMenuBar menuBar;

	private Font fonte = new Font("Helvetica", Font.PLAIN, 18);

	public Window() {
		super("Ajuste Ponto de Função - 1.0.5");
		setLayout(new MigLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 700, 350);
		setResizable(false);

		// instanciar...
		lbl1 = new JLabel("  PF Original:");
		pfOriginal = new JTextField(10); pfOriginal.setToolTipText("Informe o número de Pontos de Função integral");
		lbl2 = new JLabel("Suporte(dias):");
		diasSuporte = new JTextField(5); diasSuporte.setToolTipText("Selecione um número de 1 a 30 dias de suporte");
		lbl3 = new JLabel("  PF Ajustado:");
		pfAjustado = new JTextField(10);
		lbl4 = new JLabel("   PF Suporte:");
		pfSuporte = new JTextField(10);
		lbl5 = new JLabel(" PF Ajustado por extenso");
		pfAjustadoPorExtenso = new JTextField(50);
		lbl6 = new JLabel(" PF Suporte por extenso");
		pfSuportePorExtenso = new JTextField(50);
		
		
		btnAjustar = new JButton("Ajustar PF");
		btnAjustar.addActionListener(new btnAjustaPfListener());
		pfOriginal.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				 int tecla=e.getKeyCode();        
				    if (tecla==KeyEvent.VK_ENTER) 
					btnAjustar.doClick();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			
		});
		// btnAjustar.set
		btnProximoAjuste = new JButton("Próximo ajuste");
		btnProximoAjuste.addActionListener(new btnProximoAjusteListener());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		help = new JMenu("Help");
		menuBar.add(help);

		// Item de menu ABOUT
		JMenuItem about = new JMenuItem("about");
		about.addActionListener(new ActionListener() {
			String mensagem = "Ajuste de PF proporcional v1.05\n "
					+ "Objetivo: auxiliar no cálculo de pontos de função "
					+ "na troca de fábrica de sustentação\n" 
		            + "Tecnologia usada:\n"
					+ "     - Java Desktop com Swing\n" 
		            + "     - Layout usando o MigLayout\n"
					+ "Author: Fernando Ventura Jr.\n" 
		            + "Setembro-2022";

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});

		// Item de menu PENDÊNCIAS
		JMenuItem pendencias = new JMenuItem("pendências");
		pendencias.addActionListener(new ActionListener() {
			String mensagem = "Pendências:\n" 
		                    + " - Refatorar o código\n" 
		                    + " - Copiar para a área de transferência os resultados\n";

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, mensagem);
			}

		});

		// Item de menu APRENDIZADO
		JMenuItem aprendizado = new JMenuItem("aprendizado");
		aprendizado.addActionListener(new ActionListener() {

			String mensagem = "Aprendizados:\n" 
			        + " - Uso de JLabels como descritivos\n"
			        + " - Uso de JTextFields como componentes de entradas de dados\n"
					+ " - Uso de JSpinner como entrada de dados numérico\n"
					+ " - Uso de Menus usando JMenuBar, JMenu e JMenuItem para "
					+ "   informar sobre o sistema\n"
					+ " - Uso de JOptionPane para mostrar mensagens de erro\n"
					+ " - Uso de expressões regulares para validar a entrada de dados\n"
					+ " - Redefinição de fontes ( tamanho, família etc. )\n"
					+ " - Captura do <ENTER> no campo texto para acionar o botão de ajuste";

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, mensagem);
			}

		});

		help.add(about);
		help.add(pendencias);
		help.add(aprendizado);
		
		// Entrada do número de dias de suporte
		mes = new JSpinner();
		SpinnerNumberModel model = new SpinnerNumberModel(20, 1, 31, 1);
		mes.setModel(model);
		mes.setFont(fonte);
		
		// dimensionando as fontes
		lbl1.setFont(fonte);
		pfOriginal.setFont(fonte);
		lbl2.setFont(fonte);
		diasSuporte.setFont(fonte);
		lbl3.setFont(fonte);
		pfAjustado.setFont(fonte);
		lbl4.setFont(fonte);
		pfSuporte.setFont(fonte);
		lbl5.setFont(fonte);
		pfAjustadoPorExtenso.setFont(fonte);
		lbl6.setFont(fonte);
		pfSuportePorExtenso.setFont(fonte);

		// posicionando na tela...
		add(lbl1);
		add(pfOriginal, "span 2,  wrap");
		add(lbl2);
		add(mes, "wrap");
		add(lbl3);
		add(pfAjustado, "wrap");
		add(lbl4);
		add(pfSuporte, "wrap");
		add(lbl5, "span");
		add(pfAjustadoPorExtenso, "span 2, wrap");
		add(lbl6, "span");
		add(pfSuportePorExtenso, "span 2, wrap");
		add(btnAjustar);
		add(btnProximoAjuste);// add(btnEncerrar);
		btnAjustar.requestFocus();
		UIManager.put("btnAjustar.defaultButtonFollowsFocus", Boolean.TRUE);
		setVisible(true);
	}

	// Trata o ajustar de ponto de função
	class btnAjustaPfListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (!camposValidados())
				return;

			// RN3 - Calcular PF ajustada ao número de dias de suporte com duas casas
			// decimais
			Integer pf = Integer.parseInt(pfOriginal.getText());
			// Integer dias = Integer.parseInt(diasSuporte.getText());
			Integer dias = (Integer) mes.getValue();
			String pfCalculado = Ajuste.getPfAjustado(pf, dias);
			pfAjustado.setText(pfCalculado);
			String pfTrabalho = Ajuste.getPfSuporte();
			pfSuporte.setText(pfTrabalho);
			try {
				
				// PF ajustado
				pfAjustadoPorExtenso.setText(new PorExtenso().parseExtenso(pfCalculado));
				
				// PF trabalho
				pfSuportePorExtenso.setText(new PorExtenso().parseExtenso(pfTrabalho));
				

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}

		private Boolean camposValidados() {
			// pfOriginal deve ser um inteiro entre 5 e 9.999 representando pontos de função
			// do sistema suportado.
			String pf = pfOriginal.getText();
			// Testar se é numérico
			if (!pf.matches("[0-9]{1,4}")) {
				pfOriginal.setText("");
				pfOriginal.requestFocus();
				JOptionPane.showMessageDialog(null, "PF deve ser numérico entre 5 e 9.999");
				return false;
			}
			return true;
		}

	}

	class btnProximoAjusteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			pfOriginal.setText(""); // Limpa os campo de pf e de resultados
									// ... mas mantém o campo de dias de suporte intacto
			pfAjustado.setText("");
			pfSuporte.setText("");
			pfAjustadoPorExtenso.setText("");
			pfSuportePorExtenso.setText("");
			pfOriginal.requestFocus();
		}

	}

	public static void main(String[] args) {
		new Window();
	}

}
