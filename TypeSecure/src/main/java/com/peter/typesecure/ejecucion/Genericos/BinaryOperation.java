/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class BinaryOperation extends Instruction {

    private OperationType type;
    private Instruction leftOperator;
    private Instruction rightOperator;

    public BinaryOperation(Object linea, Object columna, Object type, Object leftOperator, Object rigthOperator) {
        super(linea, columna);
        this.type = (OperationType) type;
        this.leftOperator = (Instruction) leftOperator;
        this.rightOperator = (Instruction) rigthOperator;

    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable left = (Variable) leftOperator.ejecutar(table);
        Variable right = (Variable) rightOperator.ejecutar(table);

        Variable variable = new Variable();

        if (left != null && right != null) {
            //verificar que los valores a sumar sean del mismo tipo
            //si uno de ellos es string, se realiza la concatenacion

            switch (type) {
                case SUMA:
                    //si los valores tiene el mismo tipo  
                    if (left.getType() == right.getType()) {

                        if (left.getType() == VariableType.NUMBER && right.getType() == VariableType.NUMBER && right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            //suma number
                            variable.setValue((Double) left.getValue() + (Double) right.getValue());
                            variable.setType(VariableType.NUMBER);
                            return variable;
                        } else if (left.getType() == VariableType.STRING || right.getType() == VariableType.STRING) {
                            //concatenacion
                            variable.setValue(left.getValue().toString() + right.getValue().toString() + "");
                            variable.setType(VariableType.STRING);
                            return variable;
                        } else if (left.getType() == VariableType.BIGINT && right.getType() == VariableType.BIGINT) {
                            String value_tmp_left = (String) left.getValue();
                            String value_tmp_rigth = (String) right.getValue();
                            int value_left = Integer.parseInt(value_tmp_left.substring(0, value_tmp_left.length() - 1));
                            int value_right = Integer.parseInt(value_tmp_rigth.substring(0, value_tmp_rigth.length() - 1));
                            String newvalue = value_left + value_right + "n";
                            variable.setValue(newvalue);
                            variable.setType(VariableType.BIGINT);
                            return variable;
                        }else{
                            table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La variables no pueden sumarse, no son de tipo number o bigint"));
                            return null;
                        }

                    } else {
                        if (left.getType() == VariableType.STRING || right.getType() == VariableType.STRING) {
                            variable.setValue(left.getValue().toString() + right.getValue().toString() + "");
                            variable.setType(VariableType.STRING);
                            return variable;
                        }else{
                            table.agrearErrores(new Error_analizadores("Semantico","",this.getLinea(), this.getColumna(), "La variables no pueden sumarse, no tienen el mismo tipo de dato"));
                            table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "Las variables no pueden concatenarse"));                           
                            return null;
                        }
                    }
                case RESTA:
                    if (left.getType() == right.getType()) {
                        if (left.getType() == VariableType.NUMBER && right.getType() == VariableType.NUMBER&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            //resta number
                            variable.setValue((Double) left.getValue() - (Double) right.getValue());
                            variable.setType(VariableType.NUMBER);
                            return variable;
                        } else if (left.getType() == VariableType.BIGINT && right.getType() == VariableType.BIGINT&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            String value_tmp_left = (String) left.getValue();
                            String value_tmp_rigth = (String) right.getValue();
                            int value_left = Integer.parseInt(value_tmp_left.substring(0, value_tmp_left.length() - 1));
                            int value_right = Integer.parseInt(value_tmp_rigth.substring(0, value_tmp_rigth.length() - 1));
                            String newvalue = value_left - value_right + "n";
                            variable.setValue(newvalue);
                            variable.setType(VariableType.BIGINT);
                            return variable;
                        }else{
                            table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede realizarse la resta, los valores no son de tipo number o bigint"));
                            return null;
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico", "",this.getLinea(), this.getColumna(), "No puede realizarse la resta, los valores no son de tipo number o bigint"));
                        return null;
                    }
                case DIVISION:
                if (left.getType() == right.getType()) {
                        if (left.getType() == VariableType.NUMBER && right.getType() == VariableType.NUMBER&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            //resta number
                            if((Double)right.getValue()==0){
                                table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede dividirse entre cero"));    
                            }else{
                                variable.setValue((Double) left.getValue() / (Double) right.getValue());
                                variable.setType(VariableType.NUMBER);
                                return variable;                                
                            }

                        } else if (left.getType() == VariableType.BIGINT && right.getType() == VariableType.BIGINT&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            String value_tmp_left = (String) left.getValue();
                            String value_tmp_rigth = (String) right.getValue();
                            int value_left = Integer.parseInt(value_tmp_left.substring(0, value_tmp_left.length() - 1));
                            int value_right = Integer.parseInt(value_tmp_rigth.substring(0, value_tmp_rigth.length() - 1));
                            if(value_right == 0){
                                table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede dividirse entre cero"));    
                            }else{
                                String newvalue = value_left / value_right + "n";
                                variable.setValue(newvalue);
                                variable.setType(VariableType.BIGINT);
                                return variable;
                            }
                            
                        }else{
                            table.agrearErrores(new Error_analizadores("Semantico", "",this.getLinea(), this.getColumna(), "No puede realizarse la division, los valores no son de tipo number o bigint"));
                            return null;
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico", "",this.getLinea(), this.getColumna(), "No puede realizarse la division, los valores no son de tipo number o bigint"));
                        return null;
                    }
                case MULTIPLICACION:
                    if (left.getType() == right.getType()) {
                        if (left.getType() == VariableType.NUMBER && right.getType() == VariableType.NUMBER&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            //resta number
                            variable.setValue((Double) left.getValue() * (Double) right.getValue());
                            variable.setType(VariableType.NUMBER);
                            return variable;
                        } else if (left.getType() == VariableType.BIGINT && right.getType() == VariableType.BIGINT) {
                            String value_tmp_left = (String) left.getValue();
                            String value_tmp_rigth = (String) right.getValue();
                            int value_left = Integer.parseInt(value_tmp_left.substring(0, value_tmp_left.length() - 1));
                            int value_right = Integer.parseInt(value_tmp_rigth.substring(0, value_tmp_rigth.length() - 1));
                            String newvalue = value_left * value_right + "n";
                            variable.setValue(newvalue);
                            variable.setType(VariableType.BIGINT);
                            return variable;
                        }else{
                            table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede realizarse la multiplicacion, los valores no son de tipo number o bigint"));
                            return null;
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico", "",this.getLinea(), this.getColumna(), "No puede realizarse la multiplicacion, los valores no son de tipo number o bigint"));
                        return null;
                    }
                case MOD:
                    if (left.getType() == right.getType()) {
                        if (left.getType() == VariableType.NUMBER && right.getType() == VariableType.NUMBER&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            //resta number
                            variable.setValue((Double) left.getValue() % (Double) right.getValue());
                            variable.setType(VariableType.NUMBER);
                            return variable;
                        } else if (left.getType() == VariableType.BIGINT && right.getType() == VariableType.BIGINT) {
                            String value_tmp_left = (String) left.getValue();
                            String value_tmp_rigth = (String) right.getValue();
                            int value_left = Integer.parseInt(value_tmp_left.substring(0, value_tmp_left.length() - 1));
                            int value_right = Integer.parseInt(value_tmp_rigth.substring(0, value_tmp_rigth.length() - 1));
                            String newvalue = value_left % value_right + "n";
                            variable.setValue(newvalue);
                            variable.setType(VariableType.BIGINT);
                            return variable;
                        }else{
                        table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede calcularse MOD, los valores no son de tipo number o bigint"));
                        return null;                            
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico", "",this.getLinea(), this.getColumna(), "No puede calcularse MOD, los valores no son de tipo number o bigint"));
                        return null;
                    }
                case AND:
                    if (left.getType() == right.getType()) {
                        if (left.getType() == VariableType.BOOLEAN && right.getType() == VariableType.BOOLEAN&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            //and
                            variable.setValue((Boolean) left.getValue() && (Boolean) right.getValue());
                            variable.setType(VariableType.BOOLEAN);
                            return variable;
                        } else{
                        table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede calcularse AND, los dos valores no son de tipo Boolean"));
                        return null;                            
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede calcularse AND, los dos valores no son de tipo Boolean"));
                        return null;
                    }
                case OR:
                    if (left.getType() == right.getType()) {
                        if (left.getType() == VariableType.BOOLEAN && right.getType() == VariableType.BOOLEAN&&right.getValue().toString()!="undefined"&&left.getValue().toString()!="undefined") {
                            //or,p
                            variable.setValue((Boolean) left.getValue() || (Boolean) right.getValue());
                            variable.setType(VariableType.BOOLEAN);
                            return variable;
                        } else{
                        table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede calcularse OR, los dos valores no son de tipo Boolean"));
                        return null;                            
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico","", this.getLinea(), this.getColumna(), "No puede calcularse OR, los dos valores no son de tipo Boolean"));
                        return null;
                    }
                    
                case MAYOR_QUE:
                    
                /*case MENOR_QUE:
                case MAYOR_IGUAL:
                case MENOR_IGUAL:
                case COMPARACION:
                case DISTINTO:
                */
                    
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "",this.getLinea(), this.getColumna(), "No puede realizarse la operacion, verifica que los valores esten definidos"));
            return null;
        }
        return null;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Instruction getLeftOperator() {
        return leftOperator;
    }

    public void setLeftOperator(Instruction leftOperator) {
        this.leftOperator = leftOperator;
    }

    public Instruction getRightOperator() {
        return rightOperator;
    }

    public void setRightOperator(Instruction rightOperator) {
        this.rightOperator = rightOperator;
    }

    @Override
    public String toString() {
        return "BinaryOperation{" + "type=" + type + ", leftOperator=" + leftOperator + ", rightOperator=" + rightOperator + '}';
    }

}
