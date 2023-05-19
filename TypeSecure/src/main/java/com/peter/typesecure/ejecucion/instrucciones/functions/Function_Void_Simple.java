/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones.functions;

import com.peter.typesecure.analisis.ejecucion.auxiliares.Function;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_Void_Simple extends Instruction{

    private VariableType type;
    private String name;
    private ArrayList<Instruction> instruccions;
       
    public Function_Void_Simple(Object linea, Object columna,Object name,VariableType type, ArrayList<Instruction> instructions ) {
        super(linea, columna);
        this.name = (String)name;
        this.type = type;
        this.instruccions = instructions;
       
    }
    
    

    @Override
    public Object ejecutar(SymbolTable table) {
            
        if(table.existeFuncion(name)==false){
            
            table.agregarFuncion(name, new Function(this.getLinea(),this.getColumna(),name,type,null,instruccions));
            return this;            
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '"+ name +"' ya esta definida "));
            return null;
        }
        

        
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Instruction> getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.instruccions = instruccions;
    }

    @Override
    public String toString() {
        return "Function_Void_Simple{" + "type=" + type + ", name=" + name + ", instruccions=" + instruccions + '}';
    }
    
}
