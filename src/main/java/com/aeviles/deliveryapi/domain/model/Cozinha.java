package com.aeviles.deliveryapi.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "cozinha")
@Table //(name = "cozinha")
public class Cozinha {

    @EqualsAndHashCode.Include
    @Id /*esse atributo vai representar o identificador da chave cozinha, ou seja primary key */
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column //(name = "nom_cozinha")
    private String nome;


}
