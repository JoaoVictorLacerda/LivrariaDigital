package Loja.OuvintesDetalhes;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import Utilitarios.TestaFilesPDF.ExistePDFQuestion;


import java.io.FileOutputStream;
import java.io.OutputStream;


public class PDFCompra {

    public static void gerarBoleto(String dir) {
    	Document doc = new Document(new Rectangle(755,500));
		
		String dirFinal = ExistePDFQuestion.testa(dir, "compra");
    	
        try {
            OutputStream os = new FileOutputStream(dirFinal);
            PdfWriter.getInstance(doc,os);
            doc.open();
            Image boleto = Image.getInstance(PDFCompra.class.getResource("/loja/Boleto/boletofk.jpg"));
            doc.add(boleto);
            doc.close();
        } catch (Exception ignored) {

        }



    }

}
