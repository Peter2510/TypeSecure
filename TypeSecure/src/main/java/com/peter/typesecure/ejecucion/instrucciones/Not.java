/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Not extends Instruction{

    private Instruction instruction;
    
    public Not(Object linea, Object columna,Object instruction) {
        super(linea, columna);
        this.instruction = (Instruction)instruction;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable variable_temporal = (Variable) instruction.ejecutar(table);
        
        if(variable_temporal!=null){
            if(variable_temporal.getValue()!=null&&variable_temporal.getType()==VariableType.BOOLEAN){
                Variable tmp = new Variable();
                Boolean valor = (Boolean) variable_temporal.getValue();
                tmp.setValue(!valor);
                tmp.setType(VariableType.BOOLEAN);
                return tmp;
            }else{
                table.agrearErrores(new Error_analizadores("Semantico",variable_temporal.getValue()+"", this.getLinea(), this.getColumna(), "No se puede negar un valor no Booleano"));
            }
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La variable no tiene valor"));
            return null;
        }
        return null;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "Not{" + "instruction=" + instruction + '}';
    }
    @Override
    public String convertGraphviz() {
        return "";
    }

}
