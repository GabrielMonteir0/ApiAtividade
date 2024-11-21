package Gabriel.atividade.atividadeApi.controller;

import Gabriel.atividade.atividadeApi.dto.PerfilDto;
import Gabriel.atividade.atividadeApi.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilDto> listarTodos(){
        System.out.println("entrou no controler");
        return perfilService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody PerfilDto perfil) {
        perfilService.inserir(perfil);
    }

    @PutMapping
    public PerfilDto alterar(@RequestBody PerfilDto perfil) {
        return perfilService.alterar(perfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        perfilService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
