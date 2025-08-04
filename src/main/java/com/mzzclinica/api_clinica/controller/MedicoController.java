package com.mzzclinica.api_clinica.controller;



import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mzzclinica.api_clinica.medico.DadosMedico;
import com.mzzclinica.api_clinica.medico.Medico;
import com.mzzclinica.api_clinica.repository.MedicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    @Autowired
    private final MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosMedico dadosMedico, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dadosMedico);
        repository.save(medico);
        
        repository.save(new Medico(dadosMedico));

        var uri = uriBuilder.path("/medicos/{id}")
                .buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

        return ResponseEntity.ok(page);
    }
    
    @PutMapping()
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosAtualizacaoMedico dadosMedico) {
       var medico = repository.getReferenceById(dadosMedico.id());
       medico.atualizarInformacoes(dadosMedico);

       return ResponseEntity.ok(new DetalhamentoMedico(medico));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoMedico> detalharMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoMedico(medico));
    }
}
