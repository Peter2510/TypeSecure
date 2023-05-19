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
public class Function_Upper extends Instruction {

    private Instruction operator;
    
    public Function_Upper(Object linea, Object columna,Object operator) {
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
                    var.setType(VariableType.STRING);
                    String val_string = (String) var_tmp.getValue();
                    var.setValue(val_string.toUpperCase());
                    return var;
                    
                }else{
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La funcion toUpperCase puede calcularse solamente a valores de tipo string"));
                    return null;                                    
                }
                
            }else{
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La funcion toUpperCase no puede calcularse a valores no definidos"));
                return null;                
            }
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El valor para calcular toUpperCase no esta definido"));
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
        return "Function_Upper{" + "operator=" + operator + '}';
    }
    @Override
    public String convertGraphviz() {
        return "";
    }    
}
