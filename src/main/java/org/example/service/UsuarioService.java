package org.example.service;

import org.example.dto.UsuarioDTOInput;
import org.example.dto.UsuarioDTOOutput;
import org.example.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.*;

public class UsuarioService {
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private final ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDTOOutput> listarUsuarios() {
        return modelMapper.map(listaUsuarios, new TypeToken<List<UsuarioDTOOutput>>() {}.getType());
    }

    public UsuarioDTOOutput searchUsuario(int id) throws Exception {
        for (int i = 0; i < listaUsuarios.size(); i++){
            Usuario usuario = listaUsuarios.get(i);
            if (usuario.getId() == id){
                return modelMapper.map(usuario, UsuarioDTOOutput.class);
            }
        } throw new Exception("Usuário não encontrado.");
    }

    public void addNovoUsuario(UsuarioDTOInput usuarioDTOInput){
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        listaUsuarios.add(usuario);
    }

    public void changeUsuario(UsuarioDTOInput usuarioDTOInput){
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        for (int i = 0; i < listaUsuarios.size(); i++){
            Usuario usuarioDaLista = listaUsuarios.get(i);
            if (usuarioDaLista.getId() == usuario.getId()){
                listaUsuarios.set(i, usuario);
                return;
            }
        }
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
