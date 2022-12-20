package mirea.example.learningenglishmanagementsystem.services;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.dto.PopularWordsDTO;
import mirea.example.learningenglishmanagementsystem.dto.WordDTO;
import mirea.example.learningenglishmanagementsystem.exception.WordNotFoundException;
import mirea.example.learningenglishmanagementsystem.models.Word;
import mirea.example.learningenglishmanagementsystem.repositories.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    public List<Word> search(String search) {
       return wordRepository.findByWordStartingWith(search);
    }

    public Word findOne(Integer wordId) {
        return wordRepository.findById(wordId)
                .orElseThrow(() -> new WordNotFoundException("Word not found"));
    }

    public Set<PopularWordsDTO> getPopularWords() {
        return wordRepository.getPopularWords();
    }

}
