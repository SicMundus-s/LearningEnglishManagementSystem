package mirea.example.learningenglishmanagementsystem.controllers;

import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.services.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/simple-english")
public class WordController {

    private final WordService wordService;
    private final ModelMapper modelMapper;

    public WordController(WordService wordService, ModelMapper modelMapper) {
        this.wordService = wordService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/1000-popular-words")
    public String findOne(@ModelAttribute("user") User user) {
        return "lastWordPassed";
    };

}
