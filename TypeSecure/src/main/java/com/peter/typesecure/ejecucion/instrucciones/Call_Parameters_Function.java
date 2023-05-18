/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Call_Parameters_Function extends Instruction{

    private String id;
    private ArrayList<Instruction> instruccions;
    
    public Call_Parameters_Function(Object linea, Object columna,Object id,ArrayList<Instruction> instruccion) {
        super(linea, columna);
        this.id = (String)id;
        this.instruccions = instruccion;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Call_Parameters_Function");
        System.out.println("id");
        System.out.println(instruccions);
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Instruction> getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.instruccions = instruccions;
    }
    
    @Override
    public String toString() {
        return "Call_Parameters_Function{" + "id=" + id + ", instruccions=" + instruccions + '}';
    }
    
}
