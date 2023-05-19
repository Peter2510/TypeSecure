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
public class Else extends Instruction {

    private ArrayList<Instruction> instructions;
    
    public Else(Object linea, Object columna,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.instructions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        for (int i = 0; i < instructions.size(); i++) {
            Object vr = instructions.get(i).ejecutar(table);
            return vr;
        }
        return this;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Else{" + "instructions=" + instructions + '}';
    }
   
}
