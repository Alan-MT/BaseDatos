/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author maverick
 */
public class lector {
    
        String[] KeyP = new String[10];
    String[] tabla = new String[10];
    String[] campos = new String[10];
    String[] tipos  = new String[10];
    String[] campo1;
    String[] tipo2;
    
    public lector(){}
    
        public void cambio(){
        int j=0;
        for(int i = 0; i < campos.length; i++){
            if(campos[i] != null){
                j++;
            }
        }
        //ingresar a loa array campo1 y tipo2 revisar que hacer
        campo1 = new String[j];
        tipo2 = new String[j];
        for(int i = 0; i < j; i++){
        campo1[i] = campos[i];
        tipo2[i] = tipos[i];
    }
    }
    
    public void lector(String ruta, tablaPrincipal[] tablaP){
        try {
      File archivo = new File(ruta);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(archivo);
      doc.getDocumentElement().normalize();
      NodeList listaEstructuras = doc.getElementsByTagName("estructura");
      
      int contador = 0;
      int contadorP = 0;
      int contador3 = 0;
      int contador4 = 0;
      int contador5 =0;
      
      for (int i = 0; i < listaEstructuras.getLength(); i++) {
        Node nodoEstructura = listaEstructuras.item(i); 
        
        
        if (nodoEstructura.getNodeType() == Node.ELEMENT_NODE) {
          Element elementoEstructura = (Element) nodoEstructura;
          String nombreTabla = elementoEstructura.getElementsByTagName("tabla").item(0).getTextContent();
          
          //System.out.println("Tabla: " + nombreTabla);


          NodeList listaCampos = elementoEstructura.getChildNodes();

          for (int j = 0; j < listaCampos.getLength(); j++) {
            Node nodoCampo = listaCampos.item(j);
                           
            if (nodoCampo.getNodeType() == Node.ELEMENT_NODE) {
              Element elementoCampo = (Element) nodoCampo;
              String nombreCampo = elementoCampo.getNodeName();
              String tipoCampo = elementoCampo.getTextContent();
              
                switch (nombreCampo) {      
                    case "tabla":
                        //System.out.print(tabla[contador5]);
                        if(contador4 > 0){
                            cambio();
                        tablaP[contador5] = new tablaPrincipal(tabla[contador5], KeyP[contador5], campo1, tipo2);
                        //System.out.println(tablaP[contador5].toString());
                        campos = new String[10];
                        tipos = new String[10];
                            contador5++;
                            contador3 = 0;
                        }
                        tabla[contador] = tipoCampo;
                        contador++;
                        //contador3 = contador - 1;
                        contador4++;
                        
                        break;
                    case "clave":
                        KeyP[contadorP] = tipoCampo;
                        contadorP++;
                        break;
                    default:
                        campos[contador3] = nombreCampo;
                        tipos[contador3] = tipoCampo;
                        contador3++;
                        break;
                       /* if (campos[contador3] == null) {
                            campos[contador3] = nombreCampo;
                            tipos[contador3] = tipoCampo;

                        } else {
                            campos[contador3] += ", " + nombreCampo;
                            tipos[contador3] += ", " + tipoCampo;

                        }
                        */
                        
                }
              
            /*  if("clave" != nombreCampo  || "tabla" != nombreCampo){

                  //System.out.print(nombreCampo);
                  if(campos[contador3] == null){
                     campos[contador3] = nombreCampo; 
                     tipos[contador3] = tipoCampo;
                     //System.out.print("primer if");
                     //System.out.println(nombreCampo);
                  } else{
                      campos[contador3] += ", "+nombreCampo;
                      tipos[contador3] +=", "+tipoCampo;
                      //System.out.println(nombreCampo);
                      //System.out.print("2");
                  }

              }

              if ("clave" == nombreCampo) {
                  String keyp = tipoCampo;
                KeyP[contadorP] = tipoCampo;
                contadorP++;
              }
              if ("tabla" == nombreCampo){
                  tabla[contador] = tipoCampo;
                  contador++;
                  contador3 =contador-1;
              }*/
             // System.out.println("Campo: " + nombreCampo + ", Tipo: " + tipoCampo);
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
        
                   //System.out.println("tablas");
                /*for(int i =0; i < tablaP.length;i++){
                    if(tablaP[i] != null)
                        System.out.println(tablaP[i].toString());
                        //tablaP[i] = new tablaPrincipal(tabla[i], KeyP[i], campos[i], tipos[i]);
                }
                /*    }
                    if(campos[i] != null)
                    System.out.println(campos[i]);
                    if(tipos[i] != null)
                        System.out.println(tipos[i]);
                   
                }

                /*System.out.print("LLave primaria");
                 for(int i =0; i < tabla.length;i++){
                    if(KeyP[i] != null)
                   System.out.print(KeyP[i]);
                }*/

                    

    }
}

    

