package SpaceADM.CarregarPlanilha.Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class LivrariaTableModel extends AbstractTableModel{
    private List<Livraria> dados = new ArrayList<>();
    private String [] colunas = {
            "Tipo","Título","Ano","Resumo","Idioma",
            "Editora","Quantidade","Preço",
            "Genero","Mês","Autore(s)","N° Edição","Assunto"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch(coluna){
            case 0:
                return dados.get(linha).getTipo();
            case 1:
                return dados.get(linha).getTitulo();
            case 2:
                return dados.get(linha).getAnoDePublicacao();
            case 3:
                return dados.get(linha).getResumo();
            case 4:
                return dados.get(linha).getIdioma();
            case 5:
                return dados.get(linha).getEditora();
            case 6:
                return dados.get(linha).getQuantidade();
            case 7:
                return dados.get(linha).getPreco();
            case 8:
                return dados.get(linha).getGenero();
            case 9:
                return dados.get(linha).getMes();
            case 10:
                return dados.get(linha).getAutores();
            case 11:
                return dados.get(linha).getNumeroDeEdicao();
            case 12:
                return dados.get(linha).getAssunto();
            default:
                return null;
        }
    }
    public void setValueAt(Object valor, int linha, int coluna) {

        switch(coluna){
            case 0:
                dados.get(linha).setTipo((String)valor);
                break;
            case 1:
                dados.get(linha).setTitulo((String)valor);
                break;
            case 2:
                dados.get(linha).setAnoDePublicacao(Integer.parseInt((String)valor));
                break;
            case 3:
                dados.get(linha).setResumo((String)valor);
                break;
            case 4:
                dados.get(linha).setIdioma((String)valor);
                break;
            case 5:
                dados.get(linha).setEditora((String)valor);
                break;
            case 6:
                dados.get(linha).setQuantidade(Integer.parseInt((String)valor));
                break;
            case 7:
                dados.get(linha).setPreco(Float.parseFloat((String)valor));
                break;
            case 8:
                dados.get(linha).setGenero((String)valor);
                break;
            case 9:
                dados.get(linha).setMes((String)valor);
                break;
            case 10:
                dados.get(linha).setAutores((String)valor);
                break;
            case 11:
                dados.get(linha).setNumeroDeEdicao(Long.parseLong((String)valor));
                break;
            case 12:
                dados.get(linha).setAssunto((String)valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }


    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public void addRow(Livraria l){
        this.dados.add(l);
        this.fireTableDataChanged();

    }
    public boolean isCellEditable(int linha, int coluna) {

        return true;
    }
}
