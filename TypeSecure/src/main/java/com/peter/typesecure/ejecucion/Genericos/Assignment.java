/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Assignment extends Instruction{

    private String id;
    private Instruction operation;
        
    public Assignment(Object linea, Object columna,Object id,Object operation) {
        super(linea, columna);
        this.id = (String)id;
        this.operation = (Instruction) operation;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable variable = table.getById(this.id);
        
        if(variable!=null){
            
            Variable var_tmp = (Variable) this.operation.ejecutar(table);
            
            if(var_tmp!=null){
                
                if(variable.getType() == var_tmp.getType()&&variable.getAccess()==AccessType.LET){
                    variable.setValue(var_tmp.getValue());
                }else{
                table.agrearErrores(new Error_analizadores("Semantico",this.id,this.getLinea(), this.getColumna(), "La variable '"+ this.id +"' no puede cambiar de valor al ser CONST "));        
                return null;
                }
                
            }else{
                table.agrearErrores(new Error_analizadores("Semantico",this.id ,this.getLinea(), this.getColumna(), "La variable a asignar "+ this.id +" no esta definida "));    
                return null;
            }
            
            
        }else{
            table.agrearErrores(new Error_analizadores("Semantico",this.id ,this.getLinea(), this.getColumna(), "La variable no ha sido declarada"));
            return null;
        }
        
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instruction getOperation() {
        return operation;
    }

    public void setOperation(Instruction operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Assignment{" + "id=" + id + ", operation=" + operation + '}';
    }
    
}
