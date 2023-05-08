/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class ConsoleLog extends Instruction{

    ArrayList<Instruction> instruccion = new ArrayList();
    int contadorError = 0;
    
    
    public ConsoleLog(int linea, int columna,ArrayList<Instruction> instruccion) {
        super(linea, columna);
        this.instruccion = instruccion;
    }

    
    public void ejecutar_1(SymbolTable table) {
        String tmp = "";
        for(int i = 0; i< instruccion.size() ;i++){
            
            Variable v = (Variable) instruccion.get(i).ejecutar(table);
            
            if(v.getValue()!=null){
                tmp+= v.getValue() + " ";
                
            }else{
                contadorError++;
                table.agrearErrores(new Error_analizadores( "Semantico",instruccion.get(i).getLinea(),instruccion.get(i).getColumna(),"La variable " + v.getId() +" no tiene un valor asignado"));
                
            }
            
        }
        
        if(contadorError==0){
            System.out.println(tmp);
        }
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        return null;
    }
    
}
