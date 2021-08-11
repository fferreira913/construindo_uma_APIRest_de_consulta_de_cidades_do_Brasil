package ti.verdant.citiesapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import ti.verdant.citiesapi.paises.Pais;

public interface RepositorioPaises extends JpaRepository<Pais, Long> {

}
