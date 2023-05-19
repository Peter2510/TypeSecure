/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.*;
import com.peter.typesecure.ejecucion.instrucciones.*;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_Call_Parameters_Function extends Instruction {

    private String id;
    private ArrayList<Instruction> parameters_in;

    public Function_Call_Parameters_Function(Object linea, Object columna, Object id, ArrayList<Instruction> instruccion) {
        super(linea, columna);
        this.id = (String) id;
        this.parameters_in = instruccion;

    }

    @Override
    public Object ejecutar(SymbolTable table) {

        if (table.existeFuncion(id)) {

            if (table.getFuncion(id).hasParameters()) {

                if (table.getFuncion(id).getSizeParameters() == parameters_in.size()) {
                    int count_error = 0;
                    for (int i = 0; i < parameters_in.size(); i++) {
                        Variable tmp = (Variable) parameters_in.get(i).ejecutar(table);
                        if (!(tmp.getType() == table.getFuncion(id).getParameters().get(i).getType())) {
                            count_error++;
                        }
                    }

                    if (count_error == 0) {
                        SymbolTable head = new SymbolTable(table);
                        ArrayList<Instruction> param = new ArrayList();

                        for (int i = 0; i < parameters_in.size(); i++) {

                            param.add(new Declaration(
                                    (Object) table.getFuncion(id).getParameters().get(i).getLinea(),
                                    (Object) table.getFuncion(id).getParameters().get(i).getColumna(),
                                    (Object) AccessType.LET,
                                    (Object) table.getFuncion(id).getParameters().get(i).getType(),
                                    table.getFuncion(id).getParameters().get(i).getId(),
                                    (Object) parameters_in.get(i)));
                        }

                        for (int i = 0; i < param.size(); i++) {
                            param.get(i).ejecutar(head);
                        }

                        int countReturn = 0;
                        for (int i = 0; i < head.getFuncion(id).getInstructions().size(); i++) {
                            Object vr = head.getFuncion(id).getInstructions().get(i).ejecutar(head);

                            if (vr != null) {
                                if (vr instanceof Function_Return_Instruction || vr instanceof Function_Return_Simple || vr instanceof Instruction_Break || vr instanceof Instruction_Continue) {
                                    if (vr instanceof Function_Return_Instruction) {
                                        //verificar que el tipo de dato retornado sea igual a la funcion
                                        Variable v = (Variable) ((Function_Return_Instruction) vr).getInstruction().ejecutar(head);

                                        if (v.getType() == head.getFuncion(id).getType()) {
                                            countReturn++;
                                            return v;

                                        } else if (vr instanceof Instruction_Break || vr instanceof Instruction_Continue) {
                                            return v;
                                        } else {
                                            head.agrearErrores(new Error_analizadores("Semantico", head.getFuncion(id).getInstructions().get(i).getLinea(), head.getFuncion(id).getInstructions().get(i).getColumna(), "La instruccion return de la funcion '" + id + "' no cumple con el tipo de dato de la funcion"));
                                        }
                                    } else if (vr instanceof Function_Return_Simple) {
                                        head.agrearErrores(new Error_analizadores("Semantico", head.getFuncion(id).getInstructions().get(i).getLinea(), head.getFuncion(id).getInstructions().get(i).getColumna(), "La instruccion return de la funcion '" + id + "' debe retornar un valor u operacion"));
                                    }

                                }
                            } else {
                                head.agrearErrores(new Error_analizadores("Semantico", head.getFuncion(id).getInstructions().get(i).getLinea(), head.getFuncion(id).getInstructions().get(i).getColumna(), "Error en la ejecucion en las instrucciones de la funcion '" + id + "'"));
                            }

                        }

                        if (countReturn == 0) {

                            if (head.getFuncion(id).getType() != VariableType.VOID) {
                                head.agrearErrores(new Error_analizadores("Semantico", "", head.getFuncion(id).getLinea(), head.getFuncion(id).getColumna(), "La funcion '" + id + "' debe devolver un valor de tipo " + head.getFuncion(id).getType()));
                            }

                        }

                        if (!head.getErrores().isEmpty()) {
                            for (int i = 0; i < head.getErrores().size(); i++) {
                                table.agrearErrores(head.getErrores().get(i));
                            }
                            return null;
                        }

                    } else {
                        table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' y la invocacion no cumplen con el tipo de dato en los parametros"));
                        return null;
                    }

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' y la invocacion no cumplen con la cantidad necesaria de parametros"));
                    return null;
                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' no necesita parametros para poder ejecutarse"));
                return null;
            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' no ha sido definida "));
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

    public ArrayList<Instruction> getInstruccions() {
        return parameters_in;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.parameters_in = instruccions;
    }

    @Override
    public String toString() {
        return "Function_Call_Parameters_Function{" + "id=" + id + ", instruccions=" + parameters_in + '}';
    }

    @Override
    public String convertGraphviz() {
        return "";
    }
}
