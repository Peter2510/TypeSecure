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
        System.out.println(raiz.toString());
       
       
       
        
        
        
        
        
    }
    
    
}
