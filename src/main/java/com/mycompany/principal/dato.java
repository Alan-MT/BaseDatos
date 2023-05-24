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
    private String[] dato1;
    private int[] dato2;
    private tablaPrincipal tabla1;
    private Object[] datos3;
    private String nombreCampo;
    private String tipoDato;
    
    public dato(tablaPrincipal tabla ){
        this.nombreDato = tabla.getCampo();
        this.dato1 = null;
        this.dato2 = null;
        this.tabla1 = tabla;
    }
    public dato(tablaPrincipal tabla, Object[] datos){
        this.tabla1 = tabla;
        this.nombreDato = tabla.getCampo();
        this.datos3 = datos;
    }
    public dato(String nombreCampo, tablaPrincipal tabla, String tipoDato, String dato) {
        this.nombreCampo = nombreCampo;
        this.tabla1 = tabla;
        this.tipoDato = tipoDato;
       //this.dato = convertirDato(tipoDato, dato);
    }
    
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

    public String[] getDato1() {
        return dato1;
    }

    public void setDato1(String[] dato1) {
        this.dato1 = dato1;
    }

    public int[] getDato2() {
        return dato2;
    }

    public void setDato2(int[] dato2) {
        this.dato2 = dato2;
    }

    public tablaPrincipal getTabla1() {
        return tabla1;
    }

    public void setTabla1(tablaPrincipal tabla1) {
        this.tabla1 = tabla1;
    }

    public Object[] getDatos3() {
        return datos3;
    }

    public void setDatos3(Object[] datos3) {
        this.datos3 = datos3;
    }
    
    
    
}
