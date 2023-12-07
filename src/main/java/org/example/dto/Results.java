package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public
class Results {
    public List<UsuarioDTOInput> results = new ArrayList<>();
}
