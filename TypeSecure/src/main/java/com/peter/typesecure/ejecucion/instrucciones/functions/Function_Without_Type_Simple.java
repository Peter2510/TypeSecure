/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones.functions;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import java.util.ArrayList;


/**
 *
 * @author GORDILLOG
 */
public class Function_Without_Type_Simple extends Instruction {

    private String name;
    private VariableType type;
    private ArrayList<Instruction> instruccions;

    
    public Function_Without_Type_Simple(Object linea, Object columna,Object name, VariableType type,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.name = (String)name;
        this.type = type;
        this.instruccions = instructions;       
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Function_Without_Type_Simple");
        System.out.println(type);
        System.out.println(instruccions);
        System.out.println(name);
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public ArrayList<Instruction> getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.instruccions = instruccions;
    }
    
    @Override
    public String toString() {
        return "Function_Without_Type_Simple{" + "name=" + name + ", type=" + type + ", instruccions=" + instruccions + '}';
    }
    
}
