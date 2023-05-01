/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

/**
 *
 * @author GORDILLOG
 */
public abstract class Instruction {
    private int linea;
    private int columna;
    
    public Instruction(int linea, int columna){
        this.linea = linea;
        this.columna = columna;
    }
    
    public abstract Object ejecutar(SymbolTable table);
    
    public abstract void ejecutar_1(SymbolTable table);

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
    
    
}
