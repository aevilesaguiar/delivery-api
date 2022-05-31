package com.aeviles.deliveryapi.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name ="restaurante")
@Table//(name ="restaurante")
public class Restaurante {


    @EqualsAndHashCode.Include //use apenas o id para o hashCode
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false)
    private String nome;

    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    //anotação de muitos para um(muitos restaurantes possuem uma cozinha)
    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false) //pra alterar o nome da coluna
    private Cozinha cozinha;


}
