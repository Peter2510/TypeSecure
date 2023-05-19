/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.AccessType;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Decrement extends Instruction{

    private String id;
    
    public Decrement(Object linea, Object columna,Object id) {
        super(linea, columna);
        this.id = (String) id;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
 Variable var = (Variable)table.getById(id);
        if(var!=null){
            
            if(var.getValue()!=null && !"undefined".equals(var.getValue().toString())){
                
                if(var.getType()==VariableType.BIGINT || var.getType() == VariableType.NUMBER){
                    
                    if(var.getAccess()==AccessType.LET){
                        
                        if(var.getType()==VariableType.NUMBER){
                            
                            Variable newV = new Variable();
                            double val_d = (double) var.getValue();
                            double val_n = val_d - 1.0;
                            var.setValue(val_n);
                            newV.setType(VariableType.NUMBER);
                            newV.setValue(val_n);
                            return newV;
                            
                        }else{
                            Variable newV = new Variable();
                            String val_1 = (String)var.getValue();
                            int val_int = Integer.parseInt(val_1.substring(0, val_1.length()-1))-1;
                            String newVal = val_int+"n";
                            var.setValue(newV);
                            newV.setType(VariableType.BIGINT);
                            newV.setValue(newVal);
                            return newV;                            
                            
                        }
                        
                    }else{
                        table.agrearErrores(new Error_analizadores("Semantico", id, this.getLinea(), this.getColumna(), "Las variables declaradas como 'const' no pueden cambiar de valor"));
                        return null;                                                                                
                    }
                    
                }else{
                    table.agrearErrores(new Error_analizadores("Semantico", id, this.getLinea(), this.getColumna(), "Para decrementar el valor de la variable '"+ id +"', esta debe ser de tipo number o bigint"));
                    return null;                                                        
                }
                
            }else{
                table.agrearErrores(new Error_analizadores("Semantico", id, this.getLinea(), this.getColumna(), "La variable '"+ id +"' no ha sido inicializada"));
                return null;                                    
            }
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico", id, this.getLinea(), this.getColumna(), "La variable '"+ id +"' no esta definida, por lo tanto no puede decrementarse su valor"));
            return null;                    
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Decrement{" + "id=" + id + '}';
    }

    @Override
    public String convertGraphviz() {
        return "";
    }
}
