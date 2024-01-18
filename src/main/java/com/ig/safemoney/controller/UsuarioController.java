package com.ig.safemoney.controller;

import com.ig.safemoney.model.Transaction;
import com.ig.safemoney.model.Usuario;
import com.ig.safemoney.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        final Usuario userCreated = usuarioService.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

//    @PostMapping()
//    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
//        final Transaction transactionCreated = transactionService.createTransaction(transaction);
//        logger.info(NEW_TRANSACTION_LOG, transactionCreated.toString());
//        return ResponseEntity.status(HttpStatus.CREATED).body(transactionCreated);
//    }
}
