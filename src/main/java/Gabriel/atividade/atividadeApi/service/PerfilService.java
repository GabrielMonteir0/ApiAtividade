package Gabriel.atividade.atividadeApi.service;

import Gabriel.atividade.atividadeApi.dto.PerfilDto;
import Gabriel.atividade.atividadeApi.dto.PerfilDto;
import Gabriel.atividade.atividadeApi.entity.PerfilEntity;
import Gabriel.atividade.atividadeApi.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilDto> listarTodos(){
        List<PerfilEntity> perfis = perfilRepository.findAll();
        return perfis.stream().map(PerfilDto::new).toList();
    }

    public void inserir(PerfilDto perfil) {
        PerfilEntity perfilEntity = new PerfilEntity();
        perfilRepository.save(perfilEntity);
    }

    public PerfilDto alterar(PerfilDto perfil) {
        PerfilEntity perfilEntity = new PerfilEntity();
        return new PerfilDto(perfilRepository.save(perfilEntity));
    }

    public void excluir(Long id) {
        PerfilEntity perfil = perfilRepository.findById(id).get();
        perfilRepository.delete(perfil);
    }

    public PerfilDto buscarPorId(Long id) {
        return new PerfilDto(perfilRepository.findById(id).get());
    }
}
