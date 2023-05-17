/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_For_assig extends Instruction {

    private Instruction declaration;
    private Instruction conditional;
    private Instruction action;
    private ArrayList<Instruction> instructions;
    
    public Function_For_assig(Object linea, Object columna,Instruction declaration,Object conditional,Object action,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.declaration = declaration;
        this.conditional = (Instruction)conditional;
        this.action = (Instruction) action;
        this.instructions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("For_assigment");
        System.out.println(declaration);
        System.out.println(conditional);
        System.out.println(action);
        System.out.println(instructions);
        return null;
    }

    public Instruction getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Instruction declaration) {
        this.declaration = declaration;
    }

    public Instruction getConditional() {
        return conditional;
    }

    public void setConditional(Instruction conditional) {
        this.conditional = conditional;
    }

    public Instruction getAction() {
        return action;
    }

    public void setAction(Instruction action) {
        this.action = action;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Function_For_assig{" + "declaration=" + declaration + ", conditional=" + conditional + ", action=" + action + ", instructions=" + instructions + '}';
    }
    
}
