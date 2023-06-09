/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.archivos.Dot;

/**
 *
 * @author GORDILLOG
 */
public abstract class Instruction {
    private int linea;
    private int columna;
    
    public Instruction(Object linea, Object columna){
        this.linea = (int) linea;
        this.columna = (int) columna;
    }
    
    public abstract Object ejecutar(SymbolTable table);
    
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
    
    public abstract String convertGraphviz(Dot dot);
    
    
}
