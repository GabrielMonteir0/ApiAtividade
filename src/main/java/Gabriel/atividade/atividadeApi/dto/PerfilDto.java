package Gabriel.atividade.atividadeApi.dto;

import Gabriel.atividade.atividadeApi.entity.PerfilEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDto {

    private Long id;
    private String descricao;

    public PerfilDto(PerfilEntity perfil) {
        BeanUtils.copyProperties(perfil, this);
    }
}
