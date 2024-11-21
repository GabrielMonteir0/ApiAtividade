package Gabriel.atividade.atividadeApi.repository;

import Gabriel.atividade.atividadeApi.entity.PerfilUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

}
