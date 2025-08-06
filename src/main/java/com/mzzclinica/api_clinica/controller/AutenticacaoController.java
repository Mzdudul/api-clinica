package com.mzzclinica.api_clinica.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzzclinica.api_clinica.domain.usuario.DadosAutenticacao;
import com.mzzclinica.api_clinica.domain.usuario.Usuario;
import com.mzzclinica.api_clinica.infra.security.DadosTokenJWT;
import com.mzzclinica.api_clinica.infra.security.TokenService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticacaoController {
    
    
    private final AuthenticationManager authenticationManager;

private final TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLongin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var authentication =  authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }



}
