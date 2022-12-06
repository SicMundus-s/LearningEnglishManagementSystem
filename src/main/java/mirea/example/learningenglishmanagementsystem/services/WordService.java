package mirea.example.learningenglishmanagementsystem.services;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.models.Word;
import mirea.example.learningenglishmanagementsystem.repositories.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    public List<Word> findAll() {
        return wordRepository.findAll();
    }

}
