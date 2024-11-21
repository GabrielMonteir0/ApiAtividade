package Gabriel.atividade.atividadeApi.entity;

import Gabriel.atividade.atividadeApi.dto.PermissaoPerfilRecursoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissaoPerfilRecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "ID_RECURSO")
    private RecursoEntity recurso;

    public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
        BeanUtils.copyProperties(permissaoPerfilRecurso, this);
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
            this.recurso = new RecursoEntity(permissaoPerfilRecurso.getRecurso());
        }
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
            this.perfil = new PerfilEntity(permissaoPerfilRecurso.getPerfil());
        }
    }
}
