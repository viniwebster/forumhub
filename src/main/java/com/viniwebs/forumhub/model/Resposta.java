package com.viniwebs.forumhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "db_respostas")
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private Date dataCriacao;
    private String autor;
    private String solucao;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Resposta() {}
}
