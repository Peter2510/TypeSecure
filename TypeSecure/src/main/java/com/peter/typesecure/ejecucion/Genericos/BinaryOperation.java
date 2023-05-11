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

   private OperationType type;
   private Instruction leftOperator;
   private Instruction rightOperator;
    
    public BinaryOperation(Object linea, Object columna,Object type, Object leftOperator, Object rigthOperator) {
        super(linea, columna);
        this.type = (OperationType) type;
        this.leftOperator =  (Instruction)leftOperator;
        this.rightOperator = (Instruction)rigthOperator;
        
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable left = (Variable) leftOperator.ejecutar(table);
        Variable right = (Variable) rightOperator.ejecutar(table);
        
        Variable variable = new Variable();
        
        if(left != null &&right != null){
            
            switch (type) {
                case SUMA:
                    variable.setValue((Double)left.getValue() + (Double)right.getValue());
                    variable.setType(VariableType.NUMBER);
                    return variable;
                    //verificar que los valores a sumar sean del mismo tipo
                    //si uno de ellos es string, se realiza la concatenacion
                
            }
            
        }else{
            //hay error en las operaciones binarias
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
