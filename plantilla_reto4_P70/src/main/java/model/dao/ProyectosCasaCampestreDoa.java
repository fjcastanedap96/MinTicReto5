package model.dao;

//Estructura de datos
import java.util.ArrayList;

//import javax.swing.JSpinner.NumberEditor;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.ProyectosCasaCampestre;

public class ProyectosCasaCampestreDoa {
    //Obtener los proyectos por Tipo 
    public ArrayList<ProyectosCasaCampestre> listadoProyectosCasaCampestre() throws SQLException {

        ArrayList<ProyectosCasaCampestre> respuesta = new ArrayList<ProyectosCasaCampestre>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT ID_Proyecto , Constructora , Numero_Habitaciones , Ciudad  "+
                                "FROM Proyecto "+
                                "WHERE Clasificacion = 'Casa Campestre' "+
                                "and Ciudad in ('Santa Marta', 'Cartagena', 'Barranquilla')";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultado.next()){
                ProyectosCasaCampestre proyectosCasaCampestre = new ProyectosCasaCampestre();
                proyectosCasaCampestre.setIdProyecto(resultado.getInt("ID_Proyecto"));
                proyectosCasaCampestre.setConstrutora(resultado.getString("Constructora"));
                proyectosCasaCampestre.setHabitaciones(resultado.getInt("Numero_Habitaciones"));
                proyectosCasaCampestre.setCiudad(resultado.getString("Ciudad"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(proyectosCasaCampestre);
            }

            resultado.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos de tipo Casa Campestre en: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
    }     
}
