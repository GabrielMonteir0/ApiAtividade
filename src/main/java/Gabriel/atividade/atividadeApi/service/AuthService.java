package Gabriel.atividade.atividadeApi.service;

import Gabriel.atividade.atividadeApi.dto.AcessDto;
import Gabriel.atividade.atividadeApi.dto.AuthenticationDto;
import Gabriel.atividade.atividadeApi.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticatioManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDto login(AuthenticationDto authDto) {

        try {
            //Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());

            //Prepara mecanismo para autenticacao
            Authentication authentication = authenticatioManager.authenticate(userAuth);

            //Busca usuario logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDto accessDto = new AcessDto(token);

            return accessDto;

        }catch(BadCredentialsException e) {
            //TODO LOGIN OU SENHA INVALIDO
        }
        return new AcessDto("Acesso negado");
    }
}
