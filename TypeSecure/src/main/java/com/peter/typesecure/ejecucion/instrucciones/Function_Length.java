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
public class Function_Length extends Instruction{

    private Instruction operator;
    
    public Function_Length(Object linea, Object columna,Object operator) {
        super(linea, columna);
        this.operator = (Instruction)operator;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        
        Variable var_tmp = (Variable) operator.ejecutar(table);
        
        if(var_tmp!=null){

            if(var_tmp.getValue()!=null){
                
                if(var_tmp.getType()==VariableType.STRING&&!"undefined".equals(var_tmp.getValue().toString())){
                    Variable var = new Variable();
                    var.setType(VariableType.NUMBER);
                    String value_string = (String) var_tmp.getValue();

                    double value_double = (double) value_string.length();
                    var.setValue(value_double);
                    return var;
                    
                }else{
                    table.agrearErrores(new Error_analizadores("Semantico", var_tmp.getValue()+"", this.getLinea(), this.getColumna(), "La funcion length es aplicable unicamente a valores de tipo string"));
                    return null;                                    
                }
                
            }else{
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La variable no tiene valor"));
                return null;                
            }
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El valor para calcular la longitud de la cadena no esta definido"));
            return null;
            
        }
        
    }

    public Instruction getOperator() {
        return operator;
    }

    public void setOperator(Instruction operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Function_Length{" + "operator=" + operator + '}';
    }
    
    @Override
    public String convertGraphviz() {
        return "";
    }    
}
