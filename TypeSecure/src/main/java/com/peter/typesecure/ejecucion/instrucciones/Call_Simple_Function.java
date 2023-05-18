/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;

/**
 *
 * @author GORDILLOG
 */
public class Call_Simple_Function extends Instruction{

    private String id;
    private Boolean simple;
    
    public Call_Simple_Function(Object linea, Object columna,Object id) {
        super(linea, columna);
        this.id = (String)id;
        this.simple = true;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        

        if(table.existeFuncion(id)){
            System.out.println("La funcion existe" + table.getFuncion(id));
            return this;
        }else{
            System.out.println("No existe la funcion " + id);
            return null;
        }
        
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    @Override
    public String toString() {
        return "Call_Simple_Function{" + "id=" + id + ", simple=" + simple + '}';
    }
    
}
