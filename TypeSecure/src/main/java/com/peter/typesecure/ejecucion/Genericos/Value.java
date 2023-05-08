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

    @Override
    public String toString() {
        return "Value{" + "value=" + value + ", type=" + type + '}';
    }


    
}
