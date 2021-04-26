package SpaceADM.CadastroDeLivros.Tela.Componentes;

import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Superclasse.SuperclasseTipos;

import javax.swing.*;
import java.util.ArrayList;

public class Literatura extends SuperclasseTipos implements ComponentesAddNaTela {
    private final ArrayList<JComponent> COMPONENTES = new ArrayList<JComponent>();
    private JTextField autoresInput;

    public Literatura(){
        this.addComponentesDaSuperclasse();
        this.addLabelAutores();
        this.addInput();

    }
    public void addComponentesDaSuperclasse(){
        this.COMPONENTES.add(GENERO);
        this.COMPONENTES.add(LABEL_GENERO);
    }
    @Override
    public String[] getGeneros() {
        return new String[] {
                "Literatura Brasileira",
                "Literatura Estrangeira",
                "Infanto Juvenil",
                "Artes",
                "Biografia",
                "Poesia"};
    }



    public void addInput(){
        autoresInput = new JTextField();

        autoresInput.setBounds(90,410,178,30);
        autoresInput.setFont(FONT);

        this.COMPONENTES.add(autoresInput);
    }

    public void addLabelAutores(){
        JLabel autores = new JLabel("Autores: ", JLabel.CENTER);

        autores.setBounds(0,410,90,30);
        autores.setFont(FONT);

        this.COMPONENTES.add(autores);

    }

    @Override
    public ArrayList<JComponent> getComponentes() {
        return COMPONENTES;
    }

    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> informacoes = new ArrayList<String>();
        informacoes.add((String) GENERO.getSelectedItem());
        informacoes.add(autoresInput.getText());

        return informacoes;
    }

    @Override
    public int getMaiorAltura() {
        return 410;
    }

    @Override
    public String getTipo() {
        return "Literatura";
    }
}
