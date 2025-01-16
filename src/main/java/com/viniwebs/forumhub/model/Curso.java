package com.viniwebs.forumhub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_curso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;

    public Curso(){}
}
