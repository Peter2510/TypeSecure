/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

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


    
}
