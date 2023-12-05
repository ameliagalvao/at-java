package org.example.service;

import org.example.dto.UsuarioDTOInput;
import org.example.dto.UsuarioDTOOutput;
import org.example.model.Usuario;

import java.util.List;

public class UsuarioService {
    private List<Usuario> listaUsuarios;

    public List<UsuarioDTOOutput> listarUsuarios(){
        //usar listaUsuarios e ModelMapper
        return null;
    }

    public UsuarioDTOOutput searchUsuario(int id){
        //usar listaUsuarios, Usuario, UsuarioDTOOutput, ModelMapper.
        return null;
    }

    public void addNovoUsuario(UsuarioDTOInput usuario){
      //usar ModelMapper e listaUsuarios
        try{

        }catch{

        }
    }

    public void changeUsuario(UsuarioDTOInput usuario){
        //usar ModelMapper e listaUsuarios
        try{

        }catch{

        }
    }

    public void deleteUsuario(int id){
     //usar listaUsuarios e Usuario
        try{

        }catch{

        }
    }
}
