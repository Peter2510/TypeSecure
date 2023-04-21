/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.analisis;

import com.peter.typesecure.lexer.Lexer;
import com.peter.typesecure.parser.Parser;
import java.io.BufferedReader;
import java.io.StringReader;

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
            System.out.println(e.toString());
        }
    }

}
