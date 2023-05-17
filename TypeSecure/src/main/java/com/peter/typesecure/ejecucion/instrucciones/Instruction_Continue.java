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
public class Instruction_Continue extends Instruction{

    public Instruction_Continue(Object linea, Object columna) {
        super(linea, columna);
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        return this;
    }

    @Override
    public String toString() {
        return "Instruction_Continue{" + '}';
    }
    
}
