package pl.edu.agh.tai.application.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.edu.agh.tai.application.exception.MissingDataException;
import pl.edu.agh.tai.application.service.UserService;
import pl.edu.agh.tai.dbmodel.repository.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static pl.edu.agh.tai.application.security.SecurityConstants.EXPIRATION_TIME;
import static pl.edu.agh.tai.application.security.SecurityConstants.HEADER_STRING;
import static pl.edu.agh.tai.application.security.SecurityConstants.TOKEN_PREFIX;
import static pl.edu.agh.tai.application.security.SecurityConstants.SECRET;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            UserCredentials creds = new ObjectMapper()
                .readValue(req.getInputStream(), UserCredentials.class);

            return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    creds.getUsername(),
                    creds.getPassword(),
                    new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String username = ((User) (auth.getPrincipal())).getUsername();
        Long id = userRepository.findByUsername(username)
            .orElseThrow(() -> new MissingDataException("No user with name" + username))
            .getId();
        String token = JWT.create()
            .withSubject(((User) auth.getPrincipal()).getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .withClaim("id", id)
            .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }
}