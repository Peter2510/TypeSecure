/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones.functions;

import com.peter.typesecure.analisis.ejecucion.auxiliares.Function;
import com.peter.typesecure.analisis.ejecucion.auxiliares.Parameter;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author GORDILLOG
 */
public class Function_Void_Parameters extends Instruction {
    
    private String name;
    private VariableType type;
    private ArrayList<Parameter> parameters;
    private ArrayList<Instruction> instruccions;
    
    
    
    public Function_Void_Parameters(Object linea, Object columna,Object name,VariableType type,ArrayList<Parameter> parameters,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.name = (String)name;
        this.type = type;
        this.parameters = parameters;
        this.instruccions = instructions;
    
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //guardar en la tabla de simbolos
        
        if(table.existeFuncion(name)==false){
            
            table.agregarFuncion(name, new Function(name,type,parameters,instruccions));
            return this;
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '"+ name +"' ya esta definida "));
            return null;
        }
        
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
        return "Function_Void_Parameters{" + "name=" + name + ", type=" + type + ", parameters=" + parameters + ", instruccions=" + instruccions + '}';
    }
    
}
