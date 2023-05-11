/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones.functions;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_Void_Simple extends Instruction{

    private VariableType type;
    private String name;
    private ArrayList<Instruction> instruccions;
    private Boolean simple;
        
    public Function_Void_Simple(Object linea, Object columna,Object name,VariableType type, ArrayList<Instruction> instructions ) {
        super(linea, columna);
        this.name = (String)name;
        this.type = type;
        this.instruccions = instructions;
        this.simple = true;
       
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //verificar que los nombres de las varialbles no se repitan
        //verificar que el metodo no haya sido ya definido en el documento
        //verificar que la funcion pueda tener el mismo nombre pero distintos parametros
        System.out.println("Function_void_simple");
        System.out.println(name);
        System.out.println(type);
        System.out.println(instruccions);
        return null;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Instruction> getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.instruccions = instruccions;
    }

    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    @Override
    public String toString() {
        return "Function_Void_Simple{" + "type=" + type + ", name=" + name + ", instruccions=" + instruccions + '}';
    }
    
}
