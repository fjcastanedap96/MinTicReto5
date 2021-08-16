package view;

import controller.ControladorRequerimientosReto4;

import model.vo.AsesorPorCiudad;
import model.vo.ComprasPorProyecto;
import model.vo.ProyectosCasaCampestre;

//import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import javax.swing.text.html.AccessibleHTML.TableElementInfo.TableAccessibleContext;

import java.awt.*;

public class VistaRequerimientosReto4 {

    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();    

    public static void requerimiento1() {        
               
         
        JFrame frame = new JFrame();
        frame.setTitle("[MinTic2022]  Ciclo2 | Reto5  ..:: by Francisco ::..");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());        
        frame.setVisible(true);//making the frame visible 
        JLabel label = new JLabel("*** Asesor por Ciudad ***");                 
        JPanel panel = new JPanel(); 
        panel.add(label);           
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Lider", "Nombre", "Primer_Apellido", "Ciudad_Residencia"}, 0);        

        try{
            
            ArrayList<AsesorPorCiudad> listaAsesorPorCiudad = controlador.consultarAsesorPorCiudad();            
            //Cada VO cargado, mostrarlo en la vista
            for (AsesorPorCiudad asesorPorCiudad : listaAsesorPorCiudad) {                
                model.addRow(new Object[]{asesorPorCiudad.getIdLider(), asesorPorCiudad.getNombre(), asesorPorCiudad.getPrimerApellido(), asesorPorCiudad.getCiudadResidencia()});
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

        JTable table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        
        table.setModel(model);
        panel.add(table);
        frame.add(panel); 
        //frame.setSize(500,500);//400 width and 500 height  
        frame.pack();
        frame.setLocationRelativeTo(null);          
        frame.setVisible(true);        
        
    }

    public static void requerimiento2() {
        JFrame frame = new JFrame();
        frame.setTitle("[MinTic2022]  Ciclo2 | Reto5  ..:: by Francisco ::..");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());        
        frame.setVisible(true);//making the frame visible 
        frame.setLayout(new BorderLayout()); 
        JLabel label = new JLabel("*** Compras por Proveedor ***");                 
        JPanel panel = new JPanel(); 
        panel.add(label);           
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Compra", "Contructora", "Banco", "Ciudad"}, 0); 

        try {
            ArrayList<ComprasPorProyecto> listaComprasPorProyecto = controlador.consultarComprasPorProyecto();          

            // Cada VO cargado, mostrarlo en vista
            for (ComprasPorProyecto comprasPorProyecto : listaComprasPorProyecto) {
                model.addRow(new Object[]{comprasPorProyecto.getIdCompra(), comprasPorProyecto.getConstructura(), comprasPorProyecto.getBancoVinculado(), comprasPorProyecto.getCiudad()});                
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
        JTable table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        
        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
JTextField textbox = new JTextField();
String textvalue = textbox.getText();
String roll= "";
String name= "";
String cl = "";
String sec = "";

        
        panel.add(scroll);
        panel.add(table);
        frame.add(panel); 
        //frame.setSize(500,500);//400 width and 500 height  
        frame.pack();
        frame.setLocationRelativeTo(null);          
        frame.setVisible(true);    
    }

    public static void requerimiento3() {

        JFrame frame = new JFrame();
        frame.setTitle("[MinTic2022]  Ciclo2 | Reto5  ..:: by Francisco ::..");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());        
        frame.setVisible(true);//making the frame visible 
        JLabel label = new JLabel("*** Proyectos Casa Campestre ***");                 
        JPanel panel = new JPanel(); 
        panel.add(label);           
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Proyecto", "Contructora", "Habitaciones", "Ciudad"}, 0); 

        try {
            ArrayList<ProyectosCasaCampestre> listaProyectosCasaCampestre = controlador
                    .consultarProyectosCasaCampestre();           

            // cada vo cargado, mostrarlo en vista
            for (ProyectosCasaCampestre proyectosCasaCampestre : listaProyectosCasaCampestre) {
                model.addRow(new Object[]{proyectosCasaCampestre.getIdProyecto(), proyectosCasaCampestre.getConstrutora(), proyectosCasaCampestre.getHabitaciones(), proyectosCasaCampestre.getCiudad()});                
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un erro!" + e.getMessage());
        }
        JTable table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        
        table.setModel(model);
        panel.add(table);
        frame.add(panel); 
        //frame.setSize(500,500);//400 width and 500 height  
        frame.pack();
        frame.setLocationRelativeTo(null);          
        frame.setVisible(true);
    }

}
