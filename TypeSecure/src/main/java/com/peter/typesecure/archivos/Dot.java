/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.archivos;

import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Dot {
    
    int contador;
    ArrayList<String> encabezados;
    String datos;

    public Dot() {
        this.contador = 1; 
        this.encabezados = new ArrayList();
        this.datos = "";
    }
    
    public void agregarEncabezado(String encabezado){
        this.encabezados.add(encabezado);
    }

    public int getContador() {
        return contador;
    }

    public void sumarContador(){
        this.contador++;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }

    public ArrayList<String> getEncabezados() {
        return encabezados;
    }

    public void setEncabezados(ArrayList<String> encabezados) {
        this.encabezados = encabezados;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    
   
    
}
