package SpaceADM.CadastroDeLivros.Ouvintes;

import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Factory.TipoDeLivros.ChamaTiposDeLivros;
import SpaceADM.CadastroDeLivros.Tela.Tela.TelaAddLivro;
import SpaceADM.Home.Tela.TelaHomeADM;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuvinteDosJButtons implements ActionListener {

    private TelaAddLivro tela;
    private ComponentesAddNaTela comp;

    public OuvinteDosJButtons(TelaAddLivro tela, ComponentesAddNaTela comp){
        this.tela =tela;
        this.comp =comp;
    }
    public ArrayList<String> getInfomacoes(){
        ArrayList<String> todasAsInformoces = new ArrayList<String>();
        todasAsInformoces.add(comp.getTipo());
        todasAsInformoces.add(tela.getTitulo());
        todasAsInformoces.add(tela.getAno());
        todasAsInformoces.add(tela.getResumo());
        todasAsInformoces.add(tela.getIdioma());
        todasAsInformoces.add(tela.getEditora());
        todasAsInformoces.add(tela.getQuantidade());
        todasAsInformoces.add(tela.getPreco());
        todasAsInformoces.addAll(comp.getInfo());

        return todasAsInformoces;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn.getText().equals("Voltar")){
            tela.dispose();
            new TelaHomeADM();
        }else{
            if(!this.getInfomacoes().contains("")){
                try{
                    Livro livro = ChamaTiposDeLivros.factory(this.getInfomacoes());
                    Persistencia p = Persistencia.getUnicaInstancia();
                    CentralDeInformacoes central = p.recuperar();
                    central.addLivro(livro);
                    central.salvar();
                    tela.dispose();
                    new TelaHomeADM();


                }catch (Exception ex){
                    this.showMessageDialog("Houve um erro, tente novamente");
                }

            }else{
                this.showMessageDialog("Não deixe campos em branco");
            }
        }

    }
    public void showMessageDialog(String msg){
        JOptionPane.showMessageDialog(tela, msg);

    }
}
