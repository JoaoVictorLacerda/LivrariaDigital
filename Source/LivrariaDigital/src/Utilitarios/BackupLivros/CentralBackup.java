package Utilitarios.BackupLivros;

import SpaceADM.CarregarPlanilha.Model.Livraria;

import java.util.ArrayList;

public class CentralBackup {

    ArrayList<Livraria> livros =new ArrayList<Livraria>();

    public ArrayList<Livraria> getLivros() {
        return livros;
    }

    public void addLivros(ArrayList<Object>livro) {
        Livraria livraria = new Livraria();
        livraria.setTipo((String) livro.get(0));
        livraria.setTitulo((String) livro.get(1));
        livraria.setAnoDePublicacao(Integer.parseInt(String.valueOf((Integer) livro.get(2))));
        livraria.setResumo((String) livro.get(3));
        livraria.setIdioma((String) livro.get(4));
        livraria.setEditora((String) livro.get(5));
        livraria.setQuantidade(Integer.parseInt(String.valueOf((Integer) livro.get(6))));
        livraria.setPreco(Float.parseFloat(String.valueOf((Float) livro.get(7))));
        livraria.setGenero((String) livro.get(8));
        livraria.setMes((String) livro.get(9));
        livraria.setAutores((String) livro.get(10));
        livraria.setNumeroDeEdicao(Long.parseLong(String.valueOf((Long) livro.get(11))));
        livraria.setAssunto((String) livro.get(12));
        this.livros.add(livraria);
    }
    public void salvar(){
        PersistenciaSingleton p = PersistenciaSingleton.getUnicaInstancia();
        try {
            p.salvarCentral(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
