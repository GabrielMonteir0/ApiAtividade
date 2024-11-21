package Gabriel.atividade.atividadeApi.controller;

import Gabriel.atividade.atividadeApi.dto.UserDto;
import Gabriel.atividade.atividadeApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UserDto> listarTodos(){
        System.out.println("entrou no getUser");
        return usuarioService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody UserDto usuario) {
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UserDto alterar(@RequestBody UserDto usuario) {
        return usuarioService.alterar(usuario);
    }

    //http://endereco/usuario/3
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
