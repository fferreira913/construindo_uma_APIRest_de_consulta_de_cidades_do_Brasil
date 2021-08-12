package ti.verdant.citiesapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ti.verdant.citiesapi.cidades.Cidade;

public interface RepositorioCidade extends JpaRepository<Cidade, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distancia", nativeQuery = true)
    Double distanciaEntrePontos(Long cidade1, Long cidade2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distancia", nativeQuery = true)
    Double distanciaPorCubos(double x, double y, double x1, double y1);
}
