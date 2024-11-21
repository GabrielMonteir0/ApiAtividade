package Gabriel.atividade.atividadeApi.repository;

import Gabriel.atividade.atividadeApi.entity.PermissaoPerfilRecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoPerfilRecursoRepository extends JpaRepository<PermissaoPerfilRecursoEntity, Long> {

}