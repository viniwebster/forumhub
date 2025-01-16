package com.viniwebs.forumhub.controllers;

import com.viniwebs.forumhub.model.Topico;
import com.viniwebs.forumhub.model.TopicoDTO;
import com.viniwebs.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<List<TopicoDTO>> getAll() {
        List<TopicoDTO> topicos = topicoService.findAll();
        return ResponseEntity.ok().body(topicos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicoDTO> getById(@PathVariable Long id) {
        Topico topico = topicoService.findById(id);
        if (topico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new TopicoDTO(topico));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TopicoDTO> update(@PathVariable Long id, @RequestBody TopicoDTO topico) {
        Topico update = topicoService.update(topico, id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(update.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(update));
    }


    @PostMapping
    public ResponseEntity<TopicoDTO> create(@RequestBody TopicoDTO topico) {
        Topico novoTopico = new Topico(topico);
        topicoService.save(novoTopico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(topico).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(novoTopico));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Topico topico = topicoService.findById(id);
        if (topico != null) {
            topicoService.deleteById(topico.getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
