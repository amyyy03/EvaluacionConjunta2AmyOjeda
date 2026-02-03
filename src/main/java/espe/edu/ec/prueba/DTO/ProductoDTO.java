package espe.edu.ec.prueba.DTO;

import java.math.BigDecimal;

public class ProductoDTO {
    private String nombre;
    private BigDecimal precio;
    private BigDecimal porcentajeGanancia;
    private BigDecimal porcentajeRetorno;

    public BigDecimal getPorcentajeRetorno() {
        return porcentajeRetorno;
    }

    public void setPorcentajeRetorno(BigDecimal porcentajeRetorno) {
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
