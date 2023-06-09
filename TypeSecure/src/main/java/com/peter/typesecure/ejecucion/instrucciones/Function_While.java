/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.archivos.Dot;
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
public class Function_While extends Instruction {

    private Instruction conditional;
    private ArrayList<Instruction> instructions;

    public Function_While(Object linea, Object columna, Object conditional, ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.conditional = (Instruction) conditional;
        this.instructions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        Variable condition = (Variable) conditional.ejecutar(table);

        if (condition != null) {

            if (condition.getValue() != null && "undefined" != condition.getValue()) {

                if (condition.getType() == VariableType.BOOLEAN) {

                    while ((Boolean) condition.getValue()) {
                        SymbolTable child = new SymbolTable(table);
                        for (int i = 0; i < instructions.size(); i++) {
                            Object vr = instructions.get(i).ejecutar(child);
                            if (vr instanceof Function_Return_Simple || vr instanceof Function_Return_Instruction || vr instanceof Instruction_Break || vr instanceof Instruction_Continue) {

                                if (vr instanceof Instruction_Break) {
                                    break;
                                }

                                if (vr instanceof Instruction_Continue) {
                                    break;
                                }

                                if (vr instanceof Function_Return_Instruction) {
                                    return ((Function_Return_Instruction) vr).getInstruction();
                                }

                                if (vr instanceof Function_Return_Simple) {
                                    table.agrearErrores(new Error_analizadores("Semantico", "", ((Function_Return_Simple) vr).getLinea(), ((Function_Return_Simple) vr).getColumna(), "La instruccion return debe retornar un valor o una instruccion"));
                                    return null;
                                }

                            }
                        }
                        condition = (Variable) conditional.ejecutar(child);

                        for (int i = 0; i < child.getErrores().size(); i++) {
                            table.agrearErrores(child.getErrores().get(i));
                        }

                    }

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La condicion de la instruccion while debe ser de tipo boolean"));
                    return null;
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La condicion de la instruccion while no tiene valor ser nula"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La condicion de la instruccion while no puede ser nula"));
            return null;
        }

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
        return "While{" + "conditional=" + conditional + ", instructions=" + instructions + '}';
    }

    @Override
    public String convertGraphviz(Dot dot) {
        return "";
    }
}
