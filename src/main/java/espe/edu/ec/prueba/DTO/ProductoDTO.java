package espe.edu.ec.prueba.DTO;

import java.math.BigDecimal;

public class ProductoDTO {
    private String nombre;
    private BigDecimal precio;
    private BigDecimal porcentajeRetorno;

    public ProductoFinanciero(String nombre, BigDecimal precio, BigDecimal porcentajeRetorno) {
        this.nombre = nombre;
        this.precio = precio;
        this.porcentajeRetorno = porcentajeRetorno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(BigDecimal porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }
}
