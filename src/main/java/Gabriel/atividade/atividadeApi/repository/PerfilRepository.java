package Gabriel.atividade.atividadeApi.repository;

import Gabriel.atividade.atividadeApi.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

}
