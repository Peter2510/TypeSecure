/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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