package ti.verdant.citiesapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import ti.verdant.citiesapi.cidades.Cidade;

public interface RepositorioCidade extends JpaRepository<Cidade, Long> {
}
