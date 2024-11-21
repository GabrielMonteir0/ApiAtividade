package Gabriel.atividade.atividadeApi.service;

import Gabriel.atividade.atividadeApi.entity.UsuarioEntity;
import Gabriel.atividade.atividadeApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//o chat tambem reclama dessa classe mas ainda não entendi o porque
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByLogin(username).get();
        System.out.println("entrou no service");
        return UserDetailsImpl.build(usuario);
    }

}
