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
public class Function_Concat extends Instruction{

    private Instruction firstOperator;
    private Instruction secondOperator;
    
    public Function_Concat(Object linea, Object columna,Object first, Object second) {
        super(linea, columna);
        this.firstOperator = (Instruction) first;
        this.secondOperator = (Instruction) second;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        Variable var_1 = (Variable) firstOperator.ejecutar(table);
        Variable var_2 = (Variable) secondOperator.ejecutar(table);
        
        if(var_1!=null&&var_2!=null){
            
            if(var_1.getValue()!=null && var_2.getValue()!=null &&!"undefined".equals(var_1.getValue().toString())&&!"undefined".equals(var_2.getValue().toString())){
                
                if(var_1.getType()==VariableType.STRING&&var_2.getType()==VariableType.STRING){
                    
                    Variable var = new Variable();
                    String val_1_string = (String)var_1.getValue();
                    String val_2_string = (String)var_2.getValue();
                    var.setType(VariableType.STRING);
                    var.setValue(val_1_string.concat(val_2_string));
                    return var;
                }else{
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "Los valores a concatenar deben ser de tipo string"));
                    return null;                                    
                }
                
                
            }else{
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "Los valores a concatenar deben estar definidos"));
                return null;                
            }
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "Los valores a concatenar deben estar definidos"));
            return null;
        }
        
       
    }

    public Instruction getFirstOperator() {
        return firstOperator;
    }

    public void setFirstOperator(Instruction firstOperator) {
        this.firstOperator = firstOperator;
    }

    public Instruction getSecondOperator() {
        return secondOperator;
    }

    public void setSecondOperator(Instruction secondOperator) {
        this.secondOperator = secondOperator;
    }

    @Override
    public String toString() {
        return "Function_Concat{" + "firstOperator=" + firstOperator + ", secondOperator=" + secondOperator + '}';
    }
    
}
