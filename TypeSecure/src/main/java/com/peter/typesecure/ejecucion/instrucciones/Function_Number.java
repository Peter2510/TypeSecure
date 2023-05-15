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
public class Function_Number extends Instruction {

    private Instruction operator;

    public Function_Number(Object linea, Object columna, Object operator) {
        super(linea, columna);
        this.operator = (Instruction) operator;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        Variable var = (Variable) operator.ejecutar(table);

        if (var != null) {

            if (var.getValue() != null && !"undefined".equals(var.getValue().toString())) {

                Variable new_Var = new Variable();
                new_Var.setType(VariableType.NUMBER);

                switch (var.getType()) {
                    case NUMBER:
                        new_Var.setValue((Double) var.getValue());
                        return new_Var;

                    case BIGINT:
                        String value_string = (String) var.getValue();
                        Double value_number = Double.parseDouble(value_string.substring(0, value_string.length() - 1));
                        new_Var.setValue(value_number);
                        return new_Var;
                    case BOOLEAN:
                        if ((Boolean) var.getValue() == true) {
                            double value_boolean = 1.0;
                            new_Var.setValue(value_boolean);
                            return new_Var;
                        } else {
                            double value_boolean = 0.0;
                            new_Var.setValue(value_boolean);
                            return new_Var;
                        }
                    case STRING:
                        String value_str = (String) var.getValue();

                        if (value_str.isBlank()==false) {
                            try {
                                Double value = Double.parseDouble(value_str);
                                new_Var.setValue(value);
                                return new_Var;
                            } catch (Exception e) {
                                table.agrearErrores(new Error_analizadores("Semantico", var.getValue().toString(), this.getLinea(), this.getColumna(), "El argumento de la funcion puede no convertirse a number, no contiene un valor numerico"));
                                return null;
                            }
                        } else {
                            double val_double = 0;
                            new_Var.setValue(val_double);
                            return new_Var;
                        }
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El argumento de la funcion Number no tiene un valor definido"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El argumento de la funcion Number no esta definido"));
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
        return "Function_Number{" + "operator=" + operator + '}';
    }

}
