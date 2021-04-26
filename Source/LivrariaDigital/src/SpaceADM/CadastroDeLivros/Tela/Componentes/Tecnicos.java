package SpaceADM.CadastroDeLivros.Tela.Componentes;

import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Superclasse.SuperclasseTipos;

import javax.swing.*;
import java.util.ArrayList;

public class Tecnicos extends SuperclasseTipos implements ComponentesAddNaTela {
    private final ArrayList<JComponent> COMPONENTES = new ArrayList<JComponent>();

    private JTextField assuntoInput,autor;


    public Tecnicos(){
        this.addComponentesDaSuperclasse();
        this.addLabels();
        this.addInputs();
    }

    public void addComponentesDaSuperclasse(){
        this.COMPONENTES.add(GENERO);
        this.COMPONENTES.add(LABEL_GENERO);
    }

    public void addLabels(){
        JLabel assunto = new JLabel("Assunto: ", JLabel.CENTER);
        JLabel autor = new JLabel("Autor: ", JLabel.CENTER);

        autor.setBounds(0,410,90,30);
        autor.setFont(FONT);

        assunto.setBounds(0,445,90,30);
        assunto.setFont(FONT);

        this.COMPONENTES.add(assunto);
        this.COMPONENTES.add(autor);
    }
    public void addInputs(){
        autor = new JTextField();
        autor.setBounds(90,410,178,30);
        autor.setFont(FONT);

        assuntoInput = new JTextField();
        assuntoInput.setBounds(90,445,178,30);
        assuntoInput.setFont(FONT);

        this.COMPONENTES.add(autor);
        this.COMPONENTES.add(assuntoInput);
    }

    @Override
    public String[] getGeneros() {
        return new String[] {"Paradidático","Formação Profissional"};
    }


    @Override
    public ArrayList<JComponent> getComponentes() {
        return COMPONENTES;
    }

    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> informacoes = new ArrayList<String>();
        informacoes.add((String) GENERO.getSelectedItem());
        informacoes.add(assuntoInput.getText());
        informacoes.add(autor.getText());
        return informacoes;
    }

    @Override
    public int getMaiorAltura() {
        return 445;
    }

    @Override
    public String getTipo() {
        return "Técnico";
    }
}
