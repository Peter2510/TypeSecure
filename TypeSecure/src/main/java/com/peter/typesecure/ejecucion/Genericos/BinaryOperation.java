/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

/**
 *
 * @author GORDILLOG
 */
public class BinaryOperation extends Instruction{

   OperationType type;
   Instruction leftOperator;
   Instruction rightOperator;
    
    public BinaryOperation(Object linea, Object columna,Object type, Object leftOperator, Object rigthOperator) {
        super(linea, columna);
        this.type = (OperationType) type;
        this.leftOperator =  (Instruction)leftOperator;
        this.rightOperator = (Instruction)rigthOperator;
        
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        return null;
    }

    @Override
    public String toString() {
        return "BinaryOperation{" + "type=" + type + ", leftOperator=" + leftOperator + ", rightOperator=" + rightOperator + '}';
    }
    
    
    
}
