package com.github.raphaelpalhano.DIO.CitiesDistance.countries;

import com.github.raphaelpalhano.DIO.CitiesDistance.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryRepository repository;

    public CountryResource(final CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page) {

        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);
        //existem algo dentro do corpo optional, se sim, retorna 200 == ok
        if(optional.isPresent()){
            //retornando uma resposta da entidade (objeto pais), com metodo ok e definição do corpo da resposta
            return ResponseEntity.ok().body(optional.get());
        }
        //se nao tiver nada dentro da variavel optinal retorna notfound...
        else{
            return ResponseEntity.notFound().build();
        }

    }

}