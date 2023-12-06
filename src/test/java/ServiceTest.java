import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.UsuarioDTOInput;
import org.example.service.UsuarioService;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    public void testarAddUsuario(){
        UsuarioDTOInput usuarioDTOInput = new UsuarioDTOInput();
        usuarioService.addNovoUsuario(usuarioDTOInput);
        int tamanho = usuarioService.listarUsuarios().size();
        Assert.assertEquals(1, tamanho);
    }

    @Test
    public void testarListarUsuarios() throws IOException {
        URL urlObj = new URL("https://randomuser.me/api/");
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        Assert.assertEquals(200, responseCode);
    }

    @Test
    public void testarAddUsuarioComHttpUrlConnection() throws IOException {
        URL urlObj = new URL("https://randomuser.me/api/");
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        UsuarioDTOInput usuarioDTOInput;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            usuarioDTOInput = objectMapper.readValue(response.toString(), UsuarioDTOInput.class);

            usuarioService.addNovoUsuario(usuarioDTOInput);
            int tamanho = usuarioService.listarUsuarios().size();
            Assert.assertEquals(1, tamanho);
        }
    }
}
