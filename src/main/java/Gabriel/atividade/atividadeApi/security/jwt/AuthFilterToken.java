package Gabriel.atividade.atividadeApi.security.jwt;

import Gabriel.atividade.atividadeApi.service.UserDetailServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthFilterToken extends OncePerRequestFilter {

    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtil;

    //ta dando problema o chat disse pra acressentar isso não sei se ta certo
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("entrou no token");
        try {
            System.out.println("entrou no token");
            String jwt = getToken(request);
            if(jwt != null && jwtUtil.validateJwtToken(jwt)) {

                String username = jwtUtil.getUsernameToken(jwt);

                UserDetails userDetails = userDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,  null, userDetails.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        }catch(Exception e) {
            System.out.println("Ocorreu um erro ao proecssar o token");
        }finally {

        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String headerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer")) {
            System.out.println("entrou no token");
            return headerToken.replace("Bearer ","");
        }
        return null;
    }

}