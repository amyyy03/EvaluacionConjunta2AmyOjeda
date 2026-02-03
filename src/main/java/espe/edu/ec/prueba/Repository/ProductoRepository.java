package espe.edu.ec.prueba.Repository;

import espe.edu.ec.prueba.entities.ProductoFinanciero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductoRepository extends JpaRepository<ProductoFinanciero, UUID> {


}
