/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Condicionales;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class If extends Instruction {

    private Instruction conditional;
    private ArrayList<Instruction> instructions;
    
    public If(int linea, int columna,Object conditional, ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.conditional = (Instruction)conditional;
        this.instructions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Parte if");
        System.out.println(conditional);
        System.out.println(instructions);
        return null;
    }

    public Instruction getConditional() {
        return conditional;
    }

    public void setConditional(Instruction conditional) {
        this.conditional = conditional;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "If{" + "conditional=" + conditional + ", instructions=" + instructions + '}';
    }
    
}
