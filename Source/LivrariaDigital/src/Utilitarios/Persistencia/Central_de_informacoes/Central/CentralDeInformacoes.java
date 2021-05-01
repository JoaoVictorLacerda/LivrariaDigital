package Utilitarios.Persistencia.Central_de_informacoes.Central;
import Utilitarios.Persistencia.Central_de_informacoes.Info_Login.LoginSingleton;
import Utilitarios.Persistencia.Central_de_informacoes.Livreiro.Livreiro;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Usuario.Usuario;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;

import java.util.ArrayList;

public class CentralDeInformacoes {
    private Livreiro livreiro;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();
    private LoginSingleton loginSingleton;

    public void salvar(){
        Persistencia persistencia = Persistencia.getUnicaInstancia();
        try {
            persistencia.salvarCentral(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLivreiro(Livreiro livreiro) {
        this.livreiro = livreiro;

    }
    public void addUser(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void addLogin(LoginSingleton loginSingleton){
        this.loginSingleton = loginSingleton;
    }

    public void addArrayDeLivros(ArrayList<Livro> livros){
        this.livros.addAll(livros);

    }

    public void addLivro(Livro livro){
        this.livros.add(livro);

    }
    public void addLivro(int index,Livro livro){
        this.livros.add(index,livro);

    }


    public Livreiro getLivreiro() {
        return this.livreiro;
    }

    public ArrayList<Usuario> getUsuario() {
        return this.usuarios;
    }

    public ArrayList<Livro> getLivros(){
        return this.livros;
    }

    public LoginSingleton getLogin(){
        return this.loginSingleton;
    }
}
