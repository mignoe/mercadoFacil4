package com.ufcg.psoft.mercadofacil.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carrinhos")
public class Carrinho {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("cliente")
    @MapsId
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Cliente cliente;

    @JsonProperty("lotes")
    @ManyToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private Set<Lote> lote;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
