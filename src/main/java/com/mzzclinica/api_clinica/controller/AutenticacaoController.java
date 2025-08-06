package com.mzzclinica.api_clinica.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzzclinica.api_clinica.domain.usuario.DadosAutenticacao;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticacaoController {
    
    
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity efetuarLongin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var authentication =  authenticationManager.authenticate(token);

        return ResponseEntity.ok(authentication);
    }

}
