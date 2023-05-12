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
public class Function_Do_While extends Instruction{

    private ArrayList<Instruction> instructions;
    private Instruction conditional;
    
    public Function_Do_While(Object linea, Object columna,ArrayList<Instruction> instructions, Object conditional ) {
        super(linea, columna);
        this.instructions = instructions;
        this.conditional = (Instruction)conditional;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Do_While");
        System.out.println(instructions);
        System.out.println(conditional);
        return null;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Instruction getConditional() {
        return conditional;
    }

    public void setConditional(Instruction conditional) {
        this.conditional = conditional;
    }

    @Override
    public String toString() {
        return "Function_Do_While{" + "instructions=" + instructions + ", conditional=" + conditional + '}';
    }
    
}
