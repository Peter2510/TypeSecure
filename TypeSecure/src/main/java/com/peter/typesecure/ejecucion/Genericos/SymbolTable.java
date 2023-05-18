/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.analisis.ejecucion.auxiliares.Function;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author GORDILLOG
 */
public class SymbolTable extends ArrayList<Variable> {

    private ArrayList<Error_analizadores> errores = new ArrayList();
    Map<String, Function> funciones = new LinkedHashMap<>();
    
    public SymbolTable(){
        super();
    }

    public SymbolTable(SymbolTable padre) {
        super();
        if (padre != null) {
            for (int i = 0; i < padre.size(); i++) {
                this.add(padre.get(i));
            }
            this.setFunciones(padre.getFunciones());
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
    
    public void setErrores(ArrayList<Error_analizadores> err){
        this.errores = err;
    }

    public Map<String, Function> getFunciones() {
        return funciones;
    }

    public void setFunciones(Map<String, Function> funciones) {
        this.funciones = funciones;
    }

    public void agregarFuncion(String name, Function funcion){
        funciones.put(name, funcion);
    }
    
    public boolean existeFuncion(String name){
        return funciones.containsKey(name);
    }
    
    public int cantidadParametros(String name){
        return funciones.get(name).getSizeParameters();
    }
    
    public VariableType tipoFuncion(String name){
        return funciones.get(name).getType();
    }
    
    public Function getFuncion(String name){
        return funciones.get(name);
    }
    
}
