package com.viniwebs.forumhub.controllers;

import com.viniwebs.forumhub.model.DadosAutenticacao;
import com.viniwebs.forumhub.model.Usuario;
import com.viniwebs.forumhub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> register(@RequestBody DadosAutenticacao dadosAutenticacao) {
     Usuario user = new Usuario(dadosAutenticacao.email(), dadosAutenticacao.senha());
     usuarioService.save(user);
     return ResponseEntity.ok().body(user);
    }
}
