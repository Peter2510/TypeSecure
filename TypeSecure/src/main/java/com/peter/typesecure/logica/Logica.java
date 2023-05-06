/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.logica;

import com.peter.typesecure.arbol.Nodo;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Logica {
    
    private Nodo raiz;
    private String dot = "";
       
    
    public Logica(ArrayList raiz){
        if(raiz.get(0)!=null){
            this.raiz = (Nodo) raiz.get(0);
        }else{
            this.raiz = null;
        }
    }
    
    public void analizar(){
        Nodo instrucciones = raiz.getHijos().get(0);
        Nodo instruccion1 = instrucciones.getHijos().get(0);
        Nodo tipoInstruccion = instruccion1.getHijos().get(0);
        
       Nodo tipoAcceso = tipoInstruccion.getHijos().get(0);
       Nodo id_valor_variable = tipoInstruccion.getHijos().get(1);
        
       Nodo tipoDeclaracion = id_valor_variable.getHijos().get(0);
       
       Nodo id = tipoDeclaracion.getHijos().get(0);
              
       String igual = tipoDeclaracion.getHijos().get(1).toString();
       
       Nodo valor_variable = tipoDeclaracion.getHijos().get(2);
       Nodo tipo_valor_variable = valor_variable.getHijos().get(0);
       Nodo tipo_valor_variable2 = tipo_valor_variable.getHijos().get(0);
       String mat = tipo_valor_variable2.getHijos().get(0).toString();
       
       
       String pt = tipoInstruccion.getHijos().get(2).toString();
       
        System.out.println(tipoAcceso.toString());
        System.out.println(id.toString());
        System.out.println(igual);
        System.out.println(tipo_valor_variable.toString());
        System.out.println(tipo_valor_variable2.toString());
        System.out.println(mat);
        System.out.println(pt);
        
        
        
        
        
    }
    
    
}
