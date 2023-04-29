/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.archivos;

import com.peter.typesecure.error.Error_analizadores;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author GORDILLOG
 */
public class ManejoArchivos {

    public String getPathCarpeta() {

        boolean seleccionCarpeta = false;
        String path = "";
        JFileChooser pathCarpteta = new JFileChooser();

        do {

            JOptionPane.showMessageDialog(null, "Selecciona una carpeta para guardar los errores hallados");
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
    
    public boolean existeArchivoSinCarpeta(String nombreArchivo){
        
        String path = getPathCarpeta();
        
        String pathAbsoluto = path + nombreArchivo;
        
        File documento = new File(pathAbsoluto);
        
        if(documento.exists()){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    public boolean existeArchivoConCarpeta(String path, String nombreArchivo){
        
                
        String pathAbsoluto = path + nombreArchivo;
        
        File documento = new File(pathAbsoluto);
        
        if(documento.exists()){
            return true;
        }else{
            return false;
        }
        
    }
    
    public void CrearErrorHTML(String tipoError, ArrayList<Error_analizadores> errores){
        
        FileWriter archivo = null;
        PrintWriter escribir = null;
        String path = getPathCarpeta();
        
        
        try {
         
            if(tipoError.equals("LexicoSintactico")){
                
                archivo = new FileWriter(path + "/erroresLexicoSintactico.html" );
                escribir = new PrintWriter(archivo);
                
               escribir.println("<!DOCTYPE html>");
               escribir.println("<html>");
               escribir.println("<head>");
               escribir.println("<meta charset=\"utf-8\">");
               escribir.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
               escribir.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0\n" +
".0/css/bootstrap.min.css\">");
               escribir.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min\n" +
".js\"></script>");
               escribir.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/p\n" +
"opper.min.js\"></script>");
               escribir.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.\n" +
"min.js\"></script>");
               escribir.println("<title>Errores Lexico-Sintacticos</title>");
               escribir.println("</head>");
               escribir.println("<body>");
               escribir.println("<h2 class=\"text text-bg-danger mt-2 text-center\">Errores hallados</h2>");
               escribir.println("<table class=\"table table-bordered\">");
               escribir.println("<thead>");
               escribir.println("<tr>");
               escribir.println("<th scope=\"col\">Tipo de Error</th>");
               escribir.println("<th scope=\"col\">Lexema</th>");
               escribir.println("<th scope=\"col\">Linea</th>");
               escribir.println("<th scope=\"col\">Columna</th>");
               escribir.println("<th scope=\"col\">Descripcion</th>");
               escribir.println("</tr>");
               escribir.println("</thead>");
               escribir.println("<tbody>");
                for (int i = 0; i < errores.size(); i++) {
                    escribir.println("<tr>");
                    escribir.println("<th>" + errores.get(i).getTipoError() +"</th>");
                    if(errores.get(i).getLexema()==null && errores.get(i).getFila() == 0 && errores.get(i).getColumna()== 0 ){
                        escribir.println("<th>" + " " +"</th>");
                        escribir.println("<th>" + " " +"</th>");
                        escribir.println("<th>" +" " + "</th>");
                        escribir.println("<th>" + errores.get(i).getDescripcion()+"</th>");
                        escribir.println("</tr>");
                    }else{
                        escribir.println("<th>" + errores.get(i).getLexema()+"</th>");
                        escribir.println("<th>" + errores.get(i).getFila()+"</th>");
                        escribir.println("<th>" + errores.get(i).getColumna()+"</th>");
                        escribir.println("<th>" + errores.get(i).getDescripcion()+"</th>");
                        escribir.println("</tr>");
                    }
                    
                    
                }
               
               escribir.println("</tbody>");
               escribir.println("</table>");
               escribir.println("</body>");
               escribir.println("</html>");


	
                archivo.close();
            }else{
                archivo = new FileWriter(path + "/erroresSemanticos.html" );
                
                
                archivo.close();
            }
         
            
        } catch (Exception e) {
            System.out.println("Error file" + e);
        }
        
    }
    
    
}