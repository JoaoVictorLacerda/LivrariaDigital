package Utilitarios.Persistencia.PersistenciaSingleton;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Info_Login.LoginSingleton;
import Utilitarios.Persistencia.Central_de_informacoes.Livreiro.Livreiro;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia{
	private XStream xStream = new XStream(new DomDriver("UTF-8"));
	private static Persistencia unicaInstancia;

	private Persistencia(){

	}
	public static synchronized Persistencia getUnicaInstancia(){
		if(unicaInstancia==null){
			unicaInstancia = new Persistencia();
		}
		return unicaInstancia;
	}



	public void salvarCentral(CentralDeInformacoes central) throws Exception {
		File arquivo = new File("DataBase.xml");
		String xml="";
		
		arquivo.createNewFile();
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";

		PrintWriter pw = new PrintWriter(arquivo);
		this.alias();
		xml += xStream.toXML(central);
		pw.write(xml);
		pw.close();
	}


	public CentralDeInformacoes recuperar() {
		try{
			File arquivo = new File("DataBase.xml");
			this.alias();
			if(arquivo.exists()) {
				FileReader fr = new FileReader(arquivo);
				return (CentralDeInformacoes) xStream.fromXML(fr);
			}
		}catch(Exception ignored){
		}
		return null;
	}
	public void alias(){
		xStream.alias("CentralDeInformacoes", CentralDeInformacoes.class);
		xStream.alias("Livreiro", Livreiro.class);
		xStream.alias("login", LoginSingleton.class);

	}

}
