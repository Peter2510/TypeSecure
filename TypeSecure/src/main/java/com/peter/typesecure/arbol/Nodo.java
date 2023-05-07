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
    private ArrayList<Nodo> hijos;
    private int linea;
    private int columna;
    
    public Nodo(){
    }
    
    public Nodo(String tipo, ArrayList<Nodo> hijos,int linea,int columna){
        this.tipo = tipo;
        this.hijos = hijos;
        this.linea = linea;
        this.columna = columna;
    }
    
    public void addHijo(Nodo hijo){
        hijos = new ArrayList();
        this.hijos.add(hijo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return "Nodo{" + "tipo=" + tipo + ", hijos=" + hijos + ", linea=" + linea + ", columna=" + columna + '}';
    }


  
}


