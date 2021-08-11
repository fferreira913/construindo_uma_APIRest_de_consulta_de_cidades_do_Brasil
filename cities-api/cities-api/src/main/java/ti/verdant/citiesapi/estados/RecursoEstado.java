package ti.verdant.citiesapi.estados;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ti.verdant.citiesapi.repositorios.RepositorioEstado;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class RecursoEstado {

    private RepositorioEstado repositorioEstado;

    public RecursoEstado(RepositorioEstado repositorioEstado){
        this.repositorioEstado = repositorioEstado;
    }

    @GetMapping
    public List<Estado> listarEstados(){
        return repositorioEstado.findAll();
    }
}
