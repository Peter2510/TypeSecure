/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.logica;

import com.peter.typesecure.arbol.Nodo;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Logica {

    public void  hola(ArrayList<Instruction> aa) {
        for (int i = 0; i < aa.size(); i++) {
            SymbolTable a = new SymbolTable();
            aa.get(i).ejecutar(a);
        }
    }
    
    
    
}
