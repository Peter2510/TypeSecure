/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.archivos.Dot;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.MathType;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Function_Math extends Instruction {

    private MathType type;
    private Instruction operation;
    private Instruction operation1;

    public Function_Math(Object linea, Object columna, MathType type, Object operation) {
        super(linea, columna);
        this.type = type;
        this.operation = (Instruction) operation;
    }

    public Function_Math(Object linea, Object columna, MathType type, Object operation, Object operation1) {
        super(linea, columna);
        this.type = type;
        this.operation = (Instruction) operation;
        this.operation1 = (Instruction) operation1;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        Variable var = (Variable) operation.ejecutar(table);
        

        switch (type) {
            case ABS:
                return generateValue(var, MathType.ABS, table);
            case CEIL:
                return generateValue(var, MathType.CEIL, table);
            case COS:
                return generateValue(var, MathType.COS, table);
            case SIN:
                return generateValue(var, MathType.SIN, table);
            case TAN:
                return generateValue(var, MathType.TAN, table);
            case EXP:
                return generateValue(var, MathType.EXP, table);
            case FLOOR:
                return generateValue(var, MathType.FLOOR, table);
            case POW:
                return generateValue(MathType.POW,table);
            case SQRT:
                return generateValue(var, MathType.SQRT, table);
        }

        return null;
    }

    public Object generateValue(Variable var, MathType type, SymbolTable table) {
        if (var != null) {

            if (var.getValue() != null) {

                if (var.getType() == VariableType.BIGINT || var.getType() == VariableType.NUMBER && !"undefined".equals(var.getValue().toString())) {

                    if (var.getType() == VariableType.NUMBER) {
                        Variable tmp = new Variable();
                        tmp.setType(VariableType.NUMBER);
                        switch (type) {

                            case ABS:
                                tmp.setValue(Math.abs((Double) var.getValue()));
                                return tmp;
                            case CEIL:
                                tmp.setValue(Math.ceil((Double) var.getValue()));
                                return tmp;
                            case COS:
                                tmp.setValue(Math.cos((Double) var.getValue()));
                                return tmp;
                            case SIN:
                                tmp.setValue(Math.sin((Double) var.getValue()));
                                return tmp;
                            case TAN:
                                tmp.setValue(Math.tan((Double) var.getValue()));
                                return tmp;
                            case EXP:
                                tmp.setValue(Math.exp((Double) var.getValue()));
                                return tmp;
                            case FLOOR:
                                tmp.setValue(Math.floor((Double) var.getValue()));
                                return tmp;
                            case SQRT:
                                if ((Double) var.getValue() < 0) {
                                    table.agrearErrores(new Error_analizadores("Semantico", var.getValue() + "", this.getLinea(), this.getColumna(), this.type + " no puede calcularse a valores negativos"));
                                    return null;
                                } else {
                                    tmp.setValue(Math.sqrt((Double) var.getValue()));
                                    return tmp;
                                }
                        }

                    } else {

                        Variable tmp = new Variable();
                        tmp.setType(VariableType.BIGINT);
                        String value_string = (String) var.getValue();
                        int value = Integer.parseInt(value_string.substring(0, value_string.length() - 1));
                        switch (type) {
                            case ABS:
                                int value_int_abs = (int) Math.abs(value);
                                tmp.setValue( value_int_abs + "n");
                                return tmp;
                            case CEIL:
                                int value_int_ceil = (int) Math.ceil(value);
                                tmp.setValue( value_int_ceil + "n");
                                return tmp;
                            case COS:
                                int value_int_cos = (int) Math.cos(value);
                                tmp.setValue( value_int_cos + "n");
                                return tmp;
                            case SIN:
                                int value_int_sin = (int) Math.sin(value);
                                tmp.setValue( value_int_sin + "n");
                                return tmp;
                            case TAN:
                                int value_int_tan = (int) Math.tan(value);
                                tmp.setValue( value_int_tan + "n");
                                return tmp;
                            case EXP:
                                int value_int_exp = (int) Math.exp(value);
                                tmp.setValue( value_int_exp + "n");
                                return tmp;
                            case FLOOR:
                                int value_int_floor = (int) Math.floor(value);
                                tmp.setValue( value_int_floor + "n");
                                return tmp;
                            case SQRT:
                                if ( value < 0) {
                                    table.agrearErrores(new Error_analizadores("Semantico", var.getValue() + "", this.getLinea(), this.getColumna(), this.type + " no puede calcularse a valores negativos"));
                                    return null;
                                } else {
                                    int value_int_sqrt = (int) Math.sqrt(value);
                                    tmp.setValue( value_int_sqrt + "n");
                                    return tmp;
                                }
                        }
                    }

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), this.type + " puede calcularse solamente a valores de tipo bigint o number"));
                    return null;
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El valor del argumento no tiene un valor definido"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La operacion Math." + this.type + " no puede ejecutarse sobre un valor no definido"));
            return null;
        }
        return null;
    }
    
    public Object generateValue(MathType type, SymbolTable table) {
        Variable var = (Variable) operation.ejecutar(table);
        Variable var2 = (Variable) operation1.ejecutar(table);
        if (var != null && var2!=null) {

            if (var.getValue() != null && var2.getValue()!=null) {

                if ((var.getType() == VariableType.BIGINT || var.getType() == VariableType.NUMBER) &&(var2.getType() == VariableType.BIGINT || var2.getType() == VariableType.NUMBER) && !"undefined".equals(var.getValue().toString())) {

                    if(var.getType()==var2.getType()){
                        
                        if(var.getType()==VariableType.NUMBER){
                            Variable tmp = new Variable();
                            tmp.setType(VariableType.NUMBER);
                            tmp.setValue(Math.pow((Double)var.getValue(),(Double)var2.getValue()));
                            return tmp;
                        }else{
                            Variable tmp = new Variable();
                            tmp.setType(VariableType.BIGINT);
                            String value_string = (String) var.getValue();
                            String value_string2 = (String) var2.getValue();
                            int value = Integer.parseInt(value_string.substring(0, value_string.length() - 1));
                            int value2 = Integer.parseInt(value_string2.substring(0, value_string.length() - 1));
                            tmp.setValue((int)Math.pow(value,value2) + "n");
                            return tmp;

                        }
                        
                    }else{
                        table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), this.type + " puede calcularse solamente cuando los valores sean del mismo tipo"));    
                    }
                    

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), this.type + " puede calcularse solamente a valores de tipo bigint o number"));
                    return null;
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "El valor del argumento no tiene un valor definido"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La operacion Math." + this.type + " no puede ejecutarse sobre valores no definidos"));
            return null;
        }
        return null;
    }

    public MathType getType() {
        return type;
    }

    public void setType(MathType type) {
        this.type = type;
    }

    public Instruction getOperation() {
        return operation;
    }

    public void setOperation(Instruction operation) {
        this.operation = operation;
    }

    public Instruction getOperation1() {
        return operation1;
    }

    public void setOperation1(Instruction operation1) {
        this.operation1 = operation1;
    }

    @Override
    public String toString() {
        return "Math{" + "type=" + type + ", operation=" + operation + ", operation1=" + operation1 + '}';
    }

        @Override
    public String convertGraphviz(Dot dot) {
        return "";
    }

}
