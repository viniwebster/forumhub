package com.viniwebs.forumhub.service;

import com.viniwebs.forumhub.model.Topico;
import com.viniwebs.forumhub.model.TopicoDTO;
import com.viniwebs.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public List<TopicoDTO> findAll() {
        return topicoRepository.findAll().stream()
                .map(TopicoDTO::new)
                .collect(Collectors.toList());
    }

    public Topico findById(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }

    public Topico save(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico update(TopicoDTO topico, Long id) {
        Topico entity = findById(id);
        entity.setMensagem(topico.mensagem());
        entity.setTitulo(topico.titulo());
        return topicoRepository.save(entity);
    }

    public void deleteById(Long id) {
        topicoRepository.deleteById(id);
    }
}
