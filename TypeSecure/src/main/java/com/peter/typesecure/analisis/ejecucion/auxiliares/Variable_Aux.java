/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.analisis.ejecucion.auxiliares;


import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.VariableType;

/**
 *
 * @author GORDILLOG
 */
public class Variable_Aux {
    private String id;
    private VariableType type;
    private Instruction value;

    public Variable_Aux(Object id, Object type, Object value) {
        this.id = (String)id;
        this.type = (VariableType) type;
        this.value = (Instruction)value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Instruction value) {
        this.value = value;
    }
    
    
    
    
}
