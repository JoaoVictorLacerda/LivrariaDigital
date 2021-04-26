package SpaceADM.CarregarPlanilha.Tela;


import SpaceADM.CarregarPlanilha.Ouvintes.OuvinteDosJButtons;
import SpaceADM.Home.Tela.TelaHomeADM;
import TelaPadrao.Tela.TelaPadrao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaCarregarPlanilha extends TelaPadrao {
    private final Font FONT = new Font("Arial",Font.BOLD,15);
    private DefaultTableModel model1;

    public DefaultTableModel getModel1() {
        return model1;
    }

    public TelaCarregarPlanilha() {
        super("Carregar Planilha");
        this.setSize(700,460);
        this.addJButtons();
        this.addModeloDaTabel();
        this.addTabela1();
        this.addBackground();
        this.setVisible(true);
    }

    public void addModeloDaTabel(){
        this.model1 = new DefaultTableModel();
        this.model1.addColumn("Tipo");
        this.model1.addColumn("Título");
        this.model1.addColumn("Ano");
        this.model1.addColumn("Resumo");
        this.model1.addColumn("Idioma");
        this.model1.addColumn("Editora");
        this.model1.addColumn("Quantidade");
        this.model1.addColumn("Preço");
        this.model1.addColumn("Genero");
        this.model1.addColumn("Mês");
        this.model1.addColumn("Autore(s)");
        this.model1.addColumn("N° Edição");
        this.model1.addColumn("Assunto");

    }
    public void addTabela1(){
        Font font = new Font("Arial",Font.BOLD,12);
        JTable tabel = new JTable(this.model1);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabel.setBackground(new Color(179, 179, 179));
        tabel.setForeground(Color.BLACK);
        tabel.setFont(font);


        JScrollPane scroll = new JScrollPane(tabel);
        scroll.getViewport().setBackground(new Color(179, 179, 179));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(50,25,600,300);

        this.add(scroll);
    }

    public void addJButtons(){
        JButton carregar = new JButton("Carregar");
        JButton addLinha = new JButton("Adicionar Linha");
        JButton removeLinha = new JButton("Remover Linha");
        JButton limparTabela = new JButton("Limpar Tabela");
        JButton voltar = new JButton("Voltar");

        OuvinteDosJButtons ouvinte = new OuvinteDosJButtons(this);


        carregar.setBounds(10,350,160,30);
        carregar.addActionListener(ouvinte);
        carregar.setForeground(Color.BLACK);
        carregar.setFont(FONT);


        removeLinha.setBounds(355,350,160,30);
        removeLinha.addActionListener(ouvinte);
        removeLinha.setForeground(Color.BLACK);
        removeLinha.setFont(FONT);

        addLinha.setBounds(530,350,160,30);
        addLinha.addActionListener(ouvinte);
        addLinha.setForeground(Color.BLACK);
        addLinha.setFont(FONT);

        limparTabela.setBounds(185,350,160,30);
        limparTabela.addActionListener(ouvinte);
        limparTabela.setForeground(Color.BLACK);
        limparTabela.setFont(FONT);

        voltar.setBounds(265,390,160,30);
        voltar.setForeground(Color.BLACK);
        voltar.setFont(FONT);
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaHomeADM();
            }
        });

 
        this.add(carregar);
        this.add(addLinha);
        this.add(removeLinha);
        this.add(limparTabela);
        this.add(voltar);


    }

}
