package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTOInput {
    @JsonProperty("uuid")
    private int id;
    @JsonProperty("username")
    private String nome;
    @JsonProperty("password")
    private String senha;
}

