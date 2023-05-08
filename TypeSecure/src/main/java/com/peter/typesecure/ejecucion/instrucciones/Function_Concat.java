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
public class Function_Concat extends Instruction{

    private Instruction firstOperator;
    private Instruction secondOperator;
    
    public Function_Concat(Object linea, Object columna,Object first, Object second) {
        super(linea, columna);
        this.firstOperator = (Instruction) first;
        this.secondOperator = (Instruction) second;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Instruction getFirstOperator() {
        return firstOperator;
    }

    public void setFirstOperator(Instruction firstOperator) {
        this.firstOperator = firstOperator;
    }

    public Instruction getSecondOperator() {
        return secondOperator;
    }

    public void setSecondOperator(Instruction secondOperator) {
        this.secondOperator = secondOperator;
    }

    @Override
    public String toString() {
        return "Function_Concat{" + "firstOperator=" + firstOperator + ", secondOperator=" + secondOperator + '}';
    }
    
}
