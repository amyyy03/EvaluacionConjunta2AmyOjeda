package espe.edu.ec.prueba.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Simulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID usuarioid;
    private LocalDateTime fecha_simulacion;
    private BigDecimal capital_disponible;
    private BigDecimal ganancia_total;
    private BigDecimal retorno_total;

    @ElementCollection
    private List<ProductoSelecionado> productosSeleccionados;


    public BigDecimal getRetorno_total() {
        return retorno_total;
    }

    public void setRetorno_total(BigDecimal retorno_total) {
        this.retorno_total = retorno_total;
    }

    public List<ProductoSelecionado> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    public void setProductosSeleccionados(List<ProductoSelecionado> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(UUID usuarioid) {
        this.usuarioid = usuarioid;
    }

    public LocalDateTime getFecha_simulacion() {
        return fecha_simulacion;
    }

    public void setFecha_simulacion(LocalDateTime fecha_simulacion) {
        this.fecha_simulacion = fecha_simulacion;
    }

    public BigDecimal getCapital_disponible() {
        return capital_disponible;
    }

    public void setCapital_disponible(BigDecimal capital_disponible) {
        this.capital_disponible = capital_disponible;
    }

    public BigDecimal getGanancia_total() {
        return ganancia_total;
    }

    public void setGanancia_total(BigDecimal ganancia_total) {
        this.ganancia_total = ganancia_total;
    }
}

