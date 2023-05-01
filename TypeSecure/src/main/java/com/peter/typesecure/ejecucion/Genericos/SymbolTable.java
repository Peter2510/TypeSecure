/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class SymbolTable extends ArrayList<Variable> {
    
    private ArrayList<Error_analizadores> errores = new ArrayList();
    
    public SymbolTable(SymbolTable padre){
        super();
        if(padre!=null){
            this.addAll(padre);
        }
    }
    
    public void _add(Variable variable){
        this.add(variable);
    }
    
    public Object getById(String id) {
    return this.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean contains(String id) {
    return this.stream().anyMatch(v -> v.getId().equals(id));
    }

    public void agrearErrores(Error_analizadores error){
        this.errores.add(error);
    }
    
    public ArrayList<Error_analizadores> getErrores(){
        return this.errores;
    }
}
