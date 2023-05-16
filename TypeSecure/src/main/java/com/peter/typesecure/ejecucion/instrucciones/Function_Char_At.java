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
public class Function_Char_At extends Instruction {

    private Instruction operator;
    private Instruction index;

    public Function_Char_At(Object linea, Object columna, Object operator, Object index) {
        super(linea, columna);
        this.operator = (Instruction) operator;
        this.index = (Instruction) index;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        Variable var_tmp = (Variable) operator.ejecutar(table);

        if (var_tmp != null) {

            if (var_tmp.getValue() != null) {

                Variable var_index = (Variable) index.ejecutar(table);

                if (var_index != null) {

                    if (var_index.getType() == VariableType.NUMBER) {
                        if (var_tmp.getType() == VariableType.STRING) {

                            String value_string = (String) var_tmp.getValue();
                            int value_int = value_string.length();
                            double value_index = (double) var_index.getValue();
                            int value_index_int = (int) value_index;
                            
                            if(value_index>=0&&value_index<value_int&&value_index%1==0){
                                
                                Variable var = new Variable();
                                var.setType(VariableType.STRING);
                                String char_at = value_string.charAt(value_index_int)+"";
                                var.setValue(char_at);
                                return var;
                                
                            }else{
                                table.agrearErrores(new Error_analizadores("Semantico", var_index.getValue() + "", this.getLinea(), this.getColumna(), "El valor de index debe ser mayor a cero y menor a la longitud de la cadena, y no tener decimales en su valor"));
                                return null;                                
                            }
                        } else {
                            table.agrearErrores(new Error_analizadores("Semantico", var_tmp.getValue() + "", this.getLinea(), this.getColumna(), "CharAt solamente es aplicable al tipo de dato string"));
                            return null;
                        }
                    } else {
                            table.agrearErrores(new Error_analizadores("Semantico", var_index.getValue() + "", this.getLinea(), this.getColumna(), "El index debe ser un valor de tipo number"));
                            return null;
                    }

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El valor de index no esta definido"));
                    return null;
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La variable no tiene valor"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El valor para calcular charAt no esta definido"));
            return null;
        }

    }

    public Instruction getOperator() {
        return operator;
    }

    public void setOperator(Instruction operator) {
        this.operator = operator;
    }

    public Instruction getIndex() {
        return index;
    }

    public void setIndex(Instruction index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Function_Char_At{" + "operator=" + operator + ", index=" + index + '}';
    }

}
