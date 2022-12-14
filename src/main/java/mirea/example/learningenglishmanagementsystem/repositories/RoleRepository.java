package mirea.example.learningenglishmanagementsystem.repositories;

import mirea.example.learningenglishmanagementsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);

}
