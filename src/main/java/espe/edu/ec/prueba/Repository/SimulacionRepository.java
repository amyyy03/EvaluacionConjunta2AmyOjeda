package espe.edu.ec.prueba.Repository;

import espe.edu.ec.prueba.entities.Simulacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SimulacionRepository extends JpaRepository<Simulacion, UUID> {
    // Consulta para obtener simulaciones por usuarioId
    List<Simulacion> findByUsuarioId(UUID usuarioId);
}
