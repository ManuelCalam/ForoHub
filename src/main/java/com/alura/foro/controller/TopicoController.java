package com.alura.foro.controller;

import com.alura.foro.domain.Topico;
import com.alura.foro.dto.DatosActualizarTopico;
import com.alura.foro.dto.DatosListadoTopico;
import com.alura.foro.dto.DatosRegistroTopico;
import com.alura.foro.repository.TopicoRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos){

        if(repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())){
            throw new RuntimeException("Tópico duplicado");
        }

        repository.save(new Topico(datos));
    }

    @GetMapping
    public List<DatosListadoTopico> listarTopicos() {
        return repository.findAll()
                .stream()
                .map(DatosListadoTopico::new)
                .toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity datosTopico(@PathVariable Long id) {

        Optional<Topico> topico = repository.findById(id);

        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable Long id,
                                           @RequestBody DatosActualizarTopico datos) {
        Optional<Topico> topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();

            topico.setTitulo(datos.titulo());
            topico.setMensaje(datos.mensaje());

            repository.save(topico);

            return ResponseEntity.ok(topico);
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}