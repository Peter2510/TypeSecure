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
public class Function_BigInt extends Instruction{

    private Instruction operator;
    
    public Function_BigInt(Object linea, Object columna,Object operator) {
        super(linea, columna);
        this.operator = (Instruction) operator;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable var = (Variable) operator.ejecutar(table);

        if (var != null) {

            if (var.getValue() != null) {

                Variable new_Var = new Variable();
                new_Var.setType(VariableType.BIGINT);

                switch (var.getType()) {
                    case BIGINT:
                        new_Var.setValue((String) var.getValue());
                        return new_Var;

                    case NUMBER:
                        double value_double = (Double) var.getValue();
                        int value_int = (int) value_double;
                        new_Var.setValue(value_int+"n");
                        return new_Var;
                    case BOOLEAN:
                        if ((Boolean) var.getValue() == true) {
                            int value_boolean = 1;
                            new_Var.setValue(value_boolean+"n");
                            return new_Var;
                        } else {
                            int value_boolean = 0;
                            new_Var.setValue(value_boolean+"n");
                            return new_Var;
                        }
                    case STRING:
                        String value_str = (String) var.getValue();

                        if (value_str.isBlank()==false) {
                            try {
                                int value = Integer.parseInt(value_str);
                                new_Var.setValue(value+"n");
                                return new_Var;
                            } catch (Exception e) {
                                table.agrearErrores(new Error_analizadores("Semantico", var.getValue().toString(), this.getLinea(), this.getColumna(), "El argumento de la funcion no puede convertirse a bigint, no contiene un valor numerico"));
                                return null;
                            }
                        } else {
                            int val_int = 0;
                            new_Var.setValue(val_int+"n");
                            return new_Var;
                        }
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El argumento de la funcion BigInt no tiene un valor definido"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El argumento de la funcion BigInt no esta definido"));
            return null;
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
        return "Function_BigInt{" + "operator=" + operator + '}';
    }
      
}
