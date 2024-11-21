package Gabriel.atividade.atividadeApi.controller;

import Gabriel.atividade.atividadeApi.dto.AuthenticationDto;
import Gabriel.atividade.atividadeApi.dto.UserDto;
import Gabriel.atividade.atividadeApi.service.AuthService;
import Gabriel.atividade.atividadeApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDto authDto){
        return ResponseEntity.ok(authService.login(authDto));
    }

    @PostMapping(value = "/novoUsuario")
    public void inserirNovoUsuario(@RequestBody UserDto novoUsuario){
        usuarioService.inserirNovoUsuario(novoUsuario);
    }

    @GetMapping(value = "/verificarCadastro/{uuid}")
    public String verificarCadastro(@PathVariable("uuid") String uuid) {
        System.out.println("entrou no controler");
        return usuarioService.verificarCadastro(uuid);
    }

}
