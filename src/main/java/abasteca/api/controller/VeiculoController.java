package abasteca.api.controller;

import abasteca.api.domain.veiculo.DadosAtualizacaoVeiculo;
import abasteca.api.domain.veiculo.DadosCadastroVeiculo;
import abasteca.api.domain.veiculo.DadosListagemVeiculo;
import abasteca.api.domain.veiculo.Veiculo;
import abasteca.api.repository.VeiculoRepository;
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
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVeiculo dados, UriComponentsBuilder uriBuilder) {
        var veiculo = new Veiculo(dados);
        repository.save(veiculo);

        var uri = uriBuilder.path("/veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemVeiculo(veiculo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemVeiculo>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemVeiculo::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoVeiculo dados) {
        var veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemVeiculo(veiculo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var veiculo = repository.getReferenceById(id);
        veiculo.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var veiculo = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemVeiculo(veiculo));
    }
}
