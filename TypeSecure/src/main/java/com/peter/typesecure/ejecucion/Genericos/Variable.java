/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

/**
 *
 * @author GORDILLOG
 */
public class Variable {

    private String id;
    private VariableType type;
    private Object value;
    private AccessType access;
    private int linea;
    private int columna;

    public Variable() {

    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType access) {
        this.access = access;
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

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(Object linea) {
        this.linea = (int) linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(Object columna) {
        this.columna = (int) columna;
    }

    @Override
    public String toString() {
        return "Variable{" + "id=" + id + ", type=" + type + ", value=" + value + ", access=" + access + ", linea=" + linea + ", columna=" + columna + '}';
    }
    
}
