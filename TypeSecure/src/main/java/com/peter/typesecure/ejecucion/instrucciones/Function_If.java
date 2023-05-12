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
public class Function_If extends Instruction{

    
    private Instruction _if;
    private ArrayList<Instruction> else_if;
    private Instruction _else;
        
    public Function_If(Object linea, Object columna,Object _if, ArrayList<Instruction> else_if,Object _else) {
        super(linea, columna);
        this._if = (Instruction)_if;
        this.else_if = else_if;
        this._else = (Instruction) _else;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Function_if");
        System.out.println(_if);
        System.out.println(else_if);
        System.out.println(_else);
        return null;
    }

    public Instruction getIf() {
        return _if;
    }

    public void setIf(Instruction _if) {
        this._if = _if;
    }

    public Instruction getElse() {
        return _else;
    }

    public void setElse(Instruction _else) {
        this._else = _else;
    }

    public ArrayList<Instruction> getElse_if() {
        return else_if;
    }

    public void setElse_if(ArrayList<Instruction> else_if) {
        this.else_if = else_if;
    }

    @Override
    public String toString() {
        return "Function_If{" + "_if=" + _if + ", _else=" + _else + ", else_if=" + else_if + '}';
    }
    
}
