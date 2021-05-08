package SpaceADM.CarregarPlanilha.Tela;


import DynamicLayout.DynamicLayout;
import SpaceADM.CarregarPlanilha.Model.GenerosAndTipos;
import SpaceADM.CarregarPlanilha.Model.JLabelIntoCedula;
import SpaceADM.CarregarPlanilha.Model.Livraria;
import SpaceADM.CarregarPlanilha.Model.LivrariaTableModel;
import SpaceADM.CarregarPlanilha.Ouvintes.OuvinteDosJButtons;
import SpaceADM.Home.Tela.TelaHomeADM;
import TelaPadrao.Tela.TelaPadrao;
import Utilitarios.BackupLivros.CentralBackup;
import Utilitarios.BackupLivros.PersistenciaSingleton;


import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class TelaCarregarPlanilha extends TelaPadrao {
    private static LivrariaTableModel model1;
    private final Font FONT = new Font("Arial",Font.BOLD,15);

    public static LivrariaTableModel getModel1() {
        return model1;
    }

    public TelaCarregarPlanilha() {
        super("Carregar Planilha");
        this.setSize(700,460);
        this.setLayout(new DynamicLayout(700,460));
        this.addJButtons();
        this.addModeloDaTabel();
        this.addTabela1();
        this.addBackground();
        this.setVisible(true);
    }

    public void addModeloDaTabel(){
        this.model1 = new LivrariaTableModel();


    }
    public void addTabela1(){
        Font font = new Font("Arial",Font.BOLD,12);
        JTable tabel = new JTable(this.model1);

        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabel.getColumnModel().getColumn(8).setPreferredWidth(200);
        tabel.setBackground(new Color(179, 179, 179));
        tabel.setSelectionBackground(new Color(146, 146, 146));
        tabel.setForeground(Color.BLACK);
        tabel.setDefaultRenderer(Object.class, new JLabelIntoCedula());
        tabel.setFont(font);
        tabel.setLayout(new DynamicLayout(600,300));

        TableColumn colunas[]= new TableColumn[3];
        int element[]={0,8,9};
        for (int i = 0; i <3 ; i++) {
            colunas[i] = tabel.getColumnModel().getColumn(element[i]);
        }

        for(int i =0;i<13;i++){
            if(i!=0&&i!=8){
                tabel.getColumnModel().getColumn(i).setPreferredWidth(110);
            }
        }

        String[] tipos ={"Literatura", "Desenvolvimento Pessoal", "Periódicos","Técnico"};
        String[] generos ={
                "Literatura Brasileira (L)",
                "Literatura Estrangeira (L)",
                "Infanto Juvenil (L)",
                "Artes (L)",
                "Biografia (L)",
                "Poesia (L)",
                "Autoajuda (DV P)","Religião (DV P)","Saúde (DV P)",
                "Gibi (P)", "Revista de notícias (P)",
                "Paradidático (T)","Formação Profissional (T)"
        };
        String[] meses = {"","Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        JComboBox comboTipos = new JComboBox(tipos);
        comboTipos.setForeground(Color.black);

        JComboBox comboGeneros = new JComboBox(generos);
        comboGeneros.setForeground(Color.black);

        JComboBox comboMeses = new JComboBox(meses);
        comboGeneros.setForeground(Color.black);

        colunas[0].setCellEditor(new GenerosAndTipos(comboTipos));
        colunas[1].setCellEditor(new GenerosAndTipos(comboGeneros));
        colunas[2].setCellEditor(new GenerosAndTipos(comboMeses));


        JScrollPane scroll = new JScrollPane(tabel);
        scroll.getViewport().setBackground(new Color(179, 179, 179));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(50,25,600,300);

        this.add(scroll);
    }
    private class OuvinteBackup implements ActionListener {
        public void testeGeneros(ArrayList<String> info, int numeroDaLinha) throws Exception {
            String tipo = info.get(0).toLowerCase();
            String generoString =
                    "literatura,periódicos,desenvolvimento pessoal,técnico";

            ArrayList<String> generos = new ArrayList<>(
                    Arrays.asList(generoString.split(",")));
            String[][] matrizGenero = {
                    {"literatura brasileira" +
                            "literatura estrangeira" +
                            "infanto juvenil" +
                            "artes" +
                            "biografia" +
                            "poesia"},
                    {"gibi revista de notícias"},
                    {"autoajuda religião saúde"},
                    {"paradidático formação profissional"}

            };
            int index = generos.indexOf(tipo);
            if (index != -1) {
                if ((!matrizGenero[index][0].contains(info.get(8).toLowerCase())) ||
                        info.get(8).equals(" ") || info.get(8).equals("")) {
                    throw new Exception("Escolha um Gênero de " + tipo);
                }
            } else {
                throw new Exception("Livro na linha: " + numeroDaLinha + 1 + " Não reconhecido");
            }
        }
        public void btnFazerBackup() {
            if (model1.getRowCount() != 0) {
                CentralBackup central = new CentralBackup();
                for (int i = 0; i < model1.getRowCount(); i++) {
                    ArrayList<Object> info = new ArrayList<>();
                    for (int j = 0; j < 13; j++) {
                        model1.getValueAt(i,j);
                        if(model1.getValueAt(i,j)!=null){
                            info.add(model1.getValueAt(i,j));
                        }else{
                            info.add("");
                        }
                    }
                    central.addLivros(info);
                }
                central.salvar();
                JOptionPane.showMessageDialog(null,"Feito com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Nenhum dado na Planilha");
            }
        }


    public void btnAbrirBackup(){
        CentralBackup central = PersistenciaSingleton.getUnicaInstancia().recuperar();
        ArrayList<Livraria> livros = central.getLivros();
        for (int i = 0; i < livros.size(); i++) {
            model1.addRow(livros.get(i));
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Fazer Backup")) {
            this.btnFazerBackup();
        }else{
            this.btnAbrirBackup();
        }
    }
}

    public void addJButtons(){
        JButton carregar = new JButton("Carregar");
        JButton addLinha = new JButton("Adicionar Linha");
        JButton removeLinha = new JButton("Remover Linha");
        JButton limparTabela = new JButton("Limpar Tabela");
        JButton voltar = new JButton("Voltar");
        JButton fazerBackup = new JButton("Fazer Backup");
        JButton recuperarBackup = new JButton("Abrir Backup");

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

        voltar.setBounds(90,390,160,30);
        voltar.setForeground(Color.BLACK);
        voltar.setFont(FONT);
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaHomeADM();
            }
        });

        fazerBackup.setBounds(270,390,160,30);
        fazerBackup.setForeground(Color.BLACK);
        fazerBackup.addActionListener(new OuvinteBackup());
        fazerBackup.setFont(FONT);

        recuperarBackup.setBounds(450,390,160,30);
        recuperarBackup.setForeground(Color.BLACK);
        recuperarBackup.addActionListener(new OuvinteBackup());
        recuperarBackup.setFont(FONT);


        this.add(carregar);
        this.add(addLinha);
        this.add(removeLinha);
        this.add(limparTabela);
        this.add(voltar);
        this.add(fazerBackup);
        this.add(recuperarBackup);


    }

}
