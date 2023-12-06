package org.example.service;

import org.example.dto.UsuarioDTOInput;
import org.example.dto.UsuarioDTOOutput;
import org.example.model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.List;

public class UsuarioService {
    private List<Usuario> listaUsuarios;

    public List<UsuarioDTOOutput> listarUsuarios(){
        modelMapper
        return null;
    }

    public UsuarioDTOOutput searchUsuario(int id){
        //usar listaUsuarios, Usuario, UsuarioDTOOutput, ModelMapper.
        return null;
    }

    public void addNovoUsuario(UsuarioDTOInput usuario){
    }

    public void changeUsuario(UsuarioDTOInput usuario){
        //usar ModelMapper e listaUsuarios
    }

    public void deleteUsuario(int id){
     //usar listaUsuarios e Usuario
    }
}
