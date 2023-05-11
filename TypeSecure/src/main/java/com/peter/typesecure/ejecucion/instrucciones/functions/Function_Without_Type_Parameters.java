/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones.functions;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author GORDILLOG
 */
public class Function_Without_Type_Parameters extends Instruction {

    private String name;
    private VariableType type;
    private Map<String, VariableType> parameters;
    private ArrayList<Instruction> instruccions;
    private Boolean simple;
    
    public Function_Without_Type_Parameters(Object linea, Object columna,Object name, VariableType type, Map<String,VariableType> parameters,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.name = (String) name;
        this.type = type;
        this.parameters = parameters;
        this.instruccions = instructions;
        this.simple = false;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Function_Without_Type_Parameters");
        System.out.println(name);
        System.out.println(type);
        System.out.println(parameters);
        System.out.println(instruccions);
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

    public Map<String, VariableType> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, VariableType> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<Instruction> getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.instruccions = instruccions;
    }

    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }
     
    @Override
    public String toString() {
        return "Function_Without_Type_Parameters{" + "name=" + name + ", type=" + type + ", parameters=" + parameters + ", instruccions=" + instruccions + '}';
    }
        
}
