/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.analisis;

import com.peter.typesecure.archivos.ManejoArchivos;
import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.lexer.Lexer;
import com.peter.typesecure.parser.Parser;
import java.io.BufferedReader;
import java.io.StringReader;
import com.peter.typesecure.error.Error_analizadores;
import com.peter.typesecure.logica.Logica;
import java.util.ArrayList;

/**
 *
 * @author GORDILLOG
 */
public class Analisis {

    public void analizar(String data) {

        StringReader sr = new StringReader(data);
        BufferedReader br = new BufferedReader(sr);

        Lexer lexer = new Lexer(br);

        Parser parser = new Parser(lexer);

        try {
            
            parser.parse();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        if(parser.errores.isEmpty()){
            
            System.out.println("No hay errores en los analizadores");
            Logica a = new Logica();
            a.hola(parser.instructions);
            
                        
        }else{
            
            ManejoArchivos ma = new ManejoArchivos();
            ma.CrearErrorHTML("LexicoSintactico", parser.errores);
            
            parser.errores.clear();
            
            /*for(Error_analizadores errore : parser.errores){
                System.out.println(errore);
            }*/
        }
        
    }

}
