/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.analisis.ejecucion.auxiliares;

import com.peter.typesecure.ejecucion.Genericos.VariableType;

/**
 *
 * @author GORDILLOG
 */
public class Parameter {

    private String id;
    private VariableType type;
    private int linea;
    private int columna;

    public Parameter(int linea, int columna,String id, VariableType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Parameter{" + "id=" + id + ", type=" + type + ", linea=" + linea + ", columna=" + columna + '}';
    }
    
}