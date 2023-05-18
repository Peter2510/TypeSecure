/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Function_Call_Simple_Function extends Instruction {

    private String id;
    private Boolean simple;

    public Function_Call_Simple_Function(Object linea, Object columna, Object id) {
        super(linea, columna);
        this.id = (String) id;
        this.simple = true;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        if (table.existeFuncion(id)) {

            if (table.getFuncion(id).hasParameters() == false) {

                SymbolTable child = new SymbolTable(table);

                for (int i = 0; i < table.getFuncion(id).getInstructions().size(); i++) {
                    Object vr = table.getFuncion(id).getInstructions().get(i).ejecutar(child);
                }

                for (int i = 0; i < child.getErrores().size(); i++) {
                    table.agrearErrores(child.getErrores().get(i));
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' necesita parametros para poder ejecutarse "));
                return null;
            }

            return this;

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' no ha sido definida "));
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    @Override
    public String toString() {
        return "Function_Call_Simple_Function{" + "id=" + id + ", simple=" + simple + '}';
    }

}
