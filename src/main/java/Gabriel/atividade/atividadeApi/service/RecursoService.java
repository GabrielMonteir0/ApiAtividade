package Gabriel.atividade.atividadeApi.service;

import Gabriel.atividade.atividadeApi.dto.RecursoDto;
import Gabriel.atividade.atividadeApi.entity.RecursoEntity;
import Gabriel.atividade.atividadeApi.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<RecursoDto> listarTodos(){
        List<RecursoEntity> recursos = recursoRepository.findAll();
        return recursos.stream().map(RecursoDto::new).toList();
    }

    public void inserir(RecursoDto recurso) {
        RecursoEntity recursoEntity = new RecursoEntity();
        recursoRepository.save(recursoEntity);
    }

    public RecursoDto alterar(RecursoDto recurso) {
        RecursoEntity recursoEntity = new RecursoEntity();
        return new RecursoDto(recursoRepository.save(recursoEntity));
    }

    public void excluir(Long id) {
        RecursoEntity recurso = recursoRepository.findById(id).get();
        recursoRepository.delete(recurso);
    }

    public RecursoDto buscarPorId(Long id) {
        return new RecursoDto(recursoRepository.findById(id).get());
    }
}
