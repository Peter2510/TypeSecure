/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.Genericos;

import com.peter.typesecure.archivos.Dot;
import com.peter.typesecure.error.Error_analizadores;

/**
 *
 * @author GORDILLOG
 */
public class Assignment extends Instruction {

    private String id;
    private Instruction operation;

    public Assignment(Object linea, Object columna, Object id, Object operation) {
        super(linea, columna);
        this.id = (String) id;
        this.operation = (Instruction) operation;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        Variable variable = table.getById(this.id);

        if (variable != null) {

            Variable var_tmp = (Variable) this.operation.ejecutar(table);

            if (var_tmp != null) {

                if (variable.getType() == VariableType.PENDIENTE && variable.getAccess() == AccessType.LET) {
                    variable.setValue(var_tmp.getValue());
                    variable.setType(var_tmp.getType());
                    return this;
                }

                if (variable.getType() == var_tmp.getType() && variable.getAccess() == AccessType.LET) {
                    variable.setValue(var_tmp.getValue());
                    return this;
                } else {

                    if(variable.getType() != var_tmp.getType()){
                        table.agrearErrores(new Error_analizadores("Semantico", this.id, this.getLinea(), this.getColumna(), "La variable '" + this.id + "' y el valor a asignar no tiene el mismo tipo "));
                        return null;                        
                    }else if(variable.getType() == var_tmp.getType() && variable.getAccess() == AccessType.CONST){
                        table.agrearErrores(new Error_analizadores("Semantico", this.id, this.getLinea(), this.getColumna(), "La variable '" + this.id + "' no puede cambiar de valor al ser CONST "));
                        return null;    
                    }
                    
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", this.id, this.getLinea(), this.getColumna(), "La variable a asignar " + this.id + " no esta definida "));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", this.id, this.getLinea(), this.getColumna(), "La variable no ha sido declarada"));
            return null;
        }

        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instruction getOperation() {
        return operation;
    }

    public void setOperation(Instruction operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Assignment{" + "id=" + id + ", operation=" + operation + '}';
    }

    @Override
    public String convertGraphviz(Dot dot) {
        String data = dot.getDatos();
        int contador = dot.getContador();
        data += "node" + dot.getContador() + "[label=\"Asignacion\"]\n";

        dot.agregarEncabezado("node" + dot.getContador());
        int nodoEncabezado = dot.getContador();
        dot.sumarContador();

        data += "node" + dot.getContador() + "[label=\"Id\"]\n";
        int nodoId = dot.getContador();
        dot.sumarContador();

        data += "node" + dot.getContador() + "[label=\"" + this.getId() + "\"]\n";
        int nodoNombre = dot.getContador();
        dot.sumarContador();

        data += "node" + dot.getContador() + "[label=\"=\"]\n";
        int nodoIgual = dot.getContador();
        dot.sumarContador();

        int nodoActual = dot.getContador();
        
        data += this.getOperation().convertGraphviz(dot);


        data += "node" + (nodoEncabezado) + "->" + "node" + nodoId + "\n";
        data += "node" + (nodoId) + "->" + "node" + nodoNombre + "\n";

        data += "node" + (nodoEncabezado) + "->" + "node" + nodoIgual + "\n";

        data += "node" + (nodoEncabezado) + "->" + "node" + nodoActual + "\n";



        
        return data;
    }

}
