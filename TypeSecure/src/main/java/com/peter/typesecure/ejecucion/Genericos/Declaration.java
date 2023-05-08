/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

/**
 *
 * @author GORDILLOG
 */
public class Declaration extends Instruction {

    AccessType access;
    VariableType type;
    String id;
    Instruction operation;
    
    
    public Declaration(Object linea, Object columna,Object access,Object type,String id, Object operation) {
        super(linea, columna);
        this.access= (AccessType)access;
        this.type = (VariableType)type;
        this.id = id;
        this.operation = (Instruction) operation;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println(access);
        System.out.println(type);
        System.out.println(id);
        System.out.println(operation);
        return null;
    }

    @Override
    public String toString() {
        return "Declaration{" + "access=" + access + ", type=" + type + ", id=" + id + ", operation=" + operation + '}';
    }
    
}
