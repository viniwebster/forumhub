package com.viniwebs.forumhub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_perfil")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Usuario usuario;

    public Perfil(){}
}
