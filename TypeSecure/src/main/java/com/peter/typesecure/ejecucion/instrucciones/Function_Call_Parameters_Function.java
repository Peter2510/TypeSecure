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
public class Function_Call_Parameters_Function extends Instruction{

    private String id;
    private ArrayList<Instruction> instruccions;
    private Boolean simple;
    
    public Function_Call_Parameters_Function(Object linea, Object columna,Object id,ArrayList<Instruction> instruccion) {
        super(linea, columna);
        this.id = (String)id;
        this.instruccions = instruccion;
        this.simple = false;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        System.out.println("Function_Call_Parameters_Function");
        System.out.println("id");
        System.out.println(instruccions);
        return null;
    }
    
}
