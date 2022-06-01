package com.aeviles.deliveryapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "cozinha")
public class CozinhaXmlWrapper {

    @JsonProperty("cozinhas1")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NonNull //gera os construtores
    private List<Cozinha> cozinhas;



}
