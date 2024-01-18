package com.ig.safemoney.service;

import com.ig.safemoney.model.Transaction;
import com.ig.safemoney.model.Usuario;
import com.ig.safemoney.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder pe;


    public Usuario createUser(Usuario usuario) {
//        usuario.setSenha(pe.encode(usuario.getSenha()));


        return usuarioRepository.save(usuario);
    }

}
