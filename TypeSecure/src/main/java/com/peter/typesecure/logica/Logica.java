/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.logica;

import com.peter.typesecure.archivos.ManejoArchivos;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Logica {

    public void  Ejecutar(ArrayList<Instruction> instruciones) {
        SymbolTable tablaE = new SymbolTable(null);
        ArrayList<Instruction> functions = new ArrayList();
        ArrayList<Instruction> other = new ArrayList();
        
        
        for (int i = 0; i < instruciones.size(); i++) {
            
            //System.out.println(instruciones.get(i).getClass());
            if(instruciones.get(i).getClass()==com.peter.typesecure.ejecucion.instrucciones.functions.Function_Void_Parameters.class
                ||instruciones.get(i).getClass()==com.peter.typesecure.ejecucion.instrucciones.functions.Function_Void_Simple.class
                ||instruciones.get(i).getClass()==com.peter.typesecure.ejecucion.instrucciones.functions.Function_With_Type_Parameters.class
                ||instruciones.get(i).getClass()==com.peter.typesecure.ejecucion.instrucciones.functions.Function_With_Type_Simple.class
                ||instruciones.get(i).getClass()==com.peter.typesecure.ejecucion.instrucciones.functions.Function_Without_Type_Parameters.class
                ||instruciones.get(i).getClass()==com.peter.typesecure.ejecucion.instrucciones.functions.Function_Without_Type_Simple.class){

                functions.add(instruciones.get(i));
                
            }else{
                other.add(instruciones.get(i));
            }

        }
        
        for (int i = 0; i < functions.size(); i++) {
            functions.get(i).ejecutar(tablaE);
        }
        
        for (int i = 0; i < other.size(); i++) {
            other.get(i).ejecutar(tablaE);
        }
        
        if(tablaE.getErrores().isEmpty()==false){
            ManejoArchivos ma = new ManejoArchivos();
            ma.CrearErrorHTML("Semanticos", tablaE.getErrores());
        }
        
    }
    
    
    
}
