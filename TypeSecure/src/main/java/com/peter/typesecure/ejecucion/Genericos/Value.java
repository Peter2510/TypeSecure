/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.archivos.Dot;
import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Value extends Instruction {

    private Object value;
    private ValueType type;
    
    public Value(Object linea,Object columna,Object value, Object type){
        super(linea,columna);
        this.value = value;
        this.type = (ValueType)type;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable variable = new Variable();
        
        switch (this.type) {
            case NUMBER:
                variable.setType(VariableType.NUMBER);
                variable.setValue(Double.parseDouble((String) value));
                return variable;
            case BIGINT:
                variable.setType(VariableType.BIGINT);
                variable.setValue((String)value);
                return variable;
            case TEXTO:
                variable.setType(VariableType.STRING);
                variable.setValue((String)value);
                return variable;               
            case TRUE:
                variable.setType(VariableType.BOOLEAN);
                variable.setValue(Boolean.parseBoolean((String)value));
                return variable;
            case FALSE:
                variable.setType(VariableType.BOOLEAN);
                variable.setValue(Boolean.parseBoolean((String)value));
                return variable;
            case UNDEFINED:
                variable.setType(VariableType.PENDIENTE);
                variable.setValue((String)value);
                return variable;
            case ID:
                Variable tmp = table.getById((String)value);
                
                if(tmp!=null){
                    Variable var = tmp;
                    variable.setId(var.getId());
                    variable.setType(var.getType());
                    variable.setValue(var.getValue());
                    return variable;
                }else{
                    //System.out.println("La variable " + this.value + " no esta definida");
                     table.agrearErrores(new Error_analizadores("Semantico", (String)value, this.getLinea(), this.getColumna(), "La variable no esta definida"));
                     return null;
                }
        }
        
        return null;
        
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ValueType getType() {
        return type;
    }

    public void setType(ValueType type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "Value{" + "value=" + value + ", type=" + type + '}';
    }

    @Override
    public String convertGraphviz(Dot dot) {
        String data = dot.getDatos();
        //data = "node"+dot.getContador()+"[label=\"asignacion\"]";
        int contador = dot.getContador();

        switch (type) {
            case NUMBER:
                data += "node"+dot.getContador()+"[label=\"number\"]" +"\n";
                dot.sumarContador();
                data += "node"+dot.getContador()+"[label=\""+getValue()+"\"]"+ "\n";
                data += "node"+(contador) + "->" + "node" + (contador+1) +"\n";
                dot.setDatos(data);
            return data;
            case BIGINT:
                data += "node"+dot.getContador()+"[label=\"bigint\"]"+"\n";
                dot.sumarContador();
                data += "node"+dot.getContador()+"[label=\""+getValue()+"\"]"+"\n";
                dot.sumarContador();
                data += "node"+(contador) + "->" + "node" + (contador+1)+"\n";
                dot.setDatos(data);
            return data;
            case FALSE:
                data += "node"+dot.getContador()+"[label=\"boolean\"]"+"\n";
                dot.sumarContador();
                data += "node"+dot.getContador()+"[label=\""+getValue()+"\"]"+"\n";
                dot.sumarContador();
                data += "node"+(contador) + "->" + "node" + (contador+1)+"\n";
                dot.setDatos(data);

            return data;
            case TRUE:
                data += "node"+dot.getContador()+"[label=\"boolean\"]"+"\n";
                dot.sumarContador();
                data += "node"+dot.getContador()+"[label=\""+getValue()+"\"]"+"\n";
                dot.sumarContador();
                data += "node"+(contador) + "->" + "node" + (contador+1)+"\n";
                dot.setDatos(data);

            return data;
            case ID:
                data = "node"+dot.getContador()+"[label=\"id\"]"+"\n";
                dot.sumarContador();
                data += "node"+dot.getContador()+"[label=\""+getValue()+"\"]"+"\n";
                dot.sumarContador();
                data += "node"+(contador) + "->" + "node" + (contador+1)+"\n";
                dot.setDatos(data);

            return data;
            case TEXTO:
                data += "node"+dot.getContador()+"[label=\"string\"]"+"\n";
                dot.sumarContador();
                data += "node"+dot.getContador()+"[label=\""+getValue()+"\"]"+"\n";
                dot.sumarContador();
                data += "node"+(contador) + "->" + "node" + (contador+1)+"\n";
                dot.setDatos(data);

            return data;
            case UNDEFINED:
                data += "node"+dot.getContador()+"[label=\"undefined\"]"+"\n";
                dot.sumarContador();
                data += "node"+dot.getContador()+"[label=\""+"undefined"+"\"]"+"\n";
                dot.sumarContador();
                data += "node"+(contador) + "->" + "node" + (contador+1);
                dot.setDatos(data);
            return data;
        }

        return dot.getDatos();
        
    }

}
