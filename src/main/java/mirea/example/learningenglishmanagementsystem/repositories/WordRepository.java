package mirea.example.learningenglishmanagementsystem.repositories;


import mirea.example.learningenglishmanagementsystem.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface WordRepository extends JpaRepository<Word, Integer> {

}
