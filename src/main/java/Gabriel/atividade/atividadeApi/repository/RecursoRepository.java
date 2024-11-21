package Gabriel.atividade.atividadeApi.repository;

import Gabriel.atividade.atividadeApi.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

}
