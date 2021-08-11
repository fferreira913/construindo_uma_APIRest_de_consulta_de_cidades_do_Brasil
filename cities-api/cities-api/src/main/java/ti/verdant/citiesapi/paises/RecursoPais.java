package ti.verdant.citiesapi.paises;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ti.verdant.citiesapi.repositorios.RepositorioPaises;

import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class RecursoPais {

    //Inicializar o Repositorio com anotação
    //@Autowired
    private RepositorioPaises repositorio;

    /*Inicializando automaticamente*/
    public RecursoPais(RepositorioPaises repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public Page<Pais> paises(Pageable pageable){

        return repositorio.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPais(@PathVariable long id){
        Optional<Pais> optional = repositorio.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
