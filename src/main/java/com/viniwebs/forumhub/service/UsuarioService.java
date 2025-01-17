package com.viniwebs.forumhub.service;

import com.viniwebs.forumhub.model.Usuario;
import com.viniwebs.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        Usuario newUsuario = new Usuario(usuario.getEmail(), hashedPassword);
        try {
            usuarioRepository.save(newUsuario);
        } catch (Exception e) {
            // Registrar a exceção e relançar se necessário
            throw new RuntimeException("Erro ao salvar o usuário", e);
        }
    }
}
