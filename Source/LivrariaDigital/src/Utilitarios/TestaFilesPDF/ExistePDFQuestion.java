package Utilitarios.TestaFilesPDF;

import java.io.File;

public class ExistePDFQuestion {
	
	public static String testa(String dir, String nomeDoArquivo) {
		File file = new File(dir+"/"+nomeDoArquivo+".pdf");
    	int cont =1;
    	String fileString="/"+nomeDoArquivo;
    	
		while(file.exists()) {
				fileString="/"+nomeDoArquivo+"("+cont+")";
				file = new File(dir+fileString+".pdf");
				cont++;
    		}
		return dir+=fileString+".pdf";
	}
	

}
