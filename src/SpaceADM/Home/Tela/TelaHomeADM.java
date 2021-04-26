package SpaceADM.Home.Tela;

import SpaceADM.Home.Ouvinte.OuvinteDosButtons;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import TelaPadrao.Tela.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class TelaHomeADM extends TelaPadrao {

    private final JPanel JP_PAINEL =  new JPanel();


    public TelaHomeADM() {
        super("Home - Livreiro");
        this.addPainel();
        this.addLabels();
        this.addButtons();
        this.addBackground();
        this.setVisible(true);
    }

    public void addPainel() {
        this.JP_PAINEL.setBounds(200, 15, 300, 330);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(null);
        this.add(JP_PAINEL);
    }


    public String getNomeLivreiro() {
        try{
            Persistencia persistencia = Persistencia.getUnicaInstancia();
            CentralDeInformacoes central= persistencia.recuperar();
            String [] nome = central.getLivreiro().getNome().split(" ");

            return nome[0]+" "+nome[1];
        }catch (Exception e){
            return "Livreiro";
        }
    }

    public void addLabels() {
        JLabel bemvindo = new JLabel("Bem vindo(a),", JLabel.CENTER);
        JLabel nome = new JLabel(getNomeLivreiro() + "!", JLabel.CENTER);
        Font font = new Font("Arial",Font.BOLD,20);

        bemvindo.setBounds(0, 10, 300, 60);
        bemvindo.setFont(font);
        bemvindo.setForeground(Color.WHITE);

        nome.setBounds(0, 55, 300, 20);
        nome.setFont(font);
        nome.setForeground(Color.WHITE);


        this.JP_PAINEL.add(bemvindo);
        this.JP_PAINEL.add(nome);
    }

    public void addButtons() {
        Color cor = new Color(102, 102, 102);
        Font font = new Font("Arial",Font.BOLD,13);

        OuvinteDosButtons ouvinte = new OuvinteDosButtons(this);
        JButton cadastrar = new JButton("Cadastrar Livro");
        JButton loja = new JButton("Ver a loja");
        JButton interessados = new JButton("Mais interessados");
        JButton visualizados = new JButton("Mais visualizados");
        JButton planilha = new JButton("Carregar planilha");
        JButton sair = new JButton("Sair");


        cadastrar.setBounds(75, 90, 150, 25);
        cadastrar.addActionListener(ouvinte);
        cadastrar.setFont(font);
        cadastrar.setBackground(cor);
        cadastrar.setBorder(null);

        loja.setBounds(75, 130, 150, 25);
        loja.addActionListener(ouvinte);
        loja.setFont(font);
        loja.setBackground(cor);
        loja.setBorder(null);

        interessados.setBounds(75, 170, 150, 25);
        interessados.addActionListener(ouvinte);
        interessados.setFont(font);
        interessados.setBackground(cor);
        interessados.setBorder(null);

        visualizados.setBounds(75, 210, 150, 25);
        visualizados.addActionListener(ouvinte);
        visualizados.setFont(font);
        visualizados.setBackground(cor);
        visualizados.setBorder(null);

        planilha.setBounds(75, 250, 150, 25);
        planilha.addActionListener(ouvinte);
        planilha.setFont(font);
        planilha.setBackground(cor);
        planilha.setBorder(null);

        sair.setBounds(75, 290, 150, 25);
        sair.addActionListener(ouvinte);
        sair.setFont(font);
        sair.setBackground(new Color(229, 33, 33));
        sair.setBorder(null);


        this.JP_PAINEL.add(cadastrar);
        this.JP_PAINEL.add(loja);
        this.JP_PAINEL.add(interessados);
        this.JP_PAINEL.add(visualizados);
        this.JP_PAINEL.add(planilha);
        this.JP_PAINEL.add(sair);

    }




}
