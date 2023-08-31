package abasteca.api.controller;

import abasteca.api.domain.conducao.DadosListagemConducao;
import abasteca.api.domain.consumo.Consumo;
import abasteca.api.domain.consumo.DadosAtualizacaoConsumo;
import abasteca.api.domain.consumo.DadosCadastroConsumo;
import abasteca.api.domain.consumo.DadosListagemConsumo;
import abasteca.api.repository.ConsumoRepository;
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
@RequestMapping("consumos")
public class ConsumoController {
    @Autowired
    private ConsumoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConsumo dados, UriComponentsBuilder uriBuilder) {
        var consumo = new Consumo(dados);
        repository.save(consumo);

        var uri = uriBuilder.path("/consumos/{id}").buildAndExpand(consumo.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemConsumo(consumo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConsumo>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemConsumo::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConsumo dados) {
        var consumo = repository.getReferenceById(dados.id());
        consumo.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemConsumo(consumo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var consumo = repository.getReferenceById(id);
        consumo.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var consumo = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemConsumo(consumo));
    }
}
