/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.peter.typesecure.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

/**
 *
 * @author GORDILLOG
 */
public class Archivos {

    private boolean PanelExistente = false;
    private JTabbedPane TabbedPane;
    private int numeroPanel = 0;
    private ArrayList<File> listaDeFiles = new ArrayList<File>();
    private ArrayList<JScrollPane> listaDeScroll = new ArrayList<JScrollPane>();
    private ArrayList<JTextPane> listaAreaDeTexto = new ArrayList<JTextPane>();
    
    
    public Archivos(JTabbedPane TabbedPane) {
        this.TabbedPane = TabbedPane;
    }

    public void crearPanel() {
        JPanel panelInterno = new JPanel();
        panelInterno.setLayout(new BorderLayout());
        listaDeFiles.add(new File(""));
        listaAreaDeTexto.add(new JTextPane());
        
        for (int i = 0; i < listaAreaDeTexto.size(); i++) {
            listaAreaDeTexto.get(i).setBackground(Color.darkGray);
            listaAreaDeTexto.get(i).setForeground(Color.white);
            listaAreaDeTexto.get(i).setFont( new Font( "Dialog", Font.TYPE1_FONT, 12 ) );
            Style indicatorStyle = listaAreaDeTexto.get(i).addStyle("IndicatorStyle", null);
            
            // Establecer el estilo de texto del indicador de posición
            listaAreaDeTexto.get(i).setCaretColor(Color.white);
            listaAreaDeTexto.get(i).setCaretPosition(0);
            listaAreaDeTexto.get(i).setCharacterAttributes(indicatorStyle, true);
        }
       
        NumeroLinea numeroLinea = new NumeroLinea(listaAreaDeTexto.get(numeroPanel));    
        listaDeScroll.add(new JScrollPane(listaAreaDeTexto.get(numeroPanel)));
        listaDeScroll.get(numeroPanel).setRowHeaderView(numeroLinea);
        
        panelInterno.add(listaDeScroll.get(numeroPanel),BorderLayout.CENTER);
        this.TabbedPane.add("sin titulo", panelInterno);
        this.TabbedPane.setSelectedIndex(numeroPanel);
        numeroPanel++;
        PanelExistente = true;
    }

    public void crearArchivo() {
        crearPanel();
    }

    public void abrirArchivo() {
        JFileChooser selectFile = new JFileChooser();
        selectFile.setDialogTitle("Selecciona el archivo a abrir");
        FileFilter filtro = new FileNameExtensionFilter("Archivos TypeSecure ", "ts");
        selectFile.setFileFilter(filtro);
        int seleccion = selectFile.showOpenDialog(listaAreaDeTexto.get(TabbedPane.getSelectedIndex()));

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {

                boolean existePath = false;
                for (int i = 0; i < TabbedPane.getTabCount(); i++) {
                    File file = selectFile.getSelectedFile();
                    System.out.println(file.getPath());
                    if (listaDeFiles.get(i).getPath().equals(file.getPath())) {
                        existePath = true;
                    }
                }

                if (!existePath) {
                    File archivo = selectFile.getSelectedFile();
                    listaDeFiles.set(TabbedPane.getSelectedIndex(), archivo);
                    FileReader entrada = new FileReader(listaDeFiles.get(TabbedPane.getSelectedIndex()).getPath());
                    BufferedReader buffer = new BufferedReader(entrada);
                    String ln = " ";
                    String titulo = listaDeFiles.get(TabbedPane.getSelectedIndex()).getName();
                    TabbedPane.setTitleAt(TabbedPane.getSelectedIndex(), titulo);

                    while (ln != null) {
                        ln = buffer.readLine();
                        if (ln != null) {
                            agregarAlCuadro(listaAreaDeTexto.get(TabbedPane.getSelectedIndex()), ln + "\n");
                        }
                    }
                } else {
                    for (int i = 0; i < TabbedPane.getTabCount(); i++) {
                        File file = selectFile.getSelectedFile();
                        if (listaDeFiles.get(i).getPath().equals(file.getPath())) {
                            TabbedPane.setSelectedIndex(i);
                            listaAreaDeTexto.remove(TabbedPane.getTabCount() - 1);
                            listaDeScroll.remove(TabbedPane.getTabCount() - 1);
                            listaDeFiles.remove(TabbedPane.getTabCount() - 1);
                            TabbedPane.remove(TabbedPane.getTabCount() - 1);
                            numeroPanel--;
                            break;
                        }
                    }
                }

            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            listaAreaDeTexto.remove(TabbedPane.getTabCount() - 1);
            listaDeScroll.remove(TabbedPane.getTabCount() - 1);
            listaDeFiles.remove(TabbedPane.getTabCount() - 1);
            TabbedPane.remove(TabbedPane.getTabCount() - 1);
            numeroPanel--;
        }
    }

    public void agregarAlCuadro(JTextPane area, String ln) {
        try {
            Document documento = area.getDocument();
            documento.insertString(documento.getLength(), ln, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void cerrarArchivo() {
        if (numeroPanel > 0) {
            listaAreaDeTexto.remove(TabbedPane.getSelectedIndex());
            listaDeScroll.remove(TabbedPane.getSelectedIndex());
            listaDeFiles.remove(TabbedPane.getSelectedIndex());
            TabbedPane.remove(TabbedPane.getSelectedIndex());
            numeroPanel--;
            /*
            listaAreaDeTexto.remove(TabbedPane.getTabCount() - 1);
            listaDeScroll.remove(TabbedPane.getTabCount() - 1);
            listaDeFiles.remove(TabbedPane.getTabCount() - 1);
            TabbedPane.remove(TabbedPane.getTabCount() - 1);
            numeroPanel--;*/
        }

    }

    public void guardarArchivo() {

        if (numeroPanel > 0) {

            if (listaDeFiles.get(TabbedPane.getSelectedIndex()).getPath().equals("")) {
                guardarNuevo();
            } else {
                guardarExistente();
            }
        }

    }

    public void guardarNuevo() {

        try {
            JFileChooser guardar = new JFileChooser();
            guardar.setDialogTitle("Seleccionar carpeta");
            int seleccion = guardar.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File file = guardar.getSelectedFile();
                listaDeFiles.set(TabbedPane.getSelectedIndex(), file);
                TabbedPane.setTitleAt(TabbedPane.getSelectedIndex(), file.getName());

                FileWriter fileWriter = new FileWriter(listaDeFiles.get(TabbedPane.getSelectedIndex()).getPath());
                String data = listaAreaDeTexto.get(TabbedPane.getSelectedIndex()).getText();

                for (int i = 0; i < data.length(); i++) {
                    fileWriter.write(data.charAt(i));
                }

                fileWriter.close();

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void guardarExistente() {
        try {
            FileWriter fileWriter = new FileWriter(listaDeFiles.get(TabbedPane.getSelectedIndex()).getPath());
            String data = listaAreaDeTexto.get(TabbedPane.getSelectedIndex()).getText();

            for (int i = 0; i < data.length(); i++) {
                fileWriter.write(data.charAt(i));
            }

            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void guardarArchivoComo() {
        guardarNuevo();
    }
    
    public void seleccionarTodo(){
        
        try {
            listaAreaDeTexto.get(TabbedPane.getSelectedIndex()).selectAll();
        } catch (Exception e) {
            System.out.println("");
        }
        
    }
    
    public String textoCompilar(){
            
      return listaAreaDeTexto.get(TabbedPane.getSelectedIndex()).getText();
        
    }
    
    public Boolean hayPestaña(){
        if(numeroPanel>0){
            return true;
        }else{
            return false;
        }
    }

}
