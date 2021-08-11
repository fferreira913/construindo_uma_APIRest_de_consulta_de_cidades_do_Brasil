package ti.verdant.citiesapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import ti.verdant.citiesapi.estados.Estado;

public interface RepositorioEstado extends JpaRepository<Estado, Long> {

}
