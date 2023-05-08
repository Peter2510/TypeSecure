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
public class Function_Boolean extends Instruction {

    private Instruction operator;
    
    public Function_Boolean(Object linea, Object columna, Object operator) {
        super(linea, columna);
        this.operator = (Instruction) operator;
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

    @Override
    public String toString() {
        return "Function_Boolean{" + "operator=" + operator + '}';
    }
        
}
