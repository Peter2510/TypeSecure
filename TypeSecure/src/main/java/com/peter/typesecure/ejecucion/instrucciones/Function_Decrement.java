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
public class Function_Decrement extends Instruction{

    private String id;
    
    public Function_Decrement(Object linea, Object columna,Object id) {
        super(linea, columna);
        this.id = (String)id;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Function_Decrement");
        System.out.println(id);
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Function_Decrement{" + "id=" + id + '}';
    }
    
}
