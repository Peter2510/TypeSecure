/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Condicionales;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class If extends Instruction {

    private Instruction conditional;
    private ArrayList<Instruction> instructions;

    public If(int linea, int columna, Object conditional, ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.conditional = (Instruction) conditional;
        this.instructions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        Variable value = (Variable) conditional.ejecutar(table);

        if (value != null) {

            if (!"undefined".equals(value.getValue().toString())&&value.getValue()!=null) {

                
                if(value.getType()==VariableType.BOOLEAN){
                    
                    Variable var = new Variable();
                    Boolean value_boolean = (Boolean) value.getValue();
                    var.setType(VariableType.BOOLEAN);
                    var.setValue(value_boolean);
                    return var;
                    
                }else{
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El condicional de if debe ser de tipo boolean"));
                    return null;                    
                }
                
                
            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El condicional de if debe estar definido"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El condicional de if debe estar definido"));
            return null;
        }
 
    }

    public Instruction getConditional() {
        return conditional;
    }

    public void setConditional(Instruction conditional) {
        this.conditional = conditional;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "If{" + "conditional=" + conditional + ", instructions=" + instructions + '}';
    }

}
