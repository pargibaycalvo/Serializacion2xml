/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class Serializacion2 {

    /**
     * @param args the command line arguments
     */
    
    static String[]cod={"p1","p2","p3"};
    static String[]des={"parafusos","cravos","tachas"};
    static Double[]prezo={3.0,4.0,5.0};
    
    static File directorio = new File("/home/oracle/NetBeansProjects/serializacion2xml/archivos");
    static File archivo = new File("/home/oracle/NetBeansProjects/serializacion2xml/serial.txt");
    
    static XMLStreamWriter xmls;
    static XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
    
    static File arcxml = new File("/home/oracle/NetBeansProjects/serializacion2xml/products.xml");

    
    public static void main(String[] args) throws IOException, XMLStreamException {
        // TODO code application logic here
        
        product obj1 = new product(cod[0],des[0],prezo[0]);
        product obj2 = new product(cod[1],des[1],prezo[1]);
        product obj3 = new product(cod[2],des[2],prezo[2]);
        
        carpeta(directorio);
        archivo(archivo, arcxml);
        escribir(obj1,obj2,obj3,archivo);
        leer(archivo, arcxml);
        
        
    }
    
    static void carpeta(File directorio){

        if(directorio.exists())
            System.out.println("Directorio existente "+directorio.getPath());
        else
            directorio.mkdir();
    }
    
    static void archivo(File archivo, File arcxml) throws IOException{

        if(archivo.exists())
            System.out.println("Archivo de texto existente "+archivo.getPath());
        else
            archivo.createNewFile();
    }
    
    static void escribir(product p1,product p2,product p3, File archivo){
        try {
              ObjectOutputStream esc = new ObjectOutputStream(new FileOutputStream(archivo));
              esc.writeObject(p1);
              esc.writeObject(p2);
              esc.writeObject(p3);
              esc.writeObject(null);
              esc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void leer(File archivo, File arcxml) throws XMLStreamException, IOException{
        try {
            ObjectInputStream ler = new ObjectInputStream(new FileInputStream(archivo));
            product aux = (product) ler.readObject();
            while(aux!=null){
                System.out.println(aux.toString());
                aux = (product) ler.readObject();  
            }  
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{
            xmls = outputFactory.createXMLStreamWriter(new FileWriter(arcxml));
            xmls.writeStartDocument("utf-8","1.0");
            
                        xmls.writeStartElement("product");
                            xmls.writeStartElement("obj1");
                            xmls.writeAttribute("cod", "0");
//                                xmls.writeStartElement("cod");
//                                    xmls.writeCharacters("0");
//                                xmls.writeEndElement();
                                xmls.writeStartElement("des");
                                    xmls.writeCharacters("0");
                                xmls.writeEndElement();
                                xmls.writeStartElement("prezo");
                                    xmls.writeCharacters("0");
                                xmls.writeEndElement();
                                
                            xmls.writeEndElement();
                            
                            xmls.writeStartElement("obj2");
                            xmls.writeAttribute("cod", "1");
//                                xmls.writeStartElement("cod");
//                                    xmls.writeCharacters("1");
//                                xmls.writeEndElement();
                                xmls.writeStartElement("des");
                                    xmls.writeCharacters("1");
                                xmls.writeEndElement();
                                xmls.writeStartElement("prezo");
                                    xmls.writeCharacters("1");
                                xmls.writeEndElement();
                                
                            xmls.writeEndElement();
                            
                            xmls.writeStartElement("obj3");
                            xmls.writeAttribute("cod", "2");
//                                xmls.writeStartElement("cod");
//                                    xmls.writeCharacters("2");
//                                xmls.writeEndElement();
                                xmls.writeStartElement("des");
                                    xmls.writeCharacters("2");
                                xmls.writeEndElement();
                                xmls.writeStartElement("prezo");
                                    xmls.writeCharacters("2");
                                xmls.writeEndElement();
                                
                            xmls.writeEndElement();
                        xmls.writeEndElement();
                        xmls.close();
                        
            } catch (XMLStreamException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        }




            
        }
       
        
    
}
