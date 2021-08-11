package ti.verdant.citiesapi.estados;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ti.verdant.citiesapi.repositorios.RepositorioEstado;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity buscarEstado(@PathVariable long id){
        Optional<Estado> optional = repositorioEstado.findById(id);

        if(optional.isPresent()){
            return  ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
