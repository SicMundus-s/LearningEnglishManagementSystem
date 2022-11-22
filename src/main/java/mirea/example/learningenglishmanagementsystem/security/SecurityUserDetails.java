package mirea.example.learningenglishmanagementsystem.security;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.models.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityUserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final User user;


    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()   {
        return user.getRoles()
                .stream()
                .map(SecurityRole::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
