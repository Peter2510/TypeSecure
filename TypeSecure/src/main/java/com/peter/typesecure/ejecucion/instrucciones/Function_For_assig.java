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
public class Function_For_assig extends Instruction {

    private Instruction declaration;
    private Instruction conditional;
    private ArrayList<Instruction> action;
    private ArrayList<Instruction> instructions;

    public Function_For_assig(Object linea, Object columna, Instruction declaration, Object conditional, ArrayList<Instruction> action, ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.declaration = declaration;
        this.conditional = (Instruction) conditional;
        this.action = action;
        this.instructions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //verificar que la variable declarada se let

        if (declaration != null) {

            if (conditional != null) {

                if (action != null) {

                    SymbolTable contextAsignacion = new SymbolTable(table);

                    declaration.ejecutar(contextAsignacion);

                    Variable condi = (Variable) conditional.ejecutar(contextAsignacion);

                    if (condi != null && !"undefined".equals(condi.getValue().toString()) && condi.getType() == VariableType.BOOLEAN) {

                        while ((Boolean) condi.getValue()) {
                            SymbolTable contextFor = new SymbolTable(contextAsignacion);
                            for (int i = 0; i < instructions.size(); i++) {
                                Object vr = instructions.get(i).ejecutar(contextFor);
                         
                                if(vr instanceof Function_Return_Simple || vr instanceof Function_Return_Instruction || vr instanceof Instruction_Break || vr instanceof Instruction_Continue){
                                
                                
                                    if(vr instanceof Instruction_Break){
                                        break;
                                    }
                                    
                                    if(vr instanceof Instruction_Continue){
                                        break;
                                    }
                                    
                                    if(vr instanceof Function_Return_Instruction){
                                        return ((Function_Return_Instruction) vr).getInstruction();
                                    }
                                    
                                    if(vr instanceof Function_Return_Simple){
                                        table.agrearErrores(new Error_analizadores("Semantico", "", ((Function_Return_Simple) vr).getLinea(), ((Function_Return_Simple) vr).getColumna(), "La instruccion return debe retornar un valor o una instruccion"));
                                        return null;
                                    }
                                    
                                }
                            }

                            for (int i = 0; i < action.size(); i++) {
                                action.get(i).ejecutar(contextAsignacion);

                            }

                            condi = (Variable) conditional.ejecutar(contextAsignacion);
                            contextAsignacion.setErrores(contextFor.getErrores());
                        }

                        for (int j = 0; j < contextAsignacion.getErrores().size(); j++) {
                            table.agrearErrores(contextAsignacion.getErrores().get(j));
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "La condicion de la instruccion for debe estar definida y ser de tipo boolean"));
                        return null;
                    }

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No se hallaron acciones a relizar en la instruccion for"));
                    return null;
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No se hallo una condicion a evaluar en la instruccion for"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No se hallaron declaraciones a relizar en la instruccion for"));
            return null;
        }

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

    public ArrayList<Instruction> getAction() {
        return action;
    }

    public void setAction(ArrayList<Instruction> action) {
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
    
    @Override
    public String convertGraphviz(Dot dot) {
        return "";
    }

}
