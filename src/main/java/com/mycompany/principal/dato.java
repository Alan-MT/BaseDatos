package com.mycompany.principal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maverick
 */
public class dato {
    
    private String[] nombreDato;
    private String[] contenido;
    private String nombreCampo;
    private tablaPrincipal tabla1;
    private Object datos3;
    private String tabla;
    private String[] campo;
    
   /* public dato(tablaPrincipal tabla ){
        this.nombreDato = tabla.getCampo();
        this.dato1 = null;
        this.dato2 = null;
        this.tabla1 = tabla;
    }*/
    public dato(tablaPrincipal tabla, Object datos){
        this.tabla1 = tabla;
        this.nombreDato = tabla.getCampo();
        this.datos3 = datos;
    }
   /* public dato(String nombreCampo, tablaPrincipal tabla) {
        this.nombreCampo = nombreCampo;
        this.tabla1 = tabla;
        
       //this.dato = convertirDato(tipoDato, dato);
    }
    
    public dato(String tabla ,String[] campo, String[] contenido){
        this.tabla = tabla;
        this.campo = campo;
        this.contenido = contenido;
    }
*/    
   /* public dato(String[] nombreDato, int[] dato2){
        this.nombreDato = nombreDato;
        this.dato2 = dato2;
    }*/

    public String[] getNombreDato() {
        return nombreDato;
    }

    public void setNombreDato(String[] nombreDato) {
        this.nombreDato = nombreDato;
    }

    public tablaPrincipal getTabla1() {
        return tabla1;
    }

    public void setTabla1(tablaPrincipal tabla1) {
        this.tabla1 = tabla1;
    }

    public Object getDatos3() {
        return datos3;
    }

    public void setDatos3(Object[] datos3) {
        this.datos3 = datos3;
    }

    public String[] getContenido() {
        return contenido;
    }

    public void setContenido(String[] contenido) {
        this.contenido = contenido;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String[] getCampo() {
        return campo;
    }

    public void setCampo(String[] campo) {
        this.campo = campo;
    }
    
    
    
    
}
