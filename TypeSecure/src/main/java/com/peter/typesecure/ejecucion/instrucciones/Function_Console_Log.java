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
public class Function_Console_Log extends Instruction{

    private ArrayList<Instruction> instruccions;
    int contadorError = 0;
    
    
    public Function_Console_Log(int linea, int columna,ArrayList<Instruction> instruccion) {
        super(linea, columna);
        this.instruccions = instruccion;
    }

    
    public void ejecutar_1(SymbolTable table) {
    /*    String tmp = "";
        for(int i = 0; i< instruccions.size() ;i++){
            
            Variable v = (Variable) instruccions.get(i).ejecutar(table);
            
            if(v.getValue()!=null){
                tmp+= v.getValue() + " ";
                
            }else{
                //contadorError++;
                //table.agrearErrores(new Error_analizadores( "Semantico",instruccions.get(i).getLinea(),instruccion.get(i).getColumna(),"La variable " + v.getId() +" no tiene un valor asignado"));
                
            }
            
        }
        
        if(contadorError==0){
            System.out.println(tmp);
        }*/
    
    }

    @Override
    public Object ejecutar(SymbolTable table) {
    /*    String tmp = "";
        for(int i = 0; i< instruccions.size() ;i++){
            
            Variable v = (Variable) instruccions.get(i).ejecutar(table);
            
            if(v.getValue()!=null){
                tmp+= v.getValue() + " ";
                
            }else{
                //contadorError++;
                //table.agrearErrores(new Error_analizadores( "Semantico",instruccions.get(i).getLinea(),instruccion.get(i).getColumna(),"La variable " + v.getId() +" no tiene un valor asignado"));
                
            }
            
        }
        
        if(contadorError==0){
            System.out.println(tmp);
        }*/
        System.out.println("console.log");
        System.out.println(instruccions);
        return null;
    }

    @Override
    public String toString() {
        return "Function_Console_Log{" + "instruccions=" + instruccions + ", contadorError=" + contadorError + '}';
    }
    
}
