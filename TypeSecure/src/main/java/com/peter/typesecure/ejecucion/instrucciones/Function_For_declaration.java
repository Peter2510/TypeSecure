/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_For_declaration extends Instruction{

    private ArrayList<Instruction> declarations;
    private Instruction conditional;
    private Instruction action;
    private ArrayList<Instruction> instructions;
    
    public Function_For_declaration(Object linea, Object columna,ArrayList<Instruction> declaration,Object conditional,Object action,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.declarations = declaration;
        this.conditional = (Instruction)conditional;
        this.action = (Instruction) action;
        this.instructions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //verificar que la variable declarada se let
        SymbolTable child = new SymbolTable(table);
        for (int i = 0; i < declarations.size(); i++) {
            declarations.get(i).ejecutar(child);
        }
        
        Variable condi = (Variable)conditional.ejecutar(child);
        
        
        
        
        return null;
    }

    public ArrayList<Instruction> getDeclaration() {
        return declarations;
    }

    public void setDeclaration(ArrayList<Instruction> declaration) {
        this.declarations = declaration;
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
        return "Function_For{" + "declaration=" + declarations + ", conditional=" + conditional + ", action=" + action + ", instructions=" + instructions + '}';
    }
    
}
