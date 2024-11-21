package Gabriel.atividade.atividadeApi.repository;

import Gabriel.atividade.atividadeApi.entity.UsuarioVerificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


//tambem tinha erro no repository mas não se precisar o motivo
@Repository
public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long> {

    public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
