/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.archivos.Dot;
import com.peter.typesecure.archivos.ManejoArchivos;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;

/**
 *
 * @author GORDILLOG
 */
public class Function_Get_Symbol_Table extends Instruction{

    public Function_Get_Symbol_Table(Object linea, Object columna) {
        super(linea, columna);
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        
        ManejoArchivos mn = new ManejoArchivos();
        mn.crearSymbolTable(table);
        
        
        return this;
        
    }

    @Override
    public String toString() {
        return "Function_Get_Symbol_Table{" + '}';
    }

        @Override
    public String convertGraphviz(Dot dot) {
        return "";
    }
}
