package ti.verdant.citiesapi.cidades.distancias;


import org.springframework.data.geo.Point;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ti.verdant.citiesapi.cidades.Cidade;
import ti.verdant.citiesapi.repositorios.RepositorioCidade;

@Service
public class DistanciaServico {

    private RepositorioCidade repositorioCidade;
    Logger log = LoggerFactory.getLogger(DistanciaServico.class);

    public DistanciaServico(final RepositorioCidade repositorioCidade) {

        this.repositorioCidade = repositorioCidade;
    }

    /**
     * 1st option
     *
     * @param cidade1
     * @param cidade2
     * @param raioDaTerra
     * @return
     */
    public Double distanceUsingMath(final Long cidade1, final Long cidade2, final RaioDaTerra raioDaTerra) {
        log.info("distanceUsingMath({}, {}, {})", cidade1, cidade2, raioDaTerra);
        final List<Cidade> cidadeList = repositorioCidade.findAllById((Arrays.asList(cidade1, cidade2)));

        final Double[] localizacao1 = StringDeLocalizacao.transforma(cidadeList.get(0).getGeolocalizacao());
        final Double[] localizacao2 = StringDeLocalizacao.transforma(cidadeList.get(1).getGeolocalizacao());

        return doCalculation(localizacao1[0], localizacao1[1], localizacao2[0], localizacao2[1], raioDaTerra);
    }

    /**
     * 2nd option
     *
     * @param cidade1
     * @param cidade2
     * @return
     */
    public Double distanceByPointsInMiles(final Long cidade1, final Long cidade2) {
        log.info("nativePostgresInMiles({}, {})", cidade1, cidade2);
        return repositorioCidade.distanciaEntrePontos(cidade1, cidade2);
    }

    /**
     * 3rd option
     *
     * @param cidade1
     * @param cidade1
     * @param raioDaTerra
     * @return
     */
    public Double distanceUsingPoints(final Long cidade1, final Long cidade2, final RaioDaTerra raioDaTerra) {
        log.info("distanceUsingPoints({}, {}, {})", cidade1, cidade2, raioDaTerra);
        final List<Cidade> cidadeList = repositorioCidade.findAllById((Arrays.asList(cidade1, cidade2)));

        Point p1 = cidadeList.get(0).getLat_lon();
        Point p2 = cidadeList.get(1).getLat_lon();

        return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), raioDaTerra);
    }

    /**
     * 4th option
     *
     * @param cidade1
     * @param cidade2
     * @return
     */
    public Double distanceByCubeInMeters(Long cidade1, Long cidade2) {
        log.info("distanceByCubeInMeters({}, {})", cidade1, cidade2);
        final List<Cidade> cidadeList = repositorioCidade.findAllById((Arrays.asList(cidade1, cidade2)));

        Point p1 = cidadeList.get(0).getLat_lon();
        Point p2 = cidadeList.get(1).getLat_lon();

        return repositorioCidade.distanciaPorCubos(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    private double doCalculation(final double lat1, final double lon1, final double lat2,
                                 final double lng2, final RaioDaTerra raioDaTerra) {
        double lat = toRadians(lat2 - lat1);
        double lon = toRadians(lng2 - lon1);
        double a = sin(lat / 2) * sin(lat / 2) + cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return raioDaTerra.getValor() * c;
    }
}