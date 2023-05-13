package com.peter.typesecure.error;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author GORDILLOG
 */
public class Error_analizadores {
    String tipo;
    String lexema="";
    int fila;
    int columna;
    String descripcion;

    public Error_analizadores(String tipoError, String lexema, int fila, int columna, String descripcion) {
        this.tipo = tipoError;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
    }
    
    public Error_analizadores(String tipoError, int fila, int columna, String descripcion) {
        this.tipo = tipoError;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
    }
    
    public Error_analizadores(String tipoError, String descripcion) {
        this.tipo = tipoError;
        this.descripcion = descripcion;
    }
   
    public String getTipoError() {
        return tipo;
    }

    public void setTipoError(String tipoError) {
        this.tipo = tipoError;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Errores{" + "tipoError=" + tipo + ", lexema=" + lexema + ", fila=" + fila + ", columna=" + columna + ", descripcion=" + descripcion + '}';
    }

}
