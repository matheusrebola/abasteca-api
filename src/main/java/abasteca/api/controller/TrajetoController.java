package abasteca.api.controller;

import abasteca.api.domain.trajeto.DadosAtualizacaoTrajeto;
import abasteca.api.domain.trajeto.DadosCadastroTrajeto;
import abasteca.api.domain.trajeto.DadosListagemTrajeto;
import abasteca.api.domain.trajeto.Trajeto;
import abasteca.api.repository.TrajetoRepository;
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
@RequestMapping("trajetos")
public class TrajetoController {
    @Autowired
    private TrajetoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTrajeto dados, UriComponentsBuilder uriBuilder) {
        var trajeto = new Trajeto(dados);
        repository.save(trajeto);

        var uri = uriBuilder.path("/trajetos/{id}").buildAndExpand(trajeto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemTrajeto(trajeto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTrajeto>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTrajeto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTrajeto dados) {
        var trajeto = repository.getReferenceById(dados.id());
        trajeto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemTrajeto(trajeto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var trajeto = repository.getReferenceById(id);
        trajeto.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var trajeto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemTrajeto(trajeto));
    }
}
