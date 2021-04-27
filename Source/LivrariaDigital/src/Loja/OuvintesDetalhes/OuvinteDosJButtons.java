package Loja.OuvintesDetalhes;

import Loja.Tela.DetalhesLivro.TelaDetalhes;
import Loja.Tela.Loja.TelaLoja;
import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceUSER.Home.Tela.TelaHomeUser;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuvinteDosJButtons implements ActionListener {

    private TelaDetalhes tela;
    public OuvinteDosJButtons(TelaDetalhes tela) {
        this.tela = tela;
    }

    public void comprarAndAddColecao(String botao){
        CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
        Livro livroEscolhido = tela.getLivro();
        String livroInfo = livroEscolhido.getTitulo()+","+
                livroEscolhido.getTIPO()+","+
                livroEscolhido.getGenero()+","+
                livroEscolhido.getResumo();

        Usuario user = tela.getUser();
        ArrayList<Usuario> usuarios = central.getUsuario();

        String mensagem="";
        for(int i =0;i<usuarios.size();i++){
            if(usuarios.get(i).getEmail().equals(user.getEmail())){
                user=central.getUsuario().get(i);
                central.getUsuario().remove(i);
                central.salvar();
            }
        }
        switch (botao){
            case"Comprar":
                JFileChooser fc = new JFileChooser();
                fc.setPreferredSize(new Dimension(700,400));
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fc.showOpenDialog(fc);

                if (result!=JFileChooser.CANCEL_OPTION) {
                    String dir = fc.getSelectedFile().getAbsolutePath();
                    PDFCompra.gerarBoleto(dir);
                        ArrayList<Livro> livros = central.getLivros();
                        for(int i =0;i<livros.size();i++){
                            if(livros.get(i).getTitulo().equals(livroEscolhido.getTitulo())&&
                                    livros.get(i).getTIPO().equals(livroEscolhido.getTIPO())){
                                central.getLivros().remove(i);
                                central.salvar();
                            }
                        }
                        int quantidade = livroEscolhido.getQuantidade();
                        livroEscolhido.setQuantidade(quantidade-1);

                        central.addLivro(livroEscolhido);
                        central.salvar();

                        user.addCompras(livroInfo);
                    	mensagem = "Boleto Gerado \n"+"Operação Realizada com sucesso";

                }
                break;
            case"Add a Coleção":

                if(!user.getColecao().contains(livroInfo)){
                    user.addColecao(livroInfo);
                    mensagem = "Operação Realizada com sucesso";
                }else{
                    mensagem="Você ja adicionou este livro à sua coleção";
                }
                break;



        }
        central.addUser(user);
        central.salvar();
        JOptionPane.showMessageDialog(tela, mensagem);
        this.tela.dispose();
        new TelaLoja(central.getLogin().getEmailUsuario());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();

        if(botao.getText().equals("Comprar")||botao.getText().equals("Add a Coleção")){
            this.comprarAndAddColecao(botao.getText());
        }else if(botao.getText().equals("Voltar")){
            this.tela.dispose();
            new TelaLoja();
        }else if(botao.getText().equals("Tenho interesse")){
            CentralDeInformacoes central = Persistencia.getUnicaInstancia().recuperar();
            Livro livroEscolhido = tela.getLivro();
            ArrayList<Livro> livros = central.getLivros();

            for(int i =0;i<livros.size();i++){
                if(livros.get(i).getTitulo().equals(livroEscolhido.getTitulo())&&
                        livros.get(i).getTIPO().equals(livroEscolhido.getTIPO())){
                    central.getLivros().remove(i);
                    central.salvar();
                }
            }
            int numero = livroEscolhido.getNumeroDePessoasQueIndicaramInteresse();
            livroEscolhido.setNumeroDePessoasQueIndicaramInteresse(numero+1);
            central.addLivro(livroEscolhido);
            central.salvar();
            JOptionPane.showMessageDialog(tela,"Interesse contabilizado");
            tela.dispose();
            new TelaLoja(tela.getUser());
        }
    }
}
