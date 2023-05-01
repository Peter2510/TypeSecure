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
    
    public Value(int linea,int columna,Object value, ValueType type){
        super(linea,columna);
        this.value = value;
        this.type = type;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        return null;
    }

    @Override
    public void ejecutar_1(SymbolTable st) {
        //nada
    }
    
}
