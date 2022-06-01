package com.aeviles.deliveryapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


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

    //@JsonIgnore
    @JsonProperty(value = "titulo")
    @Column( nullable = false)
    private String nome;


}
