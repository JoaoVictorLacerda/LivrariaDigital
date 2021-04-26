package Utilitarios.Persistencia.Central_de_informacoes.Usuario;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String numeroDeRecuperacao;
    private String sexo;
    private String dataDeNascimento;
    private String genero1, genero2, genero3;
    private ArrayList<String> compras=new ArrayList<String>();
    private ArrayList<String> colecao=new ArrayList<String>();


    public ArrayList<String> getCompras() {
        return compras;
    }

    public void addCompras(String compras) {
        this.compras.add(compras);
    }

    public ArrayList<String> getColecao() {
        return colecao;
    }

    public void addColecao(String indexInteresse) {
        this.colecao.add(indexInteresse);
    }

    public Usuario(String nome, String email,
                   String senha, String sexo,
                   String dataDeNascimento, String genero1, String genero2, String genero3) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.genero1 = genero1;
        this.genero2 = genero2;
        this.genero3 = genero3;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNumeroDeRecuperacao() {
        return numeroDeRecuperacao;
    }

    public void setNumeroDeRecuperacao(String numeroDeRecuperacao) {
        this.numeroDeRecuperacao = numeroDeRecuperacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getGenero1() {
        return genero1;
    }

    public void setGenero1(String genero1) {
        this.genero1 = genero1;
    }

    public String getGenero2() {
        return genero2;
    }

    public void setGenero2(String genero2) {
        this.genero2 = genero2;
    }

    public String getGenero3() {
        return genero3;
    }

    public void setGenero3(String genero3) {
        this.genero3 = genero3;
    }
}