/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Condicionales.*;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import com.peter.typesecure.error.Error_analizadores;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Function_If extends Instruction {

    private If _if;
    private ArrayList<ElseIf> else_if;
    private Instruction _else;

    public Function_If(Object linea, Object columna, Object _if, ArrayList<ElseIf> else_if, Object _else) {
        super(linea, columna);
        this._if = (If) _if;
        this.else_if = else_if;
        this._else = (Else) _else;
    }

    @Override
    public Object ejecutar(SymbolTable table) {

        //if
        if (_if != null && else_if == null && _else == null) {

            System.out.println("if");
            Variable var_if = (Variable) _if.ejecutar(table);

            if (var_if != null) {

                if ((Boolean) var_if.getValue()) {

                    SymbolTable child = new SymbolTable(table);

                    for (int i = 0; i < _if.getInstructions().size(); i++) {

                        Object vr = _if.getInstructions().get(i).ejecutar(child);
                        

                    }
                    //agregando errores
                    for (int i = 0; i < child.getErrores().size(); i++) {
                        table.agrearErrores(child.getErrores().get(i));
                    }

                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No fue posible ejecutar la instruccion if"));
                return null;
            }

            //if else   
        } else if (_if != null && else_if == null && _else != null) {
            System.out.println("if else");

            Variable val_if = (Variable) _if.ejecutar(table);

            if (val_if != null) {

                if ((Boolean) val_if.getValue()) {

                    SymbolTable child = new SymbolTable(table);

                    for (int i = 0; i < _if.getInstructions().size(); i++) {

                       Object vr = _if.getInstructions().get(i).ejecutar(child);

                    }
                    //agregando errores
                    for (int i = 0; i < child.getErrores().size(); i++) {
                        table.agrearErrores(child.getErrores().get(i));
                    }

                }else{
                    
                    SymbolTable child = new SymbolTable(table);
                    
                      Object vr = _else.ejecutar(child);

                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No fue posible ejecutar la instruccion if"));
                return null;
            }


            //if else_if   
        } else if (_if != null && else_if!=null && _else == null) {
            System.out.println("if else_if");
            Variable val_if = (Variable) _if.ejecutar(table);

            if (val_if != null) {

                if ((Boolean) val_if.getValue()==true) {

                    SymbolTable child = new SymbolTable(table);

                    for (int i = 0; i < _if.getInstructions().size(); i++) {

                      Object vr = _if.getInstructions().get(i).ejecutar(child);

                    }
                    //agregando errores
                    for (int i = 0; i < child.getErrores().size(); i++) {
                        table.agrearErrores(child.getErrores().get(i));
                    }

                }else{
                    
                    if(!else_if.isEmpty()){
                        
                        for (int i = 0; i < else_if.size(); i++) {
                            Variable tmp = (Variable)else_if.get(i).ejecutar(table);
                            if(tmp!=null){
                                
                                if((Boolean)tmp.getValue()==true){
                                    SymbolTable child = new SymbolTable(table);
                                    for (int j = 0; j < else_if.get(i).getInstructions().size(); j++) {
                                     Object vr =  else_if.get(i).getInstructions().get(j).ejecutar(child);
                                    }
                                    break;
                                }
                                
                            }else{
                                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No fue posible ejecutar la instruccion else if"));
                                return null;                                
                            }
                        }
                        
                    }

                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No fue posible ejecutar la instruccion if"));
                return null;
            }
            

            return null;

            //if else_if else   
        } else if (_if != null && !else_if.isEmpty() && _else != null) {
            System.out.println("if else_if else");
            Variable val_if = (Variable) _if.ejecutar(table);

            if (val_if != null) {

                if ((Boolean) val_if.getValue()==true) {

                    SymbolTable child = new SymbolTable(table);

                    for (int i = 0; i < _if.getInstructions().size(); i++) {

                     Object vr =  _if.getInstructions().get(i).ejecutar(child);

                    }
                    //agregando errores
                    for (int i = 0; i < child.getErrores().size(); i++) {
                        table.agrearErrores(child.getErrores().get(i));
                    }

                }else{
                    
                    if(!else_if.isEmpty()){
                        int countTrueElseIf =0;
                        for (int i = 0; i < else_if.size(); i++) {
                            Variable tmp = (Variable)else_if.get(i).ejecutar(table);
                            if(tmp!=null){
                                
                                if((Boolean)tmp.getValue()==true){
                                    countTrueElseIf++;
                                    SymbolTable child = new SymbolTable(table);
                                    for (int j = 0; j < else_if.get(i).getInstructions().size(); j++) {
                                     Object vr =   else_if.get(i).getInstructions().get(j).ejecutar(child);
                                    }
                                    break;
                                }
                                
                            }else{
                                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No fue posible ejecutar la instruccion else if"));
                                return null;                                
                            }
                        }
                        
                        if(countTrueElseIf==0){
                           Object vr = _else.ejecutar(table);
                        }
                        
                    }

                }

            } else {
                table.agrearErrores(new Error_analizadores("Semantico", "", this.getLinea(), this.getColumna(), "No fue posible ejecutar la instruccion if"));
                return null;
            }
            return null;
        }

        return null;

    }

    public Instruction getIf() {
        return _if;
    }

    public void setIf(If _if) {
        this._if = _if;
    }

    public Instruction getElse() {
        return _else;
    }

    public void setElse(Instruction _else) {
        this._else = _else;
    }

    public ArrayList<ElseIf> getElse_if() {
        return else_if;
    }

    public void setElse_if(ArrayList<ElseIf> else_if) {
        this.else_if = else_if;
    }

    @Override
    public String toString() {
        return "Function_If{" + "_if=" + _if + ", _else=" + _else + ", else_if=" + else_if + '}';
    }

}
