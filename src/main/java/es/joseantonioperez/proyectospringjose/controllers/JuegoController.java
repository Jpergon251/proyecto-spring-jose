package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.models.Juego;
import es.joseantonioperez.proyectospringjose.repositories.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class JuegoController {
    @Autowired
    JuegoRepository juegoRepository;
    @GetMapping("/juego/")
    public ResponseEntity<Object> index() {return new ResponseEntity<>(juegoRepository.findAll(),HttpStatus.OK);}

    @GetMapping("/juego/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(juegoRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/juego/create")
    public ResponseEntity<Object> create(@RequestBody Juego juego) {
        juegoRepository.save(juego);
        return new ResponseEntity<>(juego, HttpStatus.OK);
    }

    @DeleteMapping("/juego/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Juego> juego = juegoRepository.findById(id);
        juego.ifPresent(value -> juegoRepository.delete(value));
        return new ResponseEntity<>(juego.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/juego/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Juego juego) {
        Optional<Juego> oldJuego = juegoRepository.findById(id);
        if(oldJuego.isPresent()) {
            juego.setId(id);
            juegoRepository.save(juego);
            return new ResponseEntity<>(juego, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
