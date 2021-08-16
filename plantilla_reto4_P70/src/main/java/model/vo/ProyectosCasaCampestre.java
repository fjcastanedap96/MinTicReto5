package model.vo;

public class ProyectosCasaCampestre {
    
    private Integer idProyecto;
    private String construtora;
    private Integer habitaciones;
    private String ciudad;

    public ProyectosCasaCampestre() {
    }

    public ProyectosCasaCampestre(Integer idProyecto, String construtora, Integer habitaciones, String ciudad) {
        this.idProyecto = idProyecto;
        this.construtora = construtora;
        this.habitaciones = habitaciones;
        this.ciudad = ciudad;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getConstrutora() {
        return construtora;
    }

    public void setConstrutora(String construtora) {
        this.construtora = construtora;
    }

    public Integer getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    
    
}
