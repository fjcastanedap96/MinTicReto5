package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.AsesorPorCiudadDao;
import model.dao.ComprasPorProyectoDao;
import model.dao.ProyectosCasaCampestreDoa;

import model.vo.AsesorPorCiudad;
import model.vo.ComprasPorProyecto;
import model.vo.ProyectosCasaCampestre;

//Librerías para bases de datos
import java.sql.SQLException;


public class ControladorRequerimientosReto4 {       
    
    private final AsesorPorCiudadDao asesorPorCiudadDao;    
    private final ComprasPorProyectoDao comprasPorProyectoDao;
    private final ProyectosCasaCampestreDoa proyectosCasaCampestreDao;
    
    public ControladorRequerimientosReto4(){
        this.asesorPorCiudadDao = new AsesorPorCiudadDao();       
        this.comprasPorProyectoDao = new ComprasPorProyectoDao();
        this.proyectosCasaCampestreDao = new ProyectosCasaCampestreDoa();
    }

    public ArrayList<AsesorPorCiudad> consultarAsesorPorCiudad() throws SQLException {
        return this.asesorPorCiudadDao.listadoAsesorPorCiudad();
    }
    
    public ArrayList<ComprasPorProyecto> consultarComprasPorProyecto() throws SQLException {
        return this.comprasPorProyectoDao.listadoComprasPorProyecto();
    }

    public ArrayList<ProyectosCasaCampestre> consultarProyectosCasaCampestre() throws SQLException {
        return this.proyectosCasaCampestreDao.listadoProyectosCasaCampestre();
    }

}
