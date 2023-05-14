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
public class Minus extends Instruction {

    private Instruction instruction;
    
    public Minus(Object linea, Object columna,Object instruction) {
        super(linea, columna);
        this.instruction = (Instruction)instruction;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        
        Variable valor_tmp = (Variable) instruction.ejecutar(table);
        
        if(valor_tmp!=null){
            
            if(valor_tmp.getValue()!=null){
                Variable new_variable = new Variable();
                if(valor_tmp.getType()==VariableType.NUMBER){
                    new_variable.setType(VariableType.NUMBER);
                    new_variable.setValue((Double)valor_tmp.getValue()*-1);
                    return new_variable;
                }
                
            }else{
                table.agrearErrores(new Error_analizadores("Semantico", valor_tmp.getId(),this.getLinea(), this.getColumna(), "La variable no tiene valor"));
                return null;
            }
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", "",this.getLinea(), this.getColumna(), "No puede realizarse la operacion, verifica que los valores esten definidos"));
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
        return "Minus{" + "instruction=" + instruction + '}';
    }
    
}
