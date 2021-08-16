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
import model.vo.ComprasPorProyecto;

public class ComprasPorProyectoDao {
   
    public ArrayList<ComprasPorProyecto> listadoComprasPorProyecto() throws SQLException {

        ArrayList<ComprasPorProyecto> respuesta = new ArrayList<ComprasPorProyecto>();
        Connection conexion = JDBCUtilities.getConnection();
       
        try{

            String consulta =   "SELECT c.ID_Compra , c.Proveedor , p.Constructora , p.Banco_Vinculado , p.Ciudad "+
                                "FROM Proyecto p "+
                                "INNER JOIN Compra c on c.ID_Proyecto = p.ID_Proyecto "+
                                "WHERE p.Ciudad = 'Salento' and c.Proveedor = 'Homecenter'";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            //recorre los registros de los vo
            while (resultado.next()) {
                ComprasPorProyecto comprasPorProyecto = new ComprasPorProyecto();
                comprasPorProyecto.setIdCompra(resultado.getInt("ID_Compra"));
                comprasPorProyecto.setProveedor(resultado.getString("Proveedor"));
                comprasPorProyecto.setConstructura(resultado.getString("Constructora"));
                comprasPorProyecto.setBancoVinculado(resultado.getString("Banco_Vinculado"));
                comprasPorProyecto.setCiudad(resultado.getString("Ciudad"));

                //se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(comprasPorProyecto);
            }

            resultado.close();
            statement.close();
        
        }catch(SQLException e) {
            System.err.println("Error consultando compras por proyecto: "+e);
        }finally{
            if(conexion != null) {
                conexion.close();
            }
        }
        
        //retorna la coleccion de vo's
        return respuesta;
    }
        
}
