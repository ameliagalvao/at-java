package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDTOInput {
    private int id;
    private String nome;
    private String senha;
}
