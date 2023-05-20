/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.archivos;

import com.peter.typesecure.ejecucion.Genericos.Instruction;
import com.peter.typesecure.ejecucion.Genericos.SymbolTable;
import com.peter.typesecure.ejecucion.Genericos.Variable;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author GORDILLOG
 */
public class GenerateDot {

    private String getCodeGraphviz(SymbolTable table, String id) {
        // label nombre
        // shape forma
        // color color
        // edge flecha
        String datos = "digraph G\n" 
                + "{\n" + ""
                + "node[shape = circle]\n" 
                + "    node[style = filled]\n" + ""
                + "    node[fillcolor = \"#FFFF00\"]\n" + " "
                + "   node[color = \"#FF7F00\"]\n"
                + "    edge[color = \"#000000\",arrowhead=none]\n";


                datos += table.getFuncion(id).generarDot();
                System.out.println(datos);
        
                    datos += "\n label=\"\\n\\nAST funcion '"+ id +"'\\n\\n\"}";

                    
return datos;

    }

    private void escribirDot(String path, String data) {

        PrintWriter escribirtFile = null;
        FileWriter file = null;

        try {

            file = new FileWriter("AST.dot");
            escribirtFile = new PrintWriter(file);
            escribirtFile.write(data);
            escribirtFile.close();
            file.close();

        } catch (Exception pe) {
            System.out.println(pe);

        } finally {
            if (escribirtFile != null) {
                escribirtFile.close();
            }
        }
    }

    public void ejecutarCodigoGraphviz(SymbolTable table, String id) {
        
        try {
            
            escribirDot("AST.dot", getCodeGraphviz(table, id));
            ProcessBuilder aux;

            // creacion de la imagen con los comandos por ProcessBuilder
            aux = new ProcessBuilder("dot", "-Tpng", "AST.dot", "-o", "AST.jpg");
            aux.redirectErrorStream(true);
            aux.start();

        } catch (Exception pe) {
            System.out.println(pe);
        }
    }

    private String getPathCarpeta() {

        boolean seleccionCarpeta = false;
        String path = "";
        JFileChooser pathCarpteta = new JFileChooser();

        do {

            JOptionPane.showMessageDialog(null, "Selecciona una carpeta para guardar el AST");
            pathCarpteta.setDialogTitle("Seleccionar carpeta");
            pathCarpteta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            pathCarpteta.setAcceptAllFileFilterUsed(false);

            if (pathCarpteta.showDialog(null, "Seleccionar") == JFileChooser.APPROVE_OPTION) {

                File archivo;
                archivo = pathCarpteta.getSelectedFile();
                path = archivo.getAbsolutePath();
                seleccionCarpeta = true;

            } else {

                JOptionPane.showMessageDialog(null, "Debes seleccionar una carpeta");

            }

        } while (seleccionCarpeta == false);

        return path;

    }

}
