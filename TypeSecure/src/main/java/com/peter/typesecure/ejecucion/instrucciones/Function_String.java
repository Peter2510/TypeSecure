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
public class Function_String extends Instruction {

    private Instruction operator;
    
    public Function_String(Object linea, Object columna, Object operator) {
        super(linea, columna);
        this.operator = (Instruction)operator;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        Variable var_tmp = (Variable)operator.ejecutar(table);
        Variable var = new Variable();
        var.setType(VariableType.STRING);
        
        if(var_tmp!=null){
            
            switch (var_tmp.getType()) {
                case STRING:               
                var.setValue((String)var_tmp.getValue());
                return var;
                
                case NUMBER:
                var.setValue(var_tmp.getValue().toString());
                return var;                    
                
                case BIGINT:
                var.setValue(var_tmp.getValue().toString());
                return var;                    
                
                case BOOLEAN:
                var.setValue(var_tmp.getValue().toString());
                return var;                    
                
                case PENDIENTE:
                var.setValue(var_tmp.getValue().toString());
                return var;                                        
                
            }
            
        }else{
            var.setValue("undefined");
            return var;
        }
        var.setValue("undefined");
        return var;        
        
        
    }

    public Instruction getOperator() {
        return operator;
    }

    public void setOperator(Instruction operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Function_String{" + "operator=" + operator + '}';
    }
    @Override
    public String convertGraphviz() {
        return "";
    }    
}
