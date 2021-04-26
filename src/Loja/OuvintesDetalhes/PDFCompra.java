package Loja.OuvintesDetalhes;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class PDFCompra {

    public static void gerarBoleto(String dir) {
        Document doc = new Document(new Rectangle(755,500));

            try {
                OutputStream os = new FileOutputStream(dir+"/compra.pdf");
                PdfWriter.getInstance(doc,os);
                doc.open();
                Image boleto = Image.getInstance(PDFCompra.class.getResource("/loja/Boleto/boletofk.jpg"));
                doc.add(boleto);
                doc.close();
            } catch (Exception e) {

            }



    }

}
