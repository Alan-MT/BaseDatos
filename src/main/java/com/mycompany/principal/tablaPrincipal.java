package com.mycompany.principal;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maverick
 */
public class tablaPrincipal {

    private String nombre;
    private String llave;
    // private String campos;
    //private String tipos;
    private String[] campo;
    private String[] tipo;
    private dato[] datos;

    public tablaPrincipal(String nombre, String llave) {
        this.nombre = nombre;
        this.llave = llave;
        this.campo = null;
        this.tipo = null;
        this.datos = null;
    }

    /* public tablaPrincipal(String nombre, String llave, String campos, String tipos) {
        this.nombre = nombre;
        this.llave = llave;
        this.campos = campos;
        this.tipos = tipos;
    }*/
    public tablaPrincipal(String nombre, String llave, String[] campo, String[] tipo) {
        this.nombre = nombre;
        this.llave = llave;
        this.campo = campo;
        this.tipo = tipo;
    }
    
    /*public String retornarAlgo(String algo){
      for(int i = 0; i < datos.length; i++){
        if(algo == datos[i].getNombreDato()){
            return datos[i].getDato1(0.;
            break;
        }
        
    }
        
        return "";
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String[] getCampo() {
        return campo;
    }

    public void setCampo(String[] campo) {
        this.campo = campo;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public dato[] getDatos() {
        return datos;
    }

    public void setDatos(dato[] datos) {
        this.datos = datos;
    }

    
    

    /*@Override
    public String toString() {
        return nombre;
    }*/
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nLlave: " + llave + "\nCampos: " + Arrays.toString(campo) + "\nTipos: " + Arrays.toString(tipo);
    }

}
