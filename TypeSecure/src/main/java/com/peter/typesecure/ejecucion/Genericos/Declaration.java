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

    private AccessType access;
    private VariableType type;
    private String id;
    private Instruction operation;
    
    
    public Declaration(Object linea, Object columna,Object access,Object type,String id, Object operation) {
        super(linea, columna);
        this.access= (AccessType)access;
        this.type = (VariableType)type;
        this.id = id;
        this.operation = (Instruction) operation;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //verificar repitencias
        Variable a = (Variable) operation.ejecutar(table);
        Variable ab = new Variable();
        ab.setId(this.id);
        ab.setType(type);
        ab.setValue(a.getValue());
        table.add(ab);
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
    
}
