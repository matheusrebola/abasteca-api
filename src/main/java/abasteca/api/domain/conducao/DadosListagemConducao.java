package abasteca.api.domain.conducao;

public record DadosListagemConducao(
        Long id,
        Avatar avatar,
        EstiloDirecao estiloDirecao
){
    public DadosListagemConducao(Conducao conducao){
        this(conducao.getId(), conducao.getAvatar(), conducao.getEstiloDirecao());
    }
}