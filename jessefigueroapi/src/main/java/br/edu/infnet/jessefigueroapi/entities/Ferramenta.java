package br.edu.infnet.jessefigueroapi.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Ferramenta {

    private Integer id;
    private String nome;
    private String tipo;
    private String fabricante;
    private Double preco;
    private String numeroSerie;
    private LocalDateTime dataAquisicao;
    private Boolean disponivel;
    private String descricao;

    public Ferramenta() {
        this.dataAquisicao = LocalDateTime.now();
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return String.format(
                "%3d | Nome: %-30s | Tipo: %-15s | Fabricante: %-15s | Preço: R$ %7.2f | Série: %-12s | Disponível: %-3s",
                id,
                nome,
                tipo,
                fabricante,
                preco,
                numeroSerie,
                disponivel ? "Sim" : "Não"
        );
    }
}