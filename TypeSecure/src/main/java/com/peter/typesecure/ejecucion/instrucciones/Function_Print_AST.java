/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecucion.instrucciones;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.archivos.GenerateDot;
import com.peter.typesecure.ejecucion.Genericos.Variable;

/**
 *
 * @author GORDILLOG
 */
public class Function_Print_AST extends Instruction{

    private Instruction instruction;
    
    public Function_Print_AST(Object linea, Object columna,Object instruction) {
        super(linea, columna);
        this.instruction = (Instruction)instruction;
    }

    @Override
    public Object ejecutar(SymbolTable table) {
        //verificar que la instruction sea de tipo string o texto
        
        
        if(table!=null && instruction!=null){
            
            Variable v = (Variable) instruction.ejecutar(table);

            if(v!=null){
    
                if(table.existeFuncion((String)v.getValue())==true){
                    GenerateDot d = new GenerateDot();
                    d.ejecutarCodigoGraphviz(table, (String)v.getValue());                
                }else{
                    System.out.println(table.getFunciones());
                    System.out.println("no existe");
                }
                
                
            }else{
             System.out.println("asegurase de que las dos enstanbine");   
            }
            

        }else{
            System.out.println("asegurase de que las dos enstanbine");
        }
        
        return null;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "Function_Print_AST{" + "instruction=" + instruction + '}';
    }
    
        @Override
    public String convertGraphviz() {
        return "";
    }
    
}
