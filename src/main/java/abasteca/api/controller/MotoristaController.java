package abasteca.api.controller;

import abasteca.api.domain.motorista.DadosAtualizacaoMotorista;
import abasteca.api.domain.motorista.DadosCadastroMotorista;
import abasteca.api.domain.motorista.DadosListagemMotorista;
import abasteca.api.domain.motorista.Motorista;
import abasteca.api.repository.MotoristaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMotorista dados, UriComponentsBuilder uriBuilder) {
        var motorista = new Motorista(dados);
        repository.save(motorista);

        var uri = uriBuilder.path("/motoristas/{id}").buildAndExpand(motorista.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemMotorista(motorista));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMotorista>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMotorista::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMotorista dados) {
        var motorista = repository.getReferenceById(dados.id());
        motorista.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemMotorista(motorista));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var motorista = repository.getReferenceById(id);
        motorista.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var motorista = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemMotorista(motorista));
    }
}
