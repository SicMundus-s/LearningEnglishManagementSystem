package mirea.example.learningenglishmanagementsystem.services;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.models.Role;
import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.repositories.RoleRepository;
import mirea.example.learningenglishmanagementsystem.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final WordService wordService;
    private final RoleRepository roleRepository;

    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));

        user.setPopularWordId(wordService.getWordById(1));

        userRepository.save(user);
    }

    public User findByLogin(String username) {
        return userRepository.findByLogin(username);
    }
}
