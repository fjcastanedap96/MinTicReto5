package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos AsesorPorCiudad
import model.vo.AsesorPorCiudad;

public class AsesorPorCiudadDao {
    
    public ArrayList<AsesorPorCiudad> listadoAsesorPorCiudad() throws SQLException {
        
        ArrayList<AsesorPorCiudad> respuesta = new ArrayList<AsesorPorCiudad>();
        Connection conexion = JDBCUtilities.getConnection();

        try{

            String consulta =   "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia "+
                                "FROM Lider "+
                                "WHERE Cargo = 'Asesor' "+
                                "ORDER BY Ciudad_Residencia ASC";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            //Recorre los registros de los vo especificos

            while (resultado.next()) {
                AsesorPorCiudad asesorPorCiudad = new AsesorPorCiudad();
                asesorPorCiudad.setIdLider(resultado.getInt("ID_Lider"));
                asesorPorCiudad.setNombre(resultado.getString("Nombre"));
                asesorPorCiudad.setPrimerApellido(resultado.getString("Primer_Apellido"));
                asesorPorCiudad.setCiudadResidencia(resultado.getString("Ciudad_Residencia"));

                //se agregac ada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(asesorPorCiudad);
            }

            resultado.close();
            statement.close();

        } catch(SQLException e) {
            System.err.println("Error consultando los lideres por nombre: "+e);
        }finally{
            if(conexion != null) {
                conexion.close();
            }
        }

        //retorna la coleccion de vo's
        return respuesta;

    }
    
}
