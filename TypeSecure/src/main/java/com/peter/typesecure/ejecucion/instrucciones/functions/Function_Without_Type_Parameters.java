/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones.functions;

import com.peter.typesecure.analisis.ejecucion.auxiliares.Function;
import com.peter.typesecure.analisis.ejecucion.auxiliares.Parameter;
import com.peter.typesecure.archivos.Dot;
import com.peter.typesecure.ejecucion.Genericos.AccessType;
import com.peter.typesecure.ejecucion.Genericos.Declaration;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.ejecucion.instrucciones.Function_Return_Instruction;
import com.peter.typesecure.ejecucion.instrucciones.Function_Return_Simple;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author GORDILLOG
 */
public class Function_Without_Type_Parameters extends Instruction {

    private String id;
    private VariableType type;
    private ArrayList<Parameter> parameters_in;
    private ArrayList<Instruction> instruccions;
    
    public Function_Without_Type_Parameters(Object linea, Object columna,Object name, VariableType type,ArrayList<Parameter> parameters,ArrayList<Instruction> instructions) {
        super(linea, columna);
        this.id = (String) name;
        this.type = type;
        this.parameters_in = parameters;
        this.instruccions = instructions;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //ejecutar solo instrucciones de tipo returns
        SymbolTable original = new SymbolTable(table);

        if (!table.existeFuncion(id)) {
            
            ArrayList<Variable> returns = new ArrayList();
            for (int i = 0; i < instruccions.size(); i++) {
                if (instruccions.get(i).getClass() != com.peter.typesecure.ejecucion.instrucciones.Function_Console_Log.class 
                        &&instruccions.get(i).getClass() != com.peter.typesecure.ejecucion.instrucciones.Function_Get_Symbol_Table.class
                        &&instruccions.get(i).getClass() != com.peter.typesecure.ejecucion.instrucciones.Function_Print_AST.class ) {
                    System.out.println(instruccions.get(i).getClass());
                    Object tr = instruccions.get(i).ejecutar(table);
                    if (tr != null) {
                        if (tr instanceof Function_Return_Instruction || tr instanceof Function_Return_Simple) {
                            if (tr instanceof Function_Return_Simple) {
                                table.agrearErrores(new Error_analizadores("Semantico", instruccions.get(i).getLinea(), instruccions.get(i).getColumna(), "La instruccion Return debe retornar un valor o instruccion"));
                                return null;
                            } else if (tr instanceof Function_Return_Instruction) {

                                Variable v = (Variable) ((Function_Return_Instruction) tr).getInstruction().ejecutar(table);
                                returns.add(v);
                            }
                        }
                    }
                }

            }
                    System.out.println("------"+table.getErrores());

            for (int i = 0; i < table.getErrores().size(); i++) {
                original.agrearErrores(table.getErrores().get(i));
            }

            if (returns.isEmpty()) {
                type = VariableType.VOID;

                original.agregarFuncion(id, new Function(this.getLinea(), this.getColumna(), id, type, parameters_in, instruccions));
                table = original;
                return this;
            } else {
                int count_error = 0;
                for (int i = 0; i < returns.size() - 1; i++) {
                    for (int j = i + 1; j < returns.size(); j++) {

                        if (returns.get(i).getType() != returns.get(j).getType()) {
                            count_error++;
                        }

                    }
                }

                if (count_error == 0) {

                    //para el tipo de funcion, verifivadr los parametros y sacar los tipos y poner el tipo de dato; 

                    type = returns.get(0).getType();
                    original.agregarFuncion(id, new Function(this.getLinea(), this.getColumna(), id, type, parameters_in, instruccions));
                    table = original;
                    System.out.println(table.getFunciones());
                    return this;

                } else {
                    table.agrearErrores(new Error_analizadores("Semantico", 0, 0, "Las instrucciones return de la funcion " + id + " deben retornar un mismo tipo de dato"));
                    for (int i = 0; i < table.getErrores().size(); i++) {
                        original.agrearErrores(table.getErrores().get(i));
                    }
                    return null;
                }

            }

        } else {
            table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' ya ha sido definida "));
            for (int i = 0; i < table.getErrores().size(); i++) {
                original.agrearErrores(table.getErrores().get(i));
            }
            return null;
        }
    }

    public String getName() {
        return id;
    }

    public void setName(String name) {
        this.id = name;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters_in;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters_in = parameters;
    }

    public ArrayList<Instruction> getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(ArrayList<Instruction> instruccions) {
        this.instruccions = instruccions;
    }
     
    @Override
    public String toString() {
        return "Function_Without_Type_Parameters{" + "name=" + id + ", type=" + type + ", parameters=" + parameters_in + ", instruccions=" + instruccions + '}';
    }

        @Override
    public String convertGraphviz(Dot dot) {
        return "";
    }
}
