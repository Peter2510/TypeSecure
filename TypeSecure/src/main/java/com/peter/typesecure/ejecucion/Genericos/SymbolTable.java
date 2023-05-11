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

    public SymbolTable() {

    }

    public SymbolTable(SymbolTable padre) {
        super();
        if (padre != null) {
            this.addAll(padre);
        }
    }

    public void _add(Variable variable) {
        this.add(variable);
    }

    public Object getById(String id) {
        System.out.println(this);
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(id)) {
                System.out.println("existe el id " + this.get(i) );
                return this.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    public boolean contains(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void agrearErrores(Error_analizadores error) {
        this.errores.add(error);
    }

    public ArrayList<Error_analizadores> getErrores() {
        return this.errores;
    }
}
