package mirea.example.learningenglishmanagementsystem.repositories;


import mirea.example.learningenglishmanagementsystem.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {

}
