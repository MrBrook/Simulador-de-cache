package simuladorMemoria;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;

public class InterfaceGrafica extends JFrame {
	
	private JPanel painel;
	private JPanel painel2;
	private JFrame janela;
	private JFrame selecionador;
	private JMenu menuArquivo;
	private JMenu menuEditar;
	private JMenu menuAjuda;
	private JTabbedPane abas;
	private JMenuItem itens;
	private JMenuItem sobre;
	private JMenuItem sair;
	private JMenuItem mD;
	private JMenuItem mA;
	private JMenuItem mAC;
	private JMenuBar barra;


	
	Leitor ler = new Leitor();
	
	public InterfaceGrafica(){
		super("Using JMenus");
		
		painel = new JPanel();
		painel.setLayout(null);
		///painel.setBackground(new Color(100,100,100));
		//painel.setSize(600, 500);

		painel2 = new JPanel();

		
		janela = new JFrame("Simulador de Cache");
		janela.setBounds(0, 15,600, 400);
		janela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		
		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');

		abas = new JTabbedPane();
		abas.addTab("teste",painel2);
		abas.add(painel2);

		selecionador =  new JFrame();
		selecionador.setBounds(0, 15,300, 200);
		//selecionador.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		selecionador.setResizable(false);
		selecionador.setLocationRelativeTo(null);

		itens = new JMenuItem("Novo");
		itens.setMnemonic('N');

		sair = new JMenuItem("Sair");
		sair.setMnemonic('S');
		menuArquivo.add(itens);
		menuArquivo.add(sair);
				
		menuEditar = new JMenu("Editar");
		menuEditar.setMnemonic('E');
		
		mD = new JMenuItem("Map. Direto");
		mD.setMnemonic('D');
		mA = new JMenuItem("Map. Associativo");
		mA.setMnemonic('A');
		mAC = new JMenuItem("Map. Assoc. em Conjunto");
		mAC.setMnemonic('C');
		menuEditar.add(mD);
		menuEditar.add(mA);
		menuEditar.add(mAC);
		
		menuAjuda = new JMenu("Sobre");
		menuAjuda.setMnemonic('S');
		
		sobre = new JMenuItem("Ajuda");
		sobre.setMnemonic('A');
		menuAjuda.add(sobre);
			
		barra = new JMenuBar();
		setJMenuBar(barra);
		barra.setBounds(MAXIMIZED_HORIZ, 0, 600, 30);;
		barra.add(menuArquivo);
		barra.add(menuEditar);
		barra.add(menuAjuda);
	
		painel.add(barra);
		//painel.add(abas);
		//janela.add(abas);
		janela.setContentPane(painel);
		//janela.setContentPane(painel2);
		janela.setVisible(true);
		
		itens.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event) {
						try{

							selecionador.setVisible(true);

							JFileChooser arquivos = new JFileChooser();
							arquivos.setCurrentDirectory(new File("/home/lucas/Documentos/simuladorMemoria"));
							if(arquivos.showSaveDialog(itens)==0){
								ler.addDados(arquivos.getSelectedFile().getAbsolutePath());
							}

						}catch (Exception e){
							System.out.println(e);
						}
					}
				}
		);

		sobre.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						JOptionPane.showMessageDialog(InterfaceGrafica.this,
								"Lucas Adriano Ribeiro",
								"Sobre", JOptionPane.PLAIN_MESSAGE);
					}
				}
		);

		sair.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				}
		);
	}
	
}