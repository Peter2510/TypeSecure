/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

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
        System.out.println("Asignacion");
        System.out.println(id);
        System.out.println(operation);
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
