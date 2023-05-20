/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.archivos.Dot;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;

/**
 *
 * @author GORDILLOG
 */
public class Function_Boolean extends Instruction {

    private Instruction operator;
    
    public Function_Boolean(Object linea, Object columna, Object operator) {
        super(linea, columna);
        this.operator = (Instruction) operator;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable var_tmp = (Variable) operator.ejecutar(table);
        System.out.println(var_tmp);
        Variable var = new Variable();
        var.setType(VariableType.BOOLEAN);
        Boolean val_f = false;
        Boolean val_v = true;
        if(var_tmp!=null){
            
            if(var_tmp.getValue()!=null && !"undefined".equals(var_tmp.getValue().toString())){
            
                switch (var_tmp.getType()) {
                    case BOOLEAN:
                        var.setValue((Boolean)var_tmp.getValue());
                        return var;
                    case NUMBER:   
                        if((Double)var_tmp.getValue()==0){
                            var.setValue(val_f);
                            return var;                            
                        }else{
                            var.setValue(val_v);    
                            return var;
                        }
                    case BIGINT:
                        String value_big_string = (String)var_tmp.getValue();
                        int value_bit_int = Integer.parseInt(value_big_string.substring(0,value_big_string.length()-1));
                        if(value_bit_int!=0){
                            var.setValue(val_v);
                            return var;                              
                        }else{
                            var.setValue(val_f);
                            return var;                              
                        }                       
                    case STRING:
                        String value_string = (String)var_tmp.getValue();
                        if(value_string.isEmpty()){
                            var.setValue(val_f);
                            return var;                                                          
                        }else{
                            var.setValue(val_v);
                            return var;                                                          
                        }

                }
                
            }else{

                var.setValue(val_f);
                return var;
            }
            
        }else{

            var.setValue(val_f);
            return var;
        }
        
        return null;
    }

    public Instruction getOperator() {
        return operator;
    }

    public void setOperator(Instruction operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Function_Boolean{" + "operator=" + operator + '}';
    }
    
    @Override
    public String convertGraphviz(Dot dot) {
        return "";
    }
        
}
