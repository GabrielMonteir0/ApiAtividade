package Gabriel.atividade.atividadeApi.dto;

import Gabriel.atividade.atividadeApi.entity.PermissaoPerfilRecursoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDTO {

    private Long id;
    private PerfilDto perfil;
    private RecursoDto recurso;

    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
        BeanUtils.copyProperties(permissaoPerfilRecurso, this);
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
            this.recurso = new RecursoDto(permissaoPerfilRecurso.getRecurso());
        }
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
            this.perfil = new PerfilDto(permissaoPerfilRecurso.getPerfil());
        }
    }
}