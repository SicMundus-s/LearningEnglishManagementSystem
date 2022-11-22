package mirea.example.learningenglishmanagementsystem.security;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.models.Role;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityRole implements GrantedAuthority {

    private final Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }
}
