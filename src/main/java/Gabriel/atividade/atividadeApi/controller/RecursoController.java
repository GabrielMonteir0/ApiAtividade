package Gabriel.atividade.atividadeApi.controller;

import Gabriel.atividade.atividadeApi.dto.RecursoDto;
import Gabriel.atividade.atividadeApi.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recurso")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<RecursoDto> listarTodos(){
        System.out.println("entrou no controler");
        return recursoService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody RecursoDto recurso) {
        recursoService.inserir(recurso);
    }

    @PutMapping
    public RecursoDto alterar(@RequestBody RecursoDto recurso) {
        return recursoService.alterar(recurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        recursoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
