package espe.edu.ec.prueba.Repository;

import espe.edu.ec.prueba.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

    Usuario findByEmail(String email);
}
