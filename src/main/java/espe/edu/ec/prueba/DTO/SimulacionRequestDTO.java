package espe.edu.ec.prueba.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class SimulacionRequestDTO {
    private UUID usuarioId;
    private BigDecimal capitalDisponible;
    private List<ProductoDTO> productos;

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public BigDecimal getCapitalDisponible() {
        return capitalDisponible;
    }

    public void setCapitalDisponible(BigDecimal capitalDisponible) {
        this.capitalDisponible = capitalDisponible;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
}
