package mirea.example.learningenglishmanagementsystem.repositories;


import mirea.example.learningenglishmanagementsystem.dto.PopularWordsDTO;
import mirea.example.learningenglishmanagementsystem.dto.WordDTO;
import mirea.example.learningenglishmanagementsystem.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Set;


public interface WordRepository extends JpaRepository<Word, Integer> {

    List<Word> findByWordStartingWith(String word);


    @Query(nativeQuery = true, name = "FindPopularWordsDTO")
    Set<PopularWordsDTO> getPopularWords();
}
