package espe.edu.ec.prueba.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class ProductoFinanciero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nombre;
    private String descripcion;
    private BigDecimal costo;
    private BigDecimal porcentaje_retorno;
    private boolean activo;

    public ProductoFinanciero(String nombre, String descripcion, BigDecimal costo, BigDecimal porcentaje_retorno, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.porcentaje_retorno = porcentaje_retorno;
        this.activo = activo;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getPorcentaje_retorno() {
        return porcentaje_retorno;
    }

    public void setPorcentaje_retorno(BigDecimal porcentajeretorno) {
        this.porcentaje_retorno = porcentajeretorno;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
