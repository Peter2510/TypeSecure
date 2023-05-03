/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.arbol;

import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Nodo {
    private String tipo;
    private ArrayList<Object> hijos;
    private int linea;
    private int columna;
    
    
    public Nodo(String tipo, ArrayList<Object> hijos,int linea,int columna){
        this.tipo = tipo;
        this.hijos = hijos;
        this.linea = linea;
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Object> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Object> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return tipo + " -> " + hijos;
    }
  
}


