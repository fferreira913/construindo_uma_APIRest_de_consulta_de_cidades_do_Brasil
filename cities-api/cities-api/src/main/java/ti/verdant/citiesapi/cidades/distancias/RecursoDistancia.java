package ti.verdant.citiesapi.cidades.distancias;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distancias")
public class RecursoDistancia {

    Logger log = LoggerFactory.getLogger(RecursoDistancia.class);

    private final DistanciaServico distanciaServico;

    public RecursoDistancia(DistanciaServico distanciaServico) {

        this.distanciaServico = distanciaServico;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long cidade1,
                                   @RequestParam(name = "to") final Long cidade2) {
        log.info("byPoints");

        return ResponseEntity.ok().body(
                distanciaServico.distanceByPointsInMiles(cidade1, cidade2)
        );
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long cidade1,
                         @RequestParam(name = "to") final Long cidade2) {
        log.info("byCube");
        return ResponseEntity.ok().body(
                distanciaServico.distanceByCubeInMeters(cidade1, cidade2)
        );
    }

    @GetMapping("/by-math")
    public ResponseEntity byMath(@RequestParam(name = "from") final Long cidade1,
                         @RequestParam(name = "to") final Long cidade2,
                         @RequestParam final RaioDaTerra raioDaTerra) {
        log.info("byMath");
        return ResponseEntity.ok().body(
                distanciaServico.distanceUsingMath(cidade1, cidade2, raioDaTerra)
        );
    }
}
