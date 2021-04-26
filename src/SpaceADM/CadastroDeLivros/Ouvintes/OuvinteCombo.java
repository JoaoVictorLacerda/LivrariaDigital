package SpaceADM.CadastroDeLivros.Ouvintes;



import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Factory.ComBox.ChamaComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Tela.Tela.TelaAddLivro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteCombo implements ActionListener {
	
	/**
	 * @author Victor
	 * 
	 * Este ouvinte está servindo para o cadastro de livros de forma única.
	 * Acho que ela é uma classe importante dentro do projeto.
	 * Sem ela o cadastro de livros só poderá ser feito através da planilha.
	 * 
	 * Quando o Livreiro mudar o valor comboBox, o ouvinte será solicitado
	 * e irá pegar as infomações de classes que extende uma superclasse de  Tipos e uma interface de components.
	 * com isso em mente, é possível adicionar os JComponentes de forma polimórfica na tela.
	 * Ja que cada subtipo da interface vai implementar seus próprios métodos retorando uma lista de Objetos do tipo
	 * JComponent(e todo objeto swing extende de Jcomponent), é só adicionar na tela e
	 * e passar as informações para o ouvinte dos JButtons que irá salvar como um Objeto do tipo correto na persistencia
	 * (feito com o padrão factory) sem perca ou modifiação de informações
	 *  
	 * 
	 */
	
    private TelaAddLivro tela;
    private ComponentesAddNaTela componentes;

    public OuvinteCombo( TelaAddLivro tela) {
        this.tela = tela;

    }
    public void addJButtons(){
        JButton cancelar = new JButton("Voltar");
        JButton adicionar = new JButton("Adicionar");
        Font font = new Font("Arial",Font.BOLD,13);
        OuvinteDosJButtons ouvinte = new OuvinteDosJButtons(tela,componentes);

        cancelar.setFont(font);
        cancelar.setForeground(Color.BLACK);
        cancelar.addActionListener(ouvinte);
        cancelar.setBounds(15,componentes.getMaiorAltura()+50,110,30);

        adicionar.setFont(font);
        adicionar.setForeground(Color.BLACK);
        adicionar.addActionListener(ouvinte);
        adicionar.setBounds(155,componentes.getMaiorAltura()+50,110,30);

        tela.JP_PAINEL.add(cancelar);
        tela.JP_PAINEL.add(adicionar);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox combo = (JComboBox) e.getSource();
        int index = combo.getSelectedIndex();

        tela.JP_PAINEL.removeAll();
        tela.JP_PAINEL.setPreferredSize(new Dimension(0,320));
        tela.addCabecalho(index);

        if(index !=0){
            componentes = ChamaComponentesAddNaTela.factory(index);
            try{
                tela.JP_PAINEL.setPreferredSize(new Dimension(0,componentes.getMaiorAltura()+100));
                tela.addJLabelParaOtipo(componentes.getTipo());

                for(JComponent c:componentes.getComponentes()){
                    tela.JP_PAINEL.add(c);
                }
                tela.addFormLabel();
                tela.addInputs();
                this.addJButtons();

            }catch (Exception ex){
                JOptionPane.showMessageDialog(tela,"Houve um erro, entre em contato com o desenvolvedor");
            }
        }
        tela.repaint();
        tela.validate();

    }
}

