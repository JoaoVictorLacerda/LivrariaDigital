package SpaceADM.Home.GeradorDePDF;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class GeradorDePDF {
    public static boolean gerarRelatorio(
            ArrayList<Livro>livrosFinal,
            String nomeDoArquivo, String tituloPDF,String primeiraCell) {
        Document doc = new Document(PageSize.A4);
        JFileChooser fc = new JFileChooser();

        fc.setPreferredSize(new Dimension(700,400));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fc.showOpenDialog(fc);
        if(result != JFileChooser.CANCEL_OPTION){
            String dir = fc.getSelectedFile().getAbsolutePath();
            try {
                OutputStream os = new FileOutputStream(dir+"/"+nomeDoArquivo);
                PdfWriter.getInstance(doc,os);
                doc.open();
                String lista[]= {primeiraCell,"Titulo","Idioma","Editora","Ano","Tipo","Genero"};
                PdfPTable tabela = new PdfPTable(7);
                Font f = new Font(Font.FontFamily.COURIER,13,Font.BOLD,BaseColor.WHITE);
                Font f2 = new Font(Font.FontFamily.COURIER,13,Font.BOLD,BaseColor.BLACK);
                Paragraph p1 =new Paragraph(tituloPDF,f2);
                Paragraph p2 =new Paragraph("Relatório",f);

                p1.setAlignment(Element.ALIGN_CENTER);
                PdfPCell cabecalho3 = new PdfPCell();
                cabecalho3.addElement(p1);
                cabecalho3.setColspan(7);
                cabecalho3.setBackgroundColor(BaseColor.WHITE);
                tabela.addCell(cabecalho3);

                p2.setAlignment(Element.ALIGN_CENTER);
                PdfPCell cabecalho2 = new PdfPCell();
                cabecalho2.addElement(p2);
                cabecalho2.setColspan(7);
                cabecalho2.setBackgroundColor(BaseColor.BLACK);
                tabela.addCell(cabecalho2);
                for(int i =0;i<7;i++) {
                    PdfPCell cabecalho = new PdfPCell(new Paragraph(lista[i]));
                    cabecalho.setColspan(1);
                    cabecalho.setBackgroundColor(BaseColor.CYAN);
                    tabela.addCell(cabecalho);
                }
                for(Livro l:livrosFinal){
                    String numeroDeVisualizacoes;
                    if(primeiraCell.equals("Visualizações")){
                        numeroDeVisualizacoes = Integer.toString(l.getNumeroDeVisualizacoes());
                    }else{
                        numeroDeVisualizacoes = Integer.toString(l.getNumeroDePessoasQueIndicaramInteresse());
                    }
                    String titulo =l.getTitulo();
                    String idioma = l.getIdioma();
                    String editora=l.getEditora();
                    String ano = Integer.toString(l.getAnoDePublicacao());
                    String type=l.getTIPO();
                    String genero = l.getGenero();

                    tabela.addCell(numeroDeVisualizacoes);
                    tabela.addCell(titulo);
                    tabela.addCell(idioma);
                    tabela.addCell(editora);
                    tabela.addCell(ano);
                    tabela.addCell(type);
                    tabela.addCell(genero);
                }

                doc.add(tabela);
                doc.close();
                return true;
            }catch (Exception e){
                return false;
            }
        }
      return false;
    }



}
