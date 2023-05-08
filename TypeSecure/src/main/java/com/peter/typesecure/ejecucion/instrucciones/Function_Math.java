/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.MathType;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;

/**
 *
 * @author GORDILLOG
 */
public class Function_Math extends Instruction {

    private MathType type;
    private Instruction operation;
    private Instruction operation1;
    
    public Function_Math(Object linea, Object columna,MathType type, Object operation) {
        super(linea, columna);
        this.type = type;
        this.operation = (Instruction) operation;
    }
    
    public Function_Math(Object linea, Object columna,MathType type, Object operation,Object operation1) {
       super(linea, columna);
       this.type = type;
       this.operation = (Instruction) operation;
       this.operation1 = (Instruction) operation1;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            
}
