package simuladorMemoria;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Tela extends JFrame {

    private JTextField textField_1;
    private JTextField textField_2;
    private  JMenuBar menuBar;
    private  JMenu arquivos;
    private JMenuItem cache;
    private JMenuItem sair;
    private JMenu config;
    private JMenuItem direto;
    private JMenu associativo;
    private JMenuItem rando;
    private JMenuItem contador;
    private JMenuItem lfu;
    private JMenuItem lru;
    private JMenu aEmConj;
    private JMenu ajuda;
    private JMenuItem sobre;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel lblMiss;
    private JLabel lblHit;
    private JLabel lblNomeDoMetodo;
    private JLabel lblMemria;
    private JLabel lblCache;

    Leitor ler = new Leitor();
    Leitor a;
    Sistema sistema = new Sistema();

    public Tela() {
        super("Using JMenus");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        arquivos = new JMenu("Arquivos");
        menuBar.add(arquivos);

        cache = new JMenuItem("Sistema");
        arquivos.add(cache);

        sair = new JMenuItem("Sair");
        arquivos.add(sair);

        config = new JMenu("Configurações");
        menuBar.add(config);

        direto = new JMenuItem("Direto");
        config.add(direto);

        associativo = new JMenu("Associativo");
        config.add(associativo);

        rando = new JMenuItem("Randômica");
        associativo.add(rando);

        contador = new JMenuItem("Contador");
        associativo.add(contador);

        lfu = new JMenuItem("LFU");
        associativo.add(lfu);

        lru = new JMenuItem("LRU");
        associativo.add(lru);

        aEmConj = new JMenu("Ass. em Conjunto");
        config.add(aEmConj);

        ajuda = new JMenu("Ajuda");
        menuBar.add(ajuda);

        sobre = new JMenuItem("Sobre");
        ajuda.add(sobre);

        cache.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    JFileChooser arquivos = new JFileChooser();
                    arquivos.setCurrentDirectory(new File("/home/lucas/Documentos/simuladorMemoria"));
                    if(arquivos.showSaveDialog(cache)==0){

                        a = ler.addDados(arquivos.getSelectedFile().getAbsolutePath());
                        telinha(false,a.getMem(),a.getCache(),a.getmMem(),a.getmCac(),0,0,"Nome do Metodo");
                        panel.repaint();
                        panel.setVisible(true);
                        telinha(true,a.getMem(),a.getCache(),a.getmMem(),a.getmCac(),0,0,"Nome do Metodo");

                    }

                }catch (Exception s){
                    System.out.println(s);
                }

            }
        });

        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(Tela.this, "Lucas Adriano Ribeiro", "Sobre", JOptionPane.PLAIN_MESSAGE);
            }
        });

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        direto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    JFileChooser arquivos = new JFileChooser();
                    arquivos.setCurrentDirectory(new File("/home/lucas/Documentos/simuladorMemoria"));
                    if(arquivos.showSaveDialog(cache)==0){

                        ler.addMemoria(arquivos.getSelectedFile().getAbsolutePath(),0);
                        sistema.aDireto(sistema.getListaAcessos(), sistema.getCache());
                        telinha(false,a.getMem(),a.getCache(),a.getmMem(),
                                a.getmCac(),0,0,"Direto");
                        panel.repaint();
                        panel.setVisible(true);
                        telinha(true,a.getMem(),a.getCache(),a.getmMem()
                                ,a.getmCac(),sistema.getMiss(),sistema.getHit(),"Direto");
                        


                    }

                }catch (Exception s){
                    System.out.println(s);
                }

            }
        });

        rando.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    JFileChooser arquivos = new JFileChooser();
                    arquivos.setCurrentDirectory(new File("/home/lucas/Documentos/simuladorMemoria"));
                    if(arquivos.showSaveDialog(cache)==0){

                        ler.addMemoria(arquivos.getSelectedFile().getAbsolutePath(),1);
                        sistema.randomico(sistema.getListaAcessos(), sistema.getCache());
                        telinha(false,a.getMem(),a.getCache(),a.getmMem(),
                                a.getmCac(),0,0,"Randomico");
                        panel.repaint();
                        panel.setVisible(true);
                        telinha(true,a.getMem(),a.getCache(),a.getmMem()
                                ,a.getmCac(),sistema.getMiss(),sistema.getHit(),"Randomico");


                    }

                }catch (Exception s){
                    System.out.println(s.fillInStackTrace());
                }

            }
        });

        contador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    JFileChooser arquivos = new JFileChooser();
                    arquivos.setCurrentDirectory(new File("/home/lucas/Documentos/simuladorMemoria"));
                    if(arquivos.showSaveDialog(cache)==0){

                        ler.addMemoria(arquivos.getSelectedFile().getAbsolutePath(),1);
                        sistema.contador(sistema.getListaAcessos(), sistema.getCache());
                        telinha(false,a.getMem(),a.getCache(),a.getmMem(),
                                a.getmCac(),0,0,"Contador");
                        panel.repaint();
                        panel.setVisible(true);
                        telinha(true,a.getMem(),a.getCache(),a.getmMem()
                                ,a.getmCac(),sistema.getMiss(),sistema.getHit(),"Contador");


                    }

                }catch (Exception s){
                    System.out.println(s.fillInStackTrace());
                }

            }
        });

        lfu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    JFileChooser arquivos = new JFileChooser();
                    arquivos.setCurrentDirectory(new File("/home/lucas/Documentos/simuladorMemoria"));
                    if(arquivos.showSaveDialog(cache)==0){

                        ler.addMemoria(arquivos.getSelectedFile().getAbsolutePath(),1);
                        sistema.LFU(sistema.getListaAcessos(), sistema.getCache());
                        telinha(false,a.getMem(),a.getCache(),a.getmMem(),
                                a.getmCac(),0,0,"LFU");
                        panel.repaint();
                        panel.setVisible(true);
                        telinha(true,a.getMem(),a.getCache(),a.getmMem()
                                ,a.getmCac(),sistema.getMiss(),sistema.getHit(),"LFU");

                    }

                }catch (Exception s){
                    System.out.println(s.fillInStackTrace());
                }

            }
        });

        lru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    JFileChooser arquivos = new JFileChooser();
                    arquivos.setCurrentDirectory(new File("/home/lucas/Documentos/simuladorMemoria"));
                    if(arquivos.showSaveDialog(cache)==0){

                        ler.addMemoria(arquivos.getSelectedFile().getAbsolutePath(),1);
                        sistema.LRU(sistema.getListaAcessos(), sistema.getCache());
                        telinha(false,a.getMem(),a.getCache(),a.getmMem(),
                                a.getmCac(),0,0,"LRU");
                        panel.repaint();
                        panel.setVisible(true);
                        telinha(true,a.getMem(),a.getCache(),a.getmMem()
                                ,a.getmCac(),sistema.getMiss(),sistema.getHit(),"LRU");

                    }

                }catch (Exception s){
                    System.out.println(s);
                }

            }
        });
    }


    private void telinha(boolean controle,int mem,int cache,String M,String C,int miss,int hit,String nome){

        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(35, 133, 375, 108);
        panel.add(panel_1);
        panel_1.setLayout(null);

        lblMiss = new JLabel("Miss:");
        lblMiss.setBounds(12, 40, 70, 15);
        panel_1.add(lblMiss);

        lblHit = new JLabel("Hit:");
        lblHit.setBounds(12, 75, 70, 15);
        panel_1.add(lblHit);

        textField_1 = new JTextField();
        textField_1.setBounds(69, 38, 114, 19);
        panel_1.add(textField_1);
        textField_1.setText(""+hit);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(69, 73, 114, 19);
        panel_1.add(textField_2);
        textField_2.setText(""+miss);
        textField_2.setColumns(10);

        lblNomeDoMetodo = new JLabel(nome);
        lblNomeDoMetodo.setBounds(110, 12, 153, 15);
        panel_1.add(lblNomeDoMetodo);

        lblMemria = new JLabel("Memória: "+mem+""+M);
        lblMemria.setBounds(35, 31, 120, 15);
        panel.add(lblMemria);

        lblCache = new JLabel("Cache: "+cache+""+C);
        lblCache.setBounds(35, 60, 120, 15);
        panel.add(lblCache);

        if(controle){
            panel.setVisible(controle);
            panel.repaint();
        }else{
            panel.setVisible(false);
        }




    }

}



