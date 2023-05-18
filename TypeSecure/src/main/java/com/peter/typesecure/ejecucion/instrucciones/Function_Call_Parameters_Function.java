/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.AccessType;
import com.peter.typesecure.ejecucion.Genericos.Assignment;
import com.peter.typesecure.ejecucion.Genericos.Declaration;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.ejecucion.Genericos.VariableType;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_Call_Parameters_Function extends Instruction{

    private String id;
    private ArrayList<Instruction> parameters_in;

    
    public Function_Call_Parameters_Function(Object linea, Object columna,Object id,ArrayList<Instruction> instruccion) {
        super(linea, columna);
        this.id = (String)id;
        this.parameters_in = instruccion;

    }

    @Override
    public Object ejecutar(SymbolTable table) {
        
        if(table.existeFuncion(id)){
        
            
            if(table.getFuncion(id).hasParameters()){

                if(table.getFuncion(id).getSizeParameters()==parameters_in.size()){
                    int count_error = 0;
                    for (int i = 0; i < parameters_in.size(); i++) {
                        Variable tmp = (Variable)parameters_in.get(i).ejecutar(table);
                        if(!(tmp.getType()==table.getFuncion(id).getParameters().get(i).getType())){
                            count_error++;
                        }
                    }
                    
                    if(count_error==0){
                        SymbolTable head = new SymbolTable(table);
                        ArrayList<Instruction> param = new ArrayList();
                        
                        System.out.println("id "  + table.getFuncion(id).getParameters().get(0).getId());
                        System.out.println("acces " + AccessType.LET);
                        System.out.println("type " + table.getFuncion(id).getParameters().get(0).getType());
                        System.out.println("Istructio " + parameters_in.get(0));
                        
                        for (int i = 0; i < parameters_in.size(); i++) {
                            
                            param.add(new Declaration(
                                    (Object)table.getFuncion(id).getParameters().get(i).getLinea(),
                                    (Object)table.getFuncion(id).getParameters().get(i).getColumna(),
                                    (Object)AccessType.LET,
                                    (Object)table.getFuncion(id).getParameters().get(i).getType(),
                                    table.getFuncion(id).getParameters().get(i).getId(),
                                    (Object)parameters_in.get(i)));
                        }
                        
                        for (int i = 0; i < param.size(); i++) {
                            param.get(i).ejecutar(head);
                        }
                        
                        for (int i = 0; i < head.getFuncion(id).getInstructions().size(); i++) {
                            Object vr = head.getFuncion(id).getInstructions().get(i).ejecutar(head);
                        }
                        
                    }else{
                        table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' y la invocacion no cumplen con el tipo de dato en los parametros"));
                        return null;
                    }
                    
                    
                }else{
                    table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' y la invocacion no cumplen con la cantidad necesaria de parametros"));
                    return null;                                    
                }
                
                
            }else{
                table.agrearErrores(new Error_analizadores("Semantico", this.getLinea(), this.getColumna(), "La funcion '" + id + "' no admite parametros"));
                return null;                
            }
            
            
        }else{
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
    
}
