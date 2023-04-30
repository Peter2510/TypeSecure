/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.ejecutar;

/**
 *
 * @author GORDILLOG
 */
public abstract class Instruccion {
   int linea;
   int columna;
   
   abstract Object ejecutar();
    
}
