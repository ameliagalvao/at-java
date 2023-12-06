package org.example.service;

import org.example.dto.UsuarioDTOInput;
import org.example.dto.UsuarioDTOOutput;
import org.example.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class UsuarioService {
    private List<Usuario> listaUsuarios;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDTOOutput> listarUsuarios() {
        return modelMapper.map(listaUsuarios, new TypeToken<List<UsuarioDTOOutput>>() {}.getType());
    }

    public UsuarioDTOOutput searchUsuario(int id){
        //usar listaUsuarios, Usuario, UsuarioDTOOutput, ModelMapper.
        //todo
        return null;
    }

    public void addNovoUsuario(UsuarioDTOInput usuarioDTOInput){
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        listaUsuarios.add(usuario);
    }

    public void changeUsuario(UsuarioDTOInput usuarioDTOInput){
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        //todo
    }

    public void deleteUsuario(int id){
        for (int i = 0; i < listaUsuarios.size(); i++){
            Usuario usuario = listaUsuarios.get(i);
            if (usuario.getId() == id){
                listaUsuarios.remove(i);
                return;
            }
        }
    }
}
