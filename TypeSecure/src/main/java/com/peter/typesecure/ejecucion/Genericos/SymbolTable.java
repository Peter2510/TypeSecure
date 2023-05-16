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
    
    public SymbolTable(){
        super();
    }

    public SymbolTable(SymbolTable padre) {
        super();
        if (padre != null) {
            for (int i = 0; i < padre.size(); i++) {
                this.add(padre.get(i));
            }
        }
    }

    public void _add(Variable variable) {
        this.add(variable);
    }

    public Variable getById(String id) {
        boolean encotro_variable=false;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(id)) {
          //      System.out.println("existe el id " + this.get(i) );
                encotro_variable = true;
                return this.get(i);
            }
        }
        if(encotro_variable==false){
            return null;
        }
        return null;
    }

    public boolean contains(String id) {
        boolean encontro_variable = false;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(id)) {
                encontro_variable = true;
                return true;
            }
        }
        
        if(encontro_variable==false){
            return false;
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
