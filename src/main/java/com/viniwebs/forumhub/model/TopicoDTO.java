package com.viniwebs.forumhub.model;

public record TopicoDTO(Long id, String titulo, String mensagem) {
    public TopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem());
    }
}
