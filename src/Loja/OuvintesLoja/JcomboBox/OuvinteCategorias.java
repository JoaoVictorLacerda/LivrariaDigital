package Loja.OuvintesLoja.JcomboBox;

import Loja.Tela.Loja.TelaLoja;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class OuvinteCategorias implements ActionListener {

    private TelaLoja tela;


    public OuvinteCategorias(TelaLoja tela) {
        this.tela=tela;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox combo= (JComboBox) e.getSource();
        String tipo = (String) combo.getItemAt(0);

        ArrayList<Livro> finalLivros = this.tela.LIVROS;
        ArrayList<Livro> livros = new ArrayList<Livro>();
        if(tipo.equals("Todos os Livros")){
            String itemSelecionado = (String) combo.getSelectedItem();
            if(itemSelecionado.equals("Recomendados") && tela.getUser()!=null){
                String generoDoUser = (tela.getUser().getGenero1()+","+
                         tela.getUser().getGenero2()+","+tela.getUser().getGenero3()).toUpperCase();
                ArrayList<String> generosUser= new ArrayList<String>(Arrays.asList(generoDoUser.split(",")));
                for (Livro l: finalLivros) {
                    String generoLivro = l.getGenero().toUpperCase();
                    if(generosUser.contains(generoLivro)){
                        livros.add(l);
                    }

                }
                this.tela.limpaPlanilha();
                this.tela.addLivros(livros);

            }
            if(itemSelecionado.equals("Em Falta")){
                for(Livro l : finalLivros){
                    if(l.getQuantidade()==0){
                        livros.add(l);
                    }
                }
                this.tela.limpaPlanilha();
                this.tela.addLivros(livros);

            }else if(itemSelecionado.equals("Todos os Livros")){
                this.tela.limpaPlanilha();
                this.tela.addLivros(this.tela.LIVROS);

            }else{

                for(Livro livro : this.tela.LIVROS){
                    if(livro.getTIPO().equals(itemSelecionado)){
                        livros.add(livro);
                    }
                }
                this.tela.limpaPlanilha();
                this.tela.addLivros(livros);
            }
        }

    }
}
