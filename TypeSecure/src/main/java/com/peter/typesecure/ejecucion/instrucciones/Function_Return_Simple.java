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
public class Function_Return_Simple extends Instruction {

    public Function_Return_Simple(Object linea, Object columna) {
        super(linea, columna);
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Function_Return_Simple");
        return null;
    }
    
}
