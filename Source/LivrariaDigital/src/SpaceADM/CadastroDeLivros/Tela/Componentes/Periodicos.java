package SpaceADM.CadastroDeLivros.Tela.Componentes;


import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Ouvintes.OuvinteKeyBord;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Superclasse.SuperclasseTipos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Periodicos extends SuperclasseTipos implements ComponentesAddNaTela {
    private final ArrayList<JComponent> COMPONENTES = new ArrayList<JComponent>();
    private JTextField numero,autor;
    private JComboBox meses;

    public Periodicos() {
        this.addComponentesDaSuperclasse();
        this.addFormLabel();
        this.addInputs();
        this.addCombos();
    }

    public void addComponentesDaSuperclasse(){
        this.COMPONENTES.add(GENERO);
        this.COMPONENTES.add(LABEL_GENERO);
    }

    @Override
    public String[] getGeneros() {
        return new String[] {"Gibi", "Revista de notícias"};
    }

    public void addFormLabel() {
        Font font2 = new Font("Arial",Font.BOLD,17);
        JLabel mes = new JLabel("  Mês de lançamento:", JLabel.LEFT);
        JLabel numero = new JLabel("  Número da edição:", JLabel.LEFT);
        JLabel autor = new JLabel("Autor: ", JLabel.CENTER);

        autor.setBounds(0,445,170,20);
        autor.setFont(FONT);

        mes.setBounds(0, 410, 170, 20);
        mes.setFont(FONT);

        numero.setBounds(0, 478, 170, 20);
        numero.setFont(FONT);

        COMPONENTES.add(mes);
        COMPONENTES.add(numero);
        COMPONENTES.add(autor);
    }
    public void addInputs() {
        autor = new JTextField();
        autor.setBounds(165,443,110,30);
        autor.setForeground(COR_PADRAO);
        autor.setFont(FONT);

        numero = new JTextField();
        numero.setBounds(165, 476, 110, 30);
        numero.setForeground(COR_PADRAO);
        numero.addKeyListener(new OuvinteKeyBord());
        numero.setFont(FONT);


        COMPONENTES.add(numero);
        COMPONENTES.add(autor);

    }
    public void addCombos() {
        String[] arrayMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        meses = new JComboBox(arrayMeses);
        meses.setBackground(Color.DARK_GRAY);
        meses.setFont(FONT);
        meses.setBounds(165, 408, 110, 30);
        meses.setForeground(COR_PADRAO);

        COMPONENTES.add(meses);


    }


    @Override
    public ArrayList<JComponent> getComponentes() {
        return COMPONENTES;
    }

    @Override
    public ArrayList<String> getInfo() {

        ArrayList<String> informacoes = new ArrayList<String>();
        informacoes.add((String) GENERO.getSelectedItem());
        informacoes.add((String) meses.getSelectedItem());
        informacoes.add(autor.getText());
        informacoes.add(numero.getText());

        return informacoes;
    }

    @Override
    public int getMaiorAltura() {
        return 478;
    }

    @Override
    public String getTipo() {
        return "Periódicos";
    }

}
