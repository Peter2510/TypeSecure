/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
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

                int countReturn = 0;
                for (int i = 0; i < child.getFuncion(id).getInstructions().size(); i++) {
                    Object vr = child.getFuncion(id).getInstructions().get(i).ejecutar(child);
                    System.out.println(vr);
                    if (vr != null) {
                        if (vr instanceof Function_Return_Instruction || vr instanceof Function_Return_Simple || vr instanceof Instruction_Break || vr instanceof Instruction_Continue) {
                            if (vr instanceof Function_Return_Instruction) {
                                //verificar que el tipo de dato retornado sea igual a la funcion
                                Variable v = (Variable) ((Function_Return_Instruction) vr).getInstruction().ejecutar(child);
                                System.out.println(v);

                                if(v==null){
                                child.agrearErrores(new Error_analizadores("Semantico", child.getFuncion(id).getInstructions().get(i).getLinea(), child.getFuncion(id).getInstructions().get(i).getColumna(), "La instruccion return de la funcion '" + id + "'no esta definida"));    
                                return null;
                                }
                                
                                if (v.getType() == child.getFuncion(id).getType()) {
                                    countReturn++;
                                    return v;

                                } else if (vr instanceof Instruction_Break || vr instanceof Instruction_Continue) {
                                    return v;
                                } else {
                                    child.agrearErrores(new Error_analizadores("Semantico", child.getFuncion(id).getInstructions().get(i).getLinea(), child.getFuncion(id).getInstructions().get(i).getColumna(), "La instruccion return de la funcion '" + id + "' no cumple con el tipo de dato de la funcion"));
                                }
                            } else if (vr instanceof Function_Return_Simple) {
                                child.agrearErrores(new Error_analizadores("Semantico", child.getFuncion(id).getInstructions().get(i).getLinea(), child.getFuncion(id).getInstructions().get(i).getColumna(), "La instruccion return de la funcion '" + id + "' debe retornar un valor u operacion"));
                            }

                        }
                    } else {
                        child.agrearErrores(new Error_analizadores("Semantico", child.getFuncion(id).getInstructions().get(i).getLinea(), child.getFuncion(id).getInstructions().get(i).getColumna(), "Error en la ejecucion en las instrucciones de la funcion '" + id + "'"));
                    }
                }

                if (countReturn == 0) {

                    if (child.getFuncion(id).getType() != VariableType.VOID) {
                        child.agrearErrores(new Error_analizadores("Semantico", "", child.getFuncion(id).getLinea(), child.getFuncion(id).getColumna(), "La funcion '" + id + "' debe devolver un valor de tipo " + child.getFuncion(id).getType()));
                    }

                } else if (!child.getErrores().isEmpty()) {
                    for (int i = 0; i < child.getErrores().size(); i++) {
                        table.agrearErrores(child.getErrores().get(i));
                    }
                    return null;
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

    @Override
    public String convertGraphviz() {
        return "";
    }
}
