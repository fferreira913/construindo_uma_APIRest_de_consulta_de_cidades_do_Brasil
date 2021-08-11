package ti.verdant.citiesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ti.verdant.citiesapi.paises.Pais;
import ti.verdant.citiesapi.repositorios.RepositorioPaises;
import java.util.List;

@RestController
@RequestMapping("/paises")
public class RecursoPais {

    //Inicializar o Repositorio
    //@Autowired
    private RepositorioPaises repositorio;

    /*Inicializando automaticamente*/
    public RecursoPais(RepositorioPaises repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Pais> paises(){
        return repositorio.findAll();
    }
}
