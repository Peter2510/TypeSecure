/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;

/**
 *
 * @author GORDILLOG
 */
public class Function_Return_Instruction extends Instruction{

    private Instruction instruction;
    
    public Function_Return_Instruction(Object linea, Object columna,Object instruction) {
        super(linea, columna);
        this.instruction = (Instruction)instruction;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Function_Return_Instruction");
        System.out.println(instruction);
        return null;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "Function_Return_Instruction{" + "instruction=" + instruction + '}';
    }
    
}
