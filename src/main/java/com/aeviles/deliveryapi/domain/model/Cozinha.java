package com.aeviles.deliveryapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "cozinha")
@Table //(name = "cozinha")
public class Cozinha {

    @Id /*esse atributo vai representar o identificador da chave cozinha, ou seja primary key */
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column //(name = "nom_cozinha")
    private String nome;


}
