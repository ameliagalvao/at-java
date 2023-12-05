package org.example.crontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.UsuarioDTOInput;
import org.example.service.UsuarioService;

import static spark.Spark.*;

public class UsuarioController {
    private final UsuarioService usuarioService = new UsuarioService();
    private final ObjectMapper objectMapper = new ObjectMapper();
    public void respostaRequisicoes (){
        get("/usuarios", (request, response) -> {
            response.type("application/json");
            response.status(200);
            String json = objectMapper.writeValueAsString(usuarioService.listarUsuarios());
            return json;
        });

        get("/usuarios/:id", (request, response) -> {
            response.type("application/json");
            String idParam = request.params("id");
            Long id = Long.valueOf(idParam);
            String json = objectMapper.writeValueAsString(usuarioService.searchUsuario(Math.toIntExact(id)));
            response.status(200);
            return json;
        });

        delete("/usuarios/:id", (request, response) -> {
            response.type("application/json");
            String idParam = request.params("id");
            Long id = Long.valueOf(idParam);
            usuarioService.deleteUsuario(Math.toIntExact(id));
            response.status(200);
            return "Produto excluido com sucesso.";
        });

        post("/usuarios", (request, response) -> {
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(request.body(), UsuarioDTOInput.class);
            usuarioService.addNovoUsuario(usuarioDTOInput);
            response.type("application/json");
            response.status(201);
            return "Usuário inserido com sucesso.";
        });

        put("/usuarios", (request, response) -> {
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(request.body(), UsuarioDTOInput.class);
            usuarioService.changeUsuario(usuarioDTOInput);
            response.type("application/json");
            response.status(200);
            return "Usuario alterado com sucesso.";
        });
    }
}
