package mirea.example.learningenglishmanagementsystem.services;


import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.repositories.UserRepository;
import mirea.example.learningenglishmanagementsystem.security.SecurityUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var u = userRepository.findUserByLogin(login);

        return u.map(SecurityUserDetails::new)
                        .orElseThrow(() -> new UsernameNotFoundException("Username not found " + login));
    }
}
