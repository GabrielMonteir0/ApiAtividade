package Gabriel.atividade.atividadeApi.entity;

import Gabriel.atividade.atividadeApi.dto.RecursoDto;
import Gabriel.atividade.atividadeApi.dto.RecursoDto;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Entity
public class RecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String chave;

    public RecursoEntity() {

    }

    public RecursoEntity(RecursoDto recurso) {
        BeanUtils.copyProperties(recurso, this);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RecursoEntity other = (RecursoEntity) obj;
        return Objects.equals(id, other.id);
    }
}