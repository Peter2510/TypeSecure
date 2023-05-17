/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_Do_While extends Instruction {

    private ArrayList<Instruction> instructions;
    private Instruction conditional;

    public Function_Do_While(Object linea, Object columna, ArrayList<Instruction> instructions, Object conditional) {
        super(linea, columna);
        this.instructions = instructions;
        this.conditional = (Instruction) conditional;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Do_While");

        Variable condition = (Variable) conditional.ejecutar(table);
        if (condition != null) {

            if (condition.getValue() != null && !"undefined".equals(condition.getValue().toString())) {

                if (condition.getType() == VariableType.BOOLEAN) {
                    SymbolTable child = new SymbolTable(table);

                    do {
                        for (int i = 0; i < instructions.size(); i++) {
                            Object vr = instructions.get(i).ejecutar(child);
                            condition = (Variable) conditional.ejecutar(child);

                        }

                    } while ((Boolean) condition.getValue());

                    for (int j = 0; j < child.getErrores().size(); j++) {
                        table.agrearErrores(child.getErrores().get(j));
                    }

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La condicion de do while debe ser de tipo boolean"));
                    return null;
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La condicion de do while no contiene valor"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La condicion de do while no esta definida"));
            return null;
        }

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
