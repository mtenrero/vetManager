package es.urjc.etsii.mtenrero;

import es.urjc.etsii.mtenrero.Entities.User;
import es.urjc.etsii.mtenrero.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by was12 on 14/03/2017.
 */
@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        User user = userRepository.findByName(auth.getName());
        if (user == null) {
            throw new BadCredentialsException("User not found");
        }
        String password = (String) auth.getCredentials();
        if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
            throw new BadCredentialsException("Wrong password");
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        for (String role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return new UsernamePasswordAuthenticationToken(user.getName(), password, roles);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}