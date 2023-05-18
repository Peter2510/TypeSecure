/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones.functions;

import com.peter.typesecure.analisis.ejecucion.auxiliares.Parameter;
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
    private ArrayList<Parameter> parameters;
    private ArrayList<Instruction> instruccions;
    
    public Function_Without_Type_Parameters(Object linea, Object columna,Object name, VariableType type,ArrayList<Parameter> parameters,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.name = (String) name;
        this.type = type;
        this.parameters = parameters;
        this.instruccions = instructions;
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

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<Instruction> getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.instruccions = instruccions;
    }
     
    @Override
    public String toString() {
        return "Function_Without_Type_Parameters{" + "name=" + name + ", type=" + type + ", parameters=" + parameters + ", instruccions=" + instruccions + '}';
    }
        
}
