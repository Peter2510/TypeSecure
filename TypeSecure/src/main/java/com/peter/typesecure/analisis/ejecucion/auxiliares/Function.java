/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.analisis.ejecucion.auxiliares;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function {
    private String id;
    private VariableType type;
    private ArrayList<Parameter> parameters;
    private ArrayList<Instruction> instructions;
    private int linea;
    private int columna;

    public Function(int linea, int columna,String id, VariableType type, ArrayList<Parameter> parameters,ArrayList<Instruction> instructions ) {
        this.linea = linea;
        this.columna = columna;
        this.id = id;
        this.type = type;
        this.parameters = parameters;
        this.instructions = instructions;
    }
    
    public Boolean hasReturn(){
        if(type!=VariableType.VOID){
            return true;
        }else{
            return false;
        }
    }
    
    public Boolean hasParameters(){
        if(parameters!=null){
            return true;
        }else{
            return false;
        }
    }
    
    public int getSizeParameters(){
        if(parameters==null){
            return 0;
        }else{
            return parameters.size();
        }
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

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

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

    @Override
    public String toString() {
        return "Function{" + "id=" + id + ", type=" + type + ", parameters=" + parameters + ", instructions=" + instructions + ", linea=" + linea + ", columna=" + columna + '}';
    }
    
}
