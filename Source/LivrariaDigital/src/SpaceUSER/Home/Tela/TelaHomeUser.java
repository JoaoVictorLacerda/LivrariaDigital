package SpaceUSER.Home.Tela;

import SpaceUSER.Home.Ouvinte.OuvinteDosJButtons;
import TelaPadrao.Tela.TelaPadrao;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;

import javax.swing.*;
import java.awt.*;

public class TelaHomeUser extends TelaPadrao {
    private final JPanel JP_PAINEL =  new JPanel();

    private String nome;
    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public TelaHomeUser(Usuario user) {
        super("Home - Cliente");
        this.nome = user.getNome();
        this.user = user;
        this.addPainel();
        this.addLabels();
        this.addButtons();
        this.addBackground();
        this.setVisible(true);
    }



    public void addLabels() {
        JLabel bemvindo = new JLabel("Bem vindo(a),", JLabel.CENTER);
        JLabel nome = new JLabel(this.nome, JLabel.CENTER);
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
        OuvinteDosJButtons ouvinte = new OuvinteDosJButtons(this);

        Color cor = new Color(102, 102, 102);
        Font font = new Font("Arial",Font.BOLD,13);

        JButton loja = new JButton("Ir para a loja");
        JButton comprados = new JButton("Livros comprados");
        JButton colecao = new JButton("Minha coleção");
        JButton sair = new JButton("Sair");
        JButton apagarConta = new JButton("Apagar Conta");

        loja.setBounds(75, 110, 150, 25);
        loja.addActionListener(ouvinte);
        loja.setFont(font);
        loja.setBackground(cor);
        loja.setBorder(null);

        comprados.setBounds(75, 150, 150, 25);
        comprados.setFont(font);
        comprados.addActionListener(ouvinte);
        comprados.setBackground(cor);
        comprados.setBorder(null);

        colecao.setBounds(75, 190, 150, 25);
        colecao.setFont(font);
        colecao.addActionListener(ouvinte);
        colecao.setBackground(cor);
        colecao.setBorder(null);

        sair.setBounds(75, 230, 150, 25);
        sair.setFont(font);
        sair.setBackground(new Color(229, 33, 33));
        sair.addActionListener(ouvinte);
        sair.setBorder(null);
        
        apagarConta.setBounds(75, 265, 150, 25);
        apagarConta.setFont(font);
        apagarConta.setBackground(new Color(229, 33, 33));
        apagarConta.addActionListener(ouvinte);
        apagarConta.setBorder(null);

        this.JP_PAINEL.add(loja);
        this.JP_PAINEL.add(comprados);
        this.JP_PAINEL.add(colecao);
        this.JP_PAINEL.add(sair);
        this.JP_PAINEL.add(apagarConta);
    }

    public void addPainel() {
        this.JP_PAINEL.setBounds(200, 15, 300, 330);
        this.JP_PAINEL.setBackground(Color.DARK_GRAY);
        this.JP_PAINEL.setLayout(null);
        this.add(JP_PAINEL);
    }



}
