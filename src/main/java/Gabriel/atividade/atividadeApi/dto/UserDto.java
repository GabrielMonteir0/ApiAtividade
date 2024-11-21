package Gabriel.atividade.atividadeApi.dto;

import Gabriel.atividade.atividadeApi.entity.UsuarioEntity;
import Gabriel.atividade.atividadeApi.entity.enums.TipoSituacaoUsuario;
import org.springframework.beans.BeanUtils;

public class UserDto {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String Cpf;
    private TipoSituacaoUsuario situacao;

    public UserDto(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
        System.out.println("entrou no dto");
    }

    public UserDto() {

    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public TipoSituacaoUsuario getSituacao() {
        return situacao;
    }

    public void setSituacao(TipoSituacaoUsuario situacao) {
        this.situacao = situacao;
    }

}