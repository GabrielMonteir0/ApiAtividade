package Gabriel.atividade.atividadeApi.dto;

import Gabriel.atividade.atividadeApi.entity.PerfilUsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioDTO {

    private Long id;
    private UserDto usuario;
    private PerfilDto perfil;

    public PerfilUsuarioDTO(PerfilUsuarioEntity perfilUsuario) {
        BeanUtils.copyProperties(perfilUsuario, this);
        if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
            this.usuario = new UserDto(perfilUsuario.getUsuario());
        }
        if(perfilUsuario != null && perfilUsuario.getPerfil() != null) {
            this.perfil = new PerfilDto(perfilUsuario.getPerfil());
        }
    }

}
