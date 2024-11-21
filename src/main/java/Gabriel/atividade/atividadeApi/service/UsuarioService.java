package Gabriel.atividade.atividadeApi.service;

import Gabriel.atividade.atividadeApi.dto.UserDto;
import Gabriel.atividade.atividadeApi.entity.UsuarioEntity;
import Gabriel.atividade.atividadeApi.entity.UsuarioVerificadorEntity;
import Gabriel.atividade.atividadeApi.entity.enums.TipoSituacaoUsuario;
import Gabriel.atividade.atividadeApi.repository.UsuarioRepository;
import Gabriel.atividade.atividadeApi.repository.UsuarioVerificadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioVerificadorRepository usuarioVerificadorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public List<UserDto> listarTodos(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        System.out.println("entrou no usuario");
        return usuarios.stream().map(UserDto::new).toList();
    }

    public void inserir(UserDto usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuarioEntity);
    }
    //gerado com gpt
    public void inserirNovoUsuario(UserDto usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
        usuarioEntity.setId(null);
        usuarioRepository.save(usuarioEntity);

        UsuarioVerificadorEntity verificador = new UsuarioVerificadorEntity();
        verificador.setUsuario(usuarioEntity);
        verificador.setUuid(UUID.randomUUID());
        verificador.setDataExpiracao(Instant.now().plusMillis(900000));
        usuarioVerificadorRepository.save(verificador);

        //todo - enviar um email para verificar a conta
        emailService.enviarEmailTexto(usuario.getEmail(),
                "Novo usuário cadastrado",
                "Você está recebendo um email de cadastro o número para validação é " + verificador.getUuid());

    }


    //verifica o cadastro
    public String verificarCadastro(String uuid) {

        UsuarioVerificadorEntity usuarioVerificacao = usuarioVerificadorRepository.findByUuid(UUID.fromString(uuid)).get();

        if(usuarioVerificacao != null) {
            if(usuarioVerificacao.getDataExpiracao().compareTo(Instant.now()) >= 0) {

                UsuarioEntity u = usuarioVerificacao.getUsuario();
                u.setSituacao(TipoSituacaoUsuario.ATIVO);

                usuarioRepository.save(u);

                return "Usuário Verificado";
            }else {
                usuarioVerificadorRepository.delete(usuarioVerificacao);
                return "Tempo de verificação expirado";
            }
        }else {
            return "Usuario não verificado";
        }

    }

    public UserDto alterar(UserDto usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return new UserDto(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public UserDto buscarPorId(Long id) {
        return new UserDto(usuarioRepository.findById(id).get());
    }
}