package Utilitarios.BackupLivros;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class PersistenciaSingleton {
    private XStream xStream = new XStream(new DomDriver("UTF-8"));
    private static PersistenciaSingleton unicaInstancia;

    private PersistenciaSingleton(){

    }
    public static synchronized PersistenciaSingleton getUnicaInstancia(){
        if(unicaInstancia==null){
            unicaInstancia = new PersistenciaSingleton();
        }
        return unicaInstancia;
    }

    public String caminhoFile(boolean b){
        JFileChooser fc = new JFileChooser();
        fc.setPreferredSize(new Dimension(700,400));
        int i;
        if(b){
            i  =JFileChooser.DIRECTORIES_ONLY;
        }else{
            i=JFileChooser.FILES_ONLY;
        }
        fc.setFileSelectionMode(i);
        int result = fc.showOpenDialog(fc);
        if(result!=JFileChooser.CANCEL_OPTION){
            return b==true?fc.getSelectedFile().getAbsolutePath(): String.valueOf(fc.getSelectedFile());
        }else{
            JOptionPane.showMessageDialog(null, "Tente novamente");
            return "";
        }
    }

    public void salvarCentral(CentralBackup central) throws Exception {
        String dirSalvar = caminhoFile(true);
        if(!dirSalvar.equals("")){
            File arquivo = new File(dirSalvar+"/Backup.xml");
            String xml="";
            arquivo.createNewFile();
            xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";

            PrintWriter pw = new PrintWriter(arquivo);
            this.alias();
            xml += xStream.toXML(central);
            pw.write(xml);
            pw.close();
        }
    }


    public CentralBackup recuperar() {
        try {
            String dirSalvar = caminhoFile(false);
            if (!dirSalvar.equals("")) {
                File arquivo = new File(dirSalvar);
                this.alias();
                if (arquivo.exists()) {
                    FileReader fr = new FileReader(arquivo);
                    return (CentralBackup) xStream.fromXML(fr);
                }
            }
        }catch(Exception ignored){
        }
        return null;
    }

    public void alias(){
        xStream.alias("CentralBackup", CentralBackup.class);
    }
}
