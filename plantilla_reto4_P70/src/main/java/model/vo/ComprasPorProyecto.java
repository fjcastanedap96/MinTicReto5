package model.vo;

public class ComprasPorProyecto {
    
    private Integer idCompra;
    private String proveedor;
    private String constructura;
    private String bancoVinculado;
    private String ciudad;

    public ComprasPorProyecto() {        
    }

    public ComprasPorProyecto(Integer idCompra, String proveedor, String constructura, String bancoVinculado, String ciudad) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.constructura = constructura;
        this.bancoVinculado = bancoVinculado;
        this.ciudad = ciudad;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getConstructura() {
        return constructura;
    }

    public void setConstructura(String constructura) {
        this.constructura = constructura;
    }

    public String getBancoVinculado() {
        return bancoVinculado;
    }

    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    
    
}
