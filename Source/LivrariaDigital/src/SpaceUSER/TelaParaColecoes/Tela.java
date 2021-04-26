package SpaceUSER.TelaParaColecoes;

import SpaceUSER.Home.Tela.TelaHomeUser;
import TelaPadrao.Tela.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela extends TelaPadrao {
    private JPanel painelTitulo;
    private Usuario info;
    private String label;

    public Tela(Usuario info, String label) {
        super("Minha Coleção");
        this.info = info;
        this.label=label;

        this.addJPainelTitulo();
        this.addLabelsIntoPainel(label);
        this.addTabela();
        this.addButton();
        this.addLivros();
        this.addBackground();
        this.setVisible(true);
    }

    public void addJPainelTitulo(){
        painelTitulo = new JPanel();
        painelTitulo.setLayout(null);
        painelTitulo.setBounds(0,0,700,60);
        painelTitulo.setBackground(new Color(252, 203, 177, 163));
        this.add(this.painelTitulo);

    }

    public void addLabelsIntoPainel(String label){
        Font font = new Font("Impact",Font.PLAIN,40);
        JLabel colecao = new JLabel(label, JLabel.CENTER);
        colecao.setForeground(new Color(21, 27, 38, 248));
        colecao.setFont(font);
        colecao.setBounds(0, 5, 700, 45);
        this.painelTitulo.add(colecao);

    }

    public void addButton() {
        Color cor = new Color(102, 102, 102);
        Font font = new Font("Arial",Font.BOLD,13);
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(10, 325, 130, 30);
        voltar.setFont(font);
        voltar.setBackground(cor);
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaHomeUser(info);
            }
        });

        this.add(voltar);
    }
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };
    public void addLivros(){
        ArrayList<String> array;
        if(this.label.equals("Minhas compras")){
            array=info.getCompras();
        }else{
            array = info.getColecao();
        }
        for(String livro: array){
            String lista [] = livro.split(",");
            Object ob [] = {lista[0],lista[1],lista[2],lista[3]};
            modelo.addRow(ob);
        }
    }

    public void addTabela(){
        Font font = new Font("Arial",Font.PLAIN,13);
        modelo.addColumn("Título");
        modelo.addColumn("Tipo");
        modelo.addColumn("Gênero");
        modelo.addColumn("Resumo");

        JTable tabela = new JTable();
        tabela.setModel(modelo);
        tabela.setBounds(10, 70, 665, 250);
        tabela.getColumn("Título").setMaxWidth(340);
        tabela.getColumn("Tipo").setMaxWidth(220);
        tabela.getColumn("Gênero").setMaxWidth(220);
        tabela.getColumn("Resumo").setMaxWidth(110);
        tabela.getTableHeader().setFont(font);
        tabela.getTableHeader().setForeground(Color.black);

        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setFont(font);
        tabela.setRowHeight(30);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 70, 665, 250);


        this.add(scroll);
    }


}
