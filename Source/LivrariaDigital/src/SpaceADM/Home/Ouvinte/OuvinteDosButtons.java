package SpaceADM.Home.Ouvinte;

import SpaceADM.CadastroDeLivros.Tela.Tela.TelaAddLivro;
import SpaceADM.CarregarPlanilha.Tela.TelaCarregarPlanilha;
import SpaceADM.Home.GeradorDePDF.GeradorDePDF;
import SpaceADM.Home.Tela.TelaHomeADM;
import SpaceADM.login.Tela.TelaLoginADM;
import Loja.Tela.Loja.TelaLoja;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Info_Login.LoginSingleton;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuvinteDosButtons implements ActionListener {

    private TelaHomeADM  tela;

    public OuvinteDosButtons(TelaHomeADM tela){
        this.tela=tela;
    }

    public String btnSair(){
        Persistencia persistencia = Persistencia.getUnicaInstancia();
        CentralDeInformacoes central = persistencia.recuperar();
        LoginSingleton login = LoginSingleton.getUnicaInstancia();
        login.setLivreiro(false);
        central.addLogin(login);
        central.salvar();
        tela.dispose();
        new TelaLoginADM();

        return "";
    }

    public void btnCadastrarLivro(){
        tela.dispose();
        new TelaAddLivro();
    }

    public void btnCarregarPlanilha(){
        tela.dispose();
        new TelaCarregarPlanilha();
    }

    public void btnVerALoja(){
        this.tela.dispose();
        new TelaLoja();
    }
    private CentralDeInformacoes central= Persistencia.getUnicaInstancia().recuperar();
    private ArrayList<Livro> livros = central.getLivros();
    private ArrayList<Livro>livrosFinal=new ArrayList<>();

    public void btnMaisVisualizados(){
        for(int i = 0;i<10;i++){
            int num =0;
            Livro livro=null;
            for(Livro l :livros){
                if(l.getNumeroDeVisualizacoes()>num){
                    num = l.getNumeroDeVisualizacoes();
                    livro = l;
                }

            }
            if(livro!=null){
                livrosFinal.add(livro);
                livros.remove(livro);
            }
        }
        GeradorDePDF.gerarRelatorio(livrosFinal,
                "MaisVisualizados.pdf","Esses são os Livros mais procurados","Visualizações");


    }
    public void btnMaisInteressado(){

        for(int i = 0;i<10;i++){
            int num =0;
            Livro livro=null;
            for(Livro l :livros){
                if(l.getNumeroDePessoasQueIndicaramInteresse()>num){
                    num = l.getNumeroDePessoasQueIndicaramInteresse();
                    livro = l;
                }

            }
            if(livro!=null){
                livrosFinal.add(livro);
                livros.remove(livro);
            }
        }
        GeradorDePDF.gerarRelatorio(livrosFinal,
                "MaisInteressados.pdf","Esses são os Livros esgotados com mais interessados","N°Interessados");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch (btn.getText()){
            case"Sair":
                this.btnSair();
                break;
            case"Cadastrar Livro":
                this.btnCadastrarLivro();
                break;
            case"Carregar planilha":
                this.btnCarregarPlanilha();
                break;
            case"Ver a loja":
                this.btnVerALoja();
                break;
            case"Mais visualizados":
                this.btnMaisVisualizados();
                break;
            case"Mais interessados":
                this.btnMaisInteressado();
                break;
        }

    }
}
