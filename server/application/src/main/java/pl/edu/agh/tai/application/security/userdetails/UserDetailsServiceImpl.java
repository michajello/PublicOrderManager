package pl.edu.agh.tai.application.security.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.agh.tai.application.exception.MissingDataException;
import pl.edu.agh.tai.dbmodel.entity.User;
import pl.edu.agh.tai.dbmodel.repository.UserRepository;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(MissingDataException::new);
        return org.springframework.security.core.userdetails.User.
            withUsername(user.getUsername()).
            password(user.getPassword()).
            authorities(Collections.emptyList()).
            build();
    }

}
