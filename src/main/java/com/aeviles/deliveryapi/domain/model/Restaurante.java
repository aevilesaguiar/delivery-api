package com.aeviles.deliveryapi.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Restaurante {


    @EqualsAndHashCode.Include //use apenas o id para o hashCode
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    //anotação de muitos para um(muitos restaurantes possuem uma cozinha)
    @ManyToOne
    private Cozinha cozinha;


}
