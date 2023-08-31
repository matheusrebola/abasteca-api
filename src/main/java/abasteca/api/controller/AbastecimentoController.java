package abasteca.api.controller;

import abasteca.api.domain.abastecimento.Abastecimento;
import abasteca.api.domain.abastecimento.DadosAtualizacaoAbastecimento;
import abasteca.api.domain.abastecimento.DadosCadastroAbastecimento;
import abasteca.api.domain.abastecimento.DadosListagemAbastecimento;
import abasteca.api.repository.AbastecimentoRepository;
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
@RequestMapping("abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbastecimento dados, UriComponentsBuilder uriBuilder) {
        var abastecimento = new Abastecimento(dados);
        repository.save(abastecimento);

        var uri = uriBuilder.path("/abastecimento/{id}").buildAndExpand(abastecimento.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemAbastecimento(abastecimento));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAbastecimento>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAbastecimento::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAbastecimento dados) {
        var abastecimento = repository.getReferenceById(dados.id());
        abastecimento.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemAbastecimento(abastecimento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var abastecimento = repository.getReferenceById(id);
        abastecimento.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var abastecimento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemAbastecimento(abastecimento));
    }

}
