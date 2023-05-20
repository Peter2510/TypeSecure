/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.archivos.Dot;
import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Declaration extends Instruction {

    private AccessType access;
    private VariableType type;
    private String id;
    private Instruction operation;

    public Declaration(Object linea, Object columna, Object access, Object type, String id, Object operation) {
        super(linea, columna);
        this.access = (AccessType) access;
        this.type = (VariableType) type;
        this.id = id;
        this.operation = (Instruction) operation;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //verificar repitencias
        Boolean existe_variable = table.contains(this.id);
        
        if (existe_variable) {
            table.agrearErrores(new Error_analizadores("Semantico", this.id, this.getLinea(), this.getColumna(), "La variable ya fue declarada"));
            return null;
        } else {
            Variable operacion_valor = (Variable) operation.ejecutar(table);

            if (operacion_valor != null) {
                                
                if(operacion_valor.getType()==this.type){
                    
                    Variable new_variable = new Variable();
                    new_variable.setAccess(this.access);
                    new_variable.setId(this.id);
                    new_variable.setType(this.type);
                    new_variable.setValue(operacion_valor.getValue());
                    new_variable.setLinea(this.getLinea());
                    new_variable.setColumna(this.getColumna());
                    table.add(new_variable);  
                    return this;
                    
                }else{
                    //inferencia de tipos
                    System.out.println(this.type);
                    System.out.println(this.access);
                    System.out.println(this.id);
                    System.out.println(operacion_valor.getValue().toString());
                    System.out.println(operacion_valor.getType());
                    if(this.access == AccessType.CONST && operacion_valor.getValue().toString().equals("undefined")&&operacion_valor.getType()==VariableType.PENDIENTE){
                        table.agrearErrores(new Error_analizadores("Semantico", this.id,this.getLinea(), this.getColumna(), "La variable '"+ this.id+"' definida como const debe tener un valor definido en la declaracion"));
                        return null;
                    }
                    
                    
                    if(this.type==VariableType.PENDIENTE){
                        Variable new_variable = new Variable();
                        new_variable.setAccess(this.access);
                        new_variable.setId(this.id);
                        new_variable.setValue(operacion_valor.getValue());                        
                        new_variable.setLinea(this.getLinea());
                        new_variable.setColumna(this.getColumna());
                        
                        if(operacion_valor.getType()==VariableType.NUMBER){
                            new_variable.setType(VariableType.NUMBER);        
                            table.add(new_variable);
                            return this;
                        }else if(operacion_valor.getType()==VariableType.BIGINT){
                            new_variable.setType(VariableType.BIGINT);
                            table.add(new_variable);
                            return this;
                        }else if(operacion_valor.getType()==VariableType.BOOLEAN){
                            new_variable.setType(VariableType.BOOLEAN);
                            table.add(new_variable);
                            return this;
                        }else if(operacion_valor.getType()==VariableType.STRING){
                            new_variable.setType(VariableType.STRING);
                            table.add(new_variable);
                            return this;
                        }else if(operacion_valor.getType()==VariableType.PENDIENTE){
                            new_variable.setType(this.type);
                            table.add(new_variable);
                            return this;
                        }
                        
                    }else{
                        
                        //si es undefined el valor
                        if((this.type == VariableType.NUMBER||this.type == VariableType.BIGINT||this.type == VariableType.BOOLEAN||this.type == VariableType.STRING)&&operacion_valor.getType()==VariableType.PENDIENTE){
                                Variable new_variable = new Variable();
                                new_variable.setAccess(this.access);
                                new_variable.setId(this.id);
                                new_variable.setValue(operacion_valor.getValue());
                                new_variable.setType(this.type);
                                new_variable.setLinea(this.getLinea());
                                new_variable.setColumna(this.getColumna());
                                table.add(new_variable);                                
                                return this;
                        }else{
                            //System.out.println("El tipo de la variable y el valor ingresado no son del mismo tipo");
                            table.agrearErrores(new Error_analizadores("Semantico", this.id,this.getLinea(), this.getColumna(), "El tipo de la variable y el valor ingresado no son del mismo tipo"));                                
                        }
                        
                    }
                        
                }
                
            } else {
                //System.out.println("La operacion de la declaracion tiene un valor no permitido");
                table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La operacion de la declaracion tiene un valor no permitido"));
            }
        }
        
        return null;

    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType access) {
        this.access = access;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
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
        return "Declaration{" + "access=" + access + ", type=" + type + ", id=" + id + ", operation=" + operation + '}';
    }

    @Override
    public String convertGraphviz(Dot dot) {
        return "";
    }
    
}
