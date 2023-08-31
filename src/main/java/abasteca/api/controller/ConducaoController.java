package abasteca.api.controller;

import abasteca.api.domain.conducao.Conducao;
import abasteca.api.domain.conducao.DadosAtualizacaoConducao;
import abasteca.api.domain.conducao.DadosCadastroConducao;
import abasteca.api.domain.conducao.DadosListagemConducao;
import abasteca.api.repository.ConducaoRepository;
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
@RequestMapping("conducao")
public class ConducaoController {
    @Autowired
    private ConducaoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConducao dados, UriComponentsBuilder uriBuilder) {
        var conducao = new Conducao(dados);
        repository.save(conducao);

        var uri = uriBuilder.path("/conducao/{id}").buildAndExpand(conducao.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemConducao(conducao));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConducao>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemConducao::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConducao dados) {
        var conducao = repository.getReferenceById(dados.id());
        conducao.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemConducao(conducao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var conducao = repository.getReferenceById(id);
        conducao.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var conducao = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemConducao(conducao));
    }

}
